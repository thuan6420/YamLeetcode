package com.thuan6420.yamleetcode

import java.util.Deque

// 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
class Solution1438 {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        val maxDeque: Deque<Int> = java.util.ArrayDeque()
        val minDeque: Deque<Int> = java.util.ArrayDeque()
        val isAbsoluteDiffLessThanLimit: (Int, Int) -> Boolean = { maxIndex, minIndex ->
            nums[maxIndex] - nums[minIndex] <= limit
        }
        val isGreater: (Int, Int) -> Boolean = { index1, index2 ->
            nums[index1] > nums[index2]
        }
        val isSmaller: (Int, Int) -> Boolean = { index1, index2 ->
            nums[index1] < nums[index2]
        }
        val ensureMax: (Int) -> Int = { index ->
            while (maxDeque.isNotEmpty() && isGreater(index, maxDeque.peekLast()!!)) {
                maxDeque.pollLast()
            }
            maxDeque.offerLast(index)
            maxDeque.peekFirst()!!
        }
        val ensureMin: (Int) -> Int = { index ->
            while (minDeque.isNotEmpty() && isSmaller(index, minDeque.peekLast()!!)) {
                minDeque.pollLast()
            }
            minDeque.offerLast(index)
            minDeque.peekFirst()!!
        }
        var numOfPositionNotMatch = 0
        val resolveIndexNotMatch = {
            if (maxDeque.peekFirst() == numOfPositionNotMatch) {
                maxDeque.pollFirst()
            }
            if (minDeque.peekFirst() == numOfPositionNotMatch) {
                minDeque.pollFirst()
            }
            numOfPositionNotMatch++
        }

        for (index in nums.indices) {
            if (isAbsoluteDiffLessThanLimit(ensureMax(index), ensureMin(index)).not()){
                resolveIndexNotMatch()
            }
        }
        return nums.size - numOfPositionNotMatch
    }
}