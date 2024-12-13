package com.thuan6420.yamleetcode

import junit.framework.TestCase.assertEquals
import org.junit.Test

class Solution2554Test {
    @Test
    fun testCase1() {
        val banned = intArrayOf(1, 6, 5)
        val n = 5
        val maxSum = 6
        val expected = 2
        val result = Solution2554().maxCount(banned, n, maxSum)
        assertEquals(expected, result)
    }

    @Test
    fun testCase2() {
        val banned = intArrayOf(1,2,3,4,5,6,7)
        val n = 8
        val maxSum = 1
        val expected = 0
        val result = Solution2554().maxCount(banned, n, maxSum)
        assertEquals(expected, result)
    }

    @Test
    fun testCase3() {
        val banned = intArrayOf(11)
        val n = 7
        val maxSum = 50
        val expected = 7
        val result = Solution2554().maxCount(banned, n, maxSum)
        assertEquals(expected, result)
    }
}