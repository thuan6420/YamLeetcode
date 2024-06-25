package com.thuan6420.yamleetcode

import junit.framework.TestCase.assertEquals
import org.junit.Test

class Solution995Test {
    private val solution995 = Solution995()

    @Test
    fun test_1() {
        val result = solution995.minKBitFlips(intArrayOf(0, 1, 0), 1)
        assertEquals(2, result)
    }

    @Test
    fun test_2() {
        val result = solution995.minKBitFlips(intArrayOf(1, 1, 0), 2)
        assertEquals(-1, result)
    }

    @Test
    fun test_3() {
        val result = solution995.minKBitFlips(intArrayOf(0, 0, 0, 1, 0, 1, 1, 0), 3)
        assertEquals(3, result)
    }
}