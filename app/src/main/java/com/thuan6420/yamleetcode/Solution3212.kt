package com.thuan6420.yamleetcode

// 3212. Count Submatrices With Equal Frequency of X and Y
class Solution3212 {
    fun numberOfSubmatrices(grid: Array<CharArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val prefixX = Array(m + 1) { IntArray(n + 1) }
        val prefixY = Array(m + 1) { IntArray(n + 1) }

        // Compute prefix sums for 'X' and 'Y'
        for (i in 1..m) {
            for (j in 1..n) {
                prefixX[i][j] = prefixX[i - 1][j] + prefixX[i][j - 1] - prefixX[i - 1][j - 1] + if (grid[i - 1][j - 1] == X) 1 else 0
                prefixY[i][j] = prefixY[i - 1][j] + prefixY[i][j - 1] - prefixY[i - 1][j - 1] + if (grid[i - 1][j - 1] == Y) 1 else 0
            }
        }

        var count = 0
        // Iterate over all possible submatrices that include grid[0][0]
        for (i2 in 1..m) {
            for (j2 in 1..n) {
                val xCount = prefixX[i2][j2]
                val yCount = prefixY[i2][j2]
                if (xCount == yCount && xCount > 0) count++
            }
        }

        return count
    }

    companion object {
        const val X = 'X'
        const val Y = 'Y'
    }
}