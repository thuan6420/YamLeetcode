package com.thuan6420.yamleetcode

import junit.framework.TestCase.assertEquals
import org.junit.Test

class Solution1072Test {
    private val solution1072 = Solution1072()

    @Test
    fun testCase1() {
        val matrix = arrayOf(intArrayOf(0, 1), intArrayOf(1, 1))
        val result = solution1072.maxEqualRowsAfterFlips(matrix)
        assertEquals(1, result)
    }

    @Test
    fun testCase2() {
        val matrix = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))
        val result = solution1072.maxEqualRowsAfterFlips(matrix)
        assertEquals(2, result)
    }

    @Test
    fun testCase3() {
        val matrix = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 1), intArrayOf(1, 1, 0))
        val result = solution1072.maxEqualRowsAfterFlips(matrix)
        assertEquals(2, result)
    }

    @Test
    fun testCase4() {
        // [[1,0,0,0,1,1,1,0,1,1,1],[1,0,0,0,1,0,0,0,1,0,0],[1,0,0,0,1,1,1,0,1,1,1],[1,0,0,0,1,0,0,0,1,0,0],[1,1,1,0,1,1,1,0,1,1,1]]
        val matrix = arrayOf(
            intArrayOf(1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1),
            intArrayOf(1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0),
            intArrayOf(1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1),
            intArrayOf(1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0),
            intArrayOf(1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1)
        )
        val result = solution1072.maxEqualRowsAfterFlips(matrix)
        assertEquals(2, result)
    }
}