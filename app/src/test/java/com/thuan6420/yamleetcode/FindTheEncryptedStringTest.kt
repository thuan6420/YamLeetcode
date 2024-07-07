package com.thuan6420.yamleetcode

import junit.framework.TestCase.assertEquals
import org.junit.Test

class FindTheEncryptedStringTest {
    private val solver = FindTheEncryptedString()

    @Test
    fun testGetEncryptedString_1() {
        val result = solver.getEncryptedString("dart", 3)
        assertEquals("tdar", result)
    }

    @Test
    fun testGetEncryptedString_2() {
        val result = solver.getEncryptedString("aaa", 1)
        assertEquals("aaa", result)
    }
}