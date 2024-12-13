package com.thuan6420.yamleetcode

// 2554. Maximum Number of Integers to Choose From a Range I (https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/description/?envType=daily-question&envId=2024-12-06)

class Solution2554 {
    fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
        val bannedMap = BooleanArray(MAX_LENGTH)
        var result = 0
        var sum = 0
        for (i in banned) {
            bannedMap[i] = true
        }
        for (i in 1..n) {
            if (bannedMap[i]) {
                continue
            }
            sum += i
            if (sum <= maxSum) {
                result++
            } else {
                break
            }
        }
        return result
    }

    companion object {
        const val MAX_LENGTH = 10001
    }
}