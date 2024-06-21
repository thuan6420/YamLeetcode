package com.thuan6420.yamleetcode

// 1. Two Sum in LeetCode
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val getNumFromIndex: (Int) -> Int = { idx -> nums[idx] }
        val indexChecked = mutableListOf<Int>()
        nums.forEachIndexed { idx, num ->
            val numToFind = target - num
            for (i in indexChecked) {
                if (numToFind == getNumFromIndex(i)) {
                    return if (i < idx) intArrayOf(i, idx) else intArrayOf(idx, i)
                }
            }
            indexChecked.add(idx)
        }
        return intArrayOf()
    }
}