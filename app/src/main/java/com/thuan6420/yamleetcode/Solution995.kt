package com.thuan6420.yamleetcode

// 995. Minimum Number of K Consecutive Bit Flips in LeetCode
class Solution995 {
    fun minKBitFlips(nums: IntArray, k: Int): Int {
        val isNeedFlip: (Int) -> Boolean = { idx ->
            nums[idx] == BIT_0
        }
        val isImpossibleFlip: (Int) -> Boolean = { idx ->
            nums.size - idx < k
        }
        var res = 0
        val flip: (Int) -> Unit = { startIdx ->
            for (i in startIdx until startIdx + k) {
                nums[i] = nums[i] xor BIT_1
            }
            res++
        }
        var idx = 0
        while (idx < nums.size) {
            if (isNeedFlip(idx)) {
                if (isImpossibleFlip(idx)) {
                    return -1
                }
                flip(idx)
            }
            idx++
        }
        return res
    }

    companion object {
        const val BIT_1 = 1
        const val BIT_0 = 0
    }
}