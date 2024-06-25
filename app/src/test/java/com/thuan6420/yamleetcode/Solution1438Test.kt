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
}