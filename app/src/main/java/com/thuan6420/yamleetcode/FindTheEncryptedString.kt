package com.thuan6420.yamleetcode

// 100339. Find the Encrypted String
class FindTheEncryptedString {
    fun getEncryptedString(s: String, k: Int): String {
        val n = s.length
        val encrypted = CharArray(n)
        for (i in s.indices) {
            encrypted[i] = s[(i + k) % n]
        }
        return String(encrypted)
    }
}