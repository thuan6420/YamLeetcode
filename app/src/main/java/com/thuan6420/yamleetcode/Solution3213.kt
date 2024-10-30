package com.thuan6420.yamleetcode

import java.util.PriorityQueue

// 3213. Construct String with Minimum Cost (https://leetcode.com/problems/construct-string-with-minimum-cost/)
/*
 * Solution:
 * - Dynamic Programming
 * - String Hashing or Aho-Corasick Algorithm
 *  + String Hashing: https://cp-algorithms.com/string/string-hashing.html
 *      => Rabin-Karp Algorithm: https://cp-algorithms.com/string/rabin-karp.html
 *  + Aho-Corasick Algorithm: https://cp-algorithms.com/string/aho_corasick.html
 *
 */
class Solution3213 {
    class PrefixTree {

        private class Node {
            val children: Array<Node?> = Array(26) { null }
            var cost: Int = Int.MAX_VALUE
        }

        private val root = Node()

        fun add(s: String, c: Int) {
            add(root, s, c, 0)
        }

        private tailrec fun add(root: Node, s: String, c: Int, i: Int) {
            if (i >= s.length) {
                return
            }

            val j = s[i].code - 'a'.code
            if (root.children[j] == null) {
                root.children[j] = Node()
            }

            val child = root.children[j]!!

            if (i == s.length - 1) {
                child.cost = minOf(child.cost, c)
                return
            }

            add(child, s, c, i + 1)
        }

        fun minCost(target: String): Int {
            val dp = IntArray(target.length) { Int.MAX_VALUE }
            return minCost(dp, target, 0)
        }

        private fun minCost(dp: IntArray, target: String, i: Int): Int {
            if (dp[i] != Int.MAX_VALUE) {
                return dp[i]
            }
            val c = minCost(dp, root, target, i)
            dp[i] = if (c == Int.MAX_VALUE) -1 else c
            return dp[i]
        }

        private fun minCost(dp: IntArray, head: Node, target: String, i: Int): Int {
            if (i >= target.length) {
                return Int.MAX_VALUE
            }

            val j = target[i].code - 'a'.code
            val child = head.children[j] ?: return Int.MAX_VALUE

            if (i == target.length - 1) {
                return child.cost
            }

            var min = Int.MAX_VALUE
            if (child.cost != Int.MAX_VALUE) {
                val c = minCost(dp, target, i + 1)
                if (c != -1) {
                    min = child.cost + c
                }
            }

            min = minOf(min, minCost(dp, child, target, i + 1))
            return min
        }
    }

    fun minimumCost(target: String, words: Array<String>, costs: IntArray): Int {
        val n = words.size

        val pt = PrefixTree()
        for (i in 0 until n) {
            pt.add(words[i], costs[i])
        }

        return pt.minCost(target)
    }
}