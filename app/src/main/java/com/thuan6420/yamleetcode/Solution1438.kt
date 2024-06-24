package com.thuan6420.yamleetcode

import java.util.Deque
import java.util.LinkedList
import kotlin.math.abs

// 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
class Solution1438 {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        val maxDeque: Deque<Int> = LinkedList()
        val minDeque: Deque<Int> = LinkedList()
        var result = 0
        var numChecking = 0
        while (numChecking < nums.size) {
            while (!maxDeque.isEmpty() && nums[numChecking] > nums[maxDeque.peekLast()]) {
                maxDeque.pollLast()
            }
            while (!minDeque.isEmpty() && nums[numChecking] < nums[minDeque.peekLast()]) {
                minDeque.pollLast()
            }

            maxDeque.offerLast(numChecking)
            minDeque.offerLast(numChecking)

            if (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] <= limit) {
                if (maxDeque.peekFirst() == result) {
                    maxDeque.pollFirst()
                }
                if (minDeque.peekFirst() == result) {
                    minDeque.pollFirst()
                }
                result++
            }
            numChecking++
        }
        return result
    }
}