package com.thuan6420.yamleetcode

import junit.framework.TestCase.assertEquals
import org.junit.Test

class Solution3213Test {
    private val solution100350 = Solution3213()

    @Test
    fun test_1() {
        val target = "abcdef"
        val words = arrayOf("abdef","abc","d","def","ef")
        val costs = intArrayOf(100,1,1,10,5)
        val result = solution100350.minimumCost(target, words, costs)
        assertEquals(7, result)
    }

    @Test
    fun test_2() {
        val target = "aaaa"
        val words = arrayOf("z","zz","zzz")
        val costs = intArrayOf(1,10,100)
        val result = solution100350.minimumCost(target, words, costs)
        assertEquals(-1, result)
    }
}