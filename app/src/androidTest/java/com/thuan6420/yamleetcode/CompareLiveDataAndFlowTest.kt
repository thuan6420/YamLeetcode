package com.thuan6420.yamleetcode

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

import org.junit.Rule
import org.junit.Test

import java.util.Collections

import kotlin.jvm.JvmField
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class CompareLiveDataAndFlowTest {
    // Run tasks synchronously
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()
    // Sets the main coroutines dispatcher to a TestCoroutineScope for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val liveDataList = Collections.synchronizedList(ArrayList<Int>(TOTAL_ITEMS))
    private val stateFlowList = Collections.synchronizedList(ArrayList<Int>(TOTAL_ITEMS))
    private val sharedFlowList: MutableList<Int> = Collections.synchronizedList(ArrayList<Int>(
        TOTAL_ITEMS
    ))
    private val liveData = MutableLiveData(0)
    private val stateFlow = MutableStateFlow(0)
    private val sharedFlow = MutableSharedFlow<Int>(extraBufferCapacity=10, onBufferOverflow= BufferOverflow.DROP_OLDEST)

    @Test
    fun testLiveObjKotlin() {
        val scope = CoroutineScope(Dispatchers.Default)
        scope.launch {
            liveData.observeForever { value -> liveDataList.add(value) }
        }
        scope.launch {
            stateFlow.collect { value -> stateFlowList.add(value) }
        }
        scope.launch {
            sharedFlow.collect { value -> sharedFlowList.add(value) }
        }
        runBlocking {
            for (idx in 1..4) {
                Log.d( "test", "--- [run# ${idx}] ---")
                liveDataList.clear()
                stateFlowList.clear()
                sharedFlowList.clear()
                testObjAsync(
                        "LiveData",
                        { value: Int -> liveData.postValue(value) },
                { liveDataList.size })
                testObjAsync(
                        "StateFlow",
                        { value: Int -> stateFlow.tryEmit(value) },
                { stateFlowList.size })
                testObjAsync(
                        "SharedFlow",
                        { value: Int -> sharedFlow.tryEmit(value) },
                { sharedFlowList.size })
            }
            Log.d( "test", "--- [Done] ---")
            Log.d( "test", "theoretical capture size=$TOTAL_ITEMS")
        }
    }
    private suspend fun testObjAsync(title:String, setValue: (Int) -> (Unit), getValue: () -> Int) {
        val startMilli = System.currentTimeMillis()
        var threadStart = 0
        (1..MAX_THREADS).map {
            CoroutineScope(Dispatchers.Default).async {
                for (idx in 1..MAX_ITEMS) {
                    setValue(threadStart + 1)
                }
            }
        }.awaitAll()
        val elapsedMilli = System.currentTimeMillis() - startMilli
        val value = getValue()
        Log.d( "test", "${title}=${value} ElapsedMilli=${elapsedMilli}")
    }

    companion object {
        const val MAX_THREADS = 1
        const val MAX_ITEMS = 1
        const val TOTAL_ITEMS = MAX_THREADS * MAX_ITEMS
    }
}

class MainCoroutineRule
@OptIn(ExperimentalCoroutinesApi::class)
constructor(
    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher(),
) : TestWatcher() {
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun starting(description: Description) {
        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun finished(description: Description) {
        Dispatchers.resetMain()
    }
}