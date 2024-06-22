package com.thuan6420.yamleetcode

import kotlin.math.abs

// 9. Palindrome Number in LeetCode
class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        val xString = x.toString()
        val isEven = xString.length % 2 == 0
        if (isEven) {
            val half = xString.length / 2
            val firstHalf = xString.substring(0, half)
            val secondHalf = xString.substring(half, xString.length)
            return firstHalf == secondHalf.reversed()
        } else {
            val half = xString.length / 2
            val firstHalf = xString.substring(0, half)
            val secondHalf = xString.substring(half + 1, xString.length)
            return firstHalf == secondHalf.reversed()
        }
    }
}