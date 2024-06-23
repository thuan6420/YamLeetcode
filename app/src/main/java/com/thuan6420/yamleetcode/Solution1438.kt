package com.thuan6420.yamleetcode

import kotlin.math.abs

// 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
class Solution1438 {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        var result = 0
        val isAbsoluteDiffLessThanLimit: (Int, Int) -> Boolean = { a, b -> abs(a - b) <= limit }
        val maxOfResult: (Int, Int) -> Int = { a, b -> if (a > b) a else b }
        val calculateResult: (Int, Int, Int) -> Int = { max, min, size ->
            if (isAbsoluteDiffLessThanLimit(max, min)) {
                size
            } else {
                0
            }
        }
        for (startIndex in nums.indices) {
            for (endIndex in startIndex until nums.size) {
                var max = nums[startIndex]
                var min = nums[startIndex]
                for (i in startIndex ..  endIndex) {
                    max = maxOf(max, nums[i])
                    min = minOf(min, nums[i])
                }
                result = maxOfResult(result, calculateResult(max, min, endIndex - startIndex + 1))
            }
        }
//        var startIndex = 0
//        while (startIndex < nums.size) {
//            var endIndex = startIndex
//            while (endIndex < nums.size) {
//                var max = nums[startIndex]
//                var min = nums[startIndex]
//                for (i in startIndex..endIndex) {
//                    max = maxOf(max, nums[i])
//                    min = minOf(min, nums[i])
//                }
//                result = maxOfResult(result, calculateResult(max, min, endIndex - startIndex + 1))
//                endIndex++
//            }
//            startIndex++
//        }
        return result
    }
}