package com.thuan6420.yamleetcode

import junit.framework.TestCase.assertEquals
import org.junit.Test

class Solution1438Test {
    private val solution = Solution1438()

    @Test
    fun testLongestSubarray() {
        val nums = intArrayOf(8, 2, 4, 7)
        val limit = 4
        val expected = 2
        val result = solution.longestSubarray(nums, limit)
        assertEquals(expected, result)
    }

    @Test
    fun testLongestSubarray2() {
        val nums = intArrayOf(10, 1, 2, 4, 7, 2)
        val limit = 5
        val expected = 4
        val result = solution.longestSubarray(nums, limit)
        assertEquals(expected, result)
    }

    @Test
    fun testLongestSubarray3() {
        val nums = intArrayOf(4, 2, 2, 2, 4, 4, 2, 2)
        val limit = 0
        val expected = 3
        val result = solution.longestSubarray(nums, limit)
        assertEquals(expected, result)
    }
}