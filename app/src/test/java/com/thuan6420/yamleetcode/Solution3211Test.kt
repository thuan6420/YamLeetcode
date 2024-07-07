package com.thuan6420.yamleetcode

import junit.framework.TestCase.assertEquals
import org.junit.Test

class Solution3211Test {
    private val solution = Solution3211()

    @Test
    fun test_1() {
        val n = 3
        val result = solution.validStrings(n)
        assertEquals(listOf("010","011","101","110","111"), result)
    }

    @Test
    fun test_2() {
        val n = 1
        val result = solution.validStrings(n)
        assertEquals(listOf("0","1"), result)
    }
}