package com.thuan6420.yamleetcode

// 3211. Generate Binary Strings Without Adjacent Zeros
class Solution3211 {
    fun validStrings(n: Int): List<String> {
        when (n) {
            1 -> return listOf(BIT_0, BIT_1)
            2 -> return listOf(BIT_0 + BIT_1, BIT_1 + BIT_0, BIT_1 + BIT_1)
            else -> {
                val result = mutableListOf<String>()
                val prev = validStrings(n - 1)
                for (str in prev) {
                    if (str.last().toString() == BIT_1) {
                        result.add(str + BIT_0)
                    }
                    result.add(str + BIT_1)
                }
                return result
            }
        }
    }

    companion object {
        const val BIT_0 = "0"
        const val BIT_1 = "1"
    }
}