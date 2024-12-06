package com.thuan6420.yamleetcode

class Solution1072 {
    fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {
//        val des: (IntArray) -> List<Int> = { it.map { i -> i xor it[0] } }
//        return matrix.groupingBy { des(it) }.eachCount().values.maxOrNull() ?: 0
//
        val count = matrix[0].size
        val map = mutableMapOf<String, Int>()
        var result = 0
        for (row in matrix) {
            val arr = CharArray(count)
            for (i in row.indices) {
                arr[i] = (row[0] xor row[i]).toChar()
            }
            val pattern = String(arr)
            map[pattern] = map.getOrDefault(pattern, 0) + 1
            result = maxOf(result, map[pattern]!!)
        }
        return result
    }
}