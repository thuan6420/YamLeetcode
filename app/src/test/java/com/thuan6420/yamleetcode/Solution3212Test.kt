package com.thuan6420.yamleetcode

import junit.framework.TestCase.assertEquals
import org.junit.Test

class Solution3212Test {
    private val solution = Solution3212()

    @Test
    fun test_1() {
        val grid = arrayOf(
            charArrayOf('X', 'Y', '.'),
            charArrayOf('Y', '.', '.')
        )
        val result = solution.numberOfSubmatrices(grid)
        assertEquals(3, result)
    }

    @Test
    fun test_2() {
        val grid = arrayOf(
            charArrayOf('X', 'X'),
            charArrayOf('X', 'Y')
        )
        val result = solution.numberOfSubmatrices(grid)
        assertEquals(0, result)
    }

    @Test
    fun test_3() {
        val grid = arrayOf(
            charArrayOf('.', '.'),
            charArrayOf('.', '.'))
        val result = solution.numberOfSubmatrices(grid)
        assertEquals(0, result)
    }
}