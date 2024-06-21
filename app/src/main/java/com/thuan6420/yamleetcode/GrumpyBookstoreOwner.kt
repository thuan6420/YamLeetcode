package com.thuan6420.yamleetcode

// 1052. Grumpy Bookstore Owner in LeetCode
class GrumpyBookstoreOwner {
    fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
        val isSatisfied: (Int) -> Boolean = {
            grumpy[it] == SATISFIED
        }
        val numOfCustomerWithGrumpy: (Int, Boolean) -> Int = { customer, isGrumpy ->
            if (isGrumpy) customer else NO_CUSTOMER
        }
        val sumDissatisfied: (Int) -> Int = { index ->
            var sum = 0
            for (i in index until index + minutes) {
                if (isSatisfied(i).not()) sum += customers[i]
            }
            sum
        }

        var total = 0
        var maxInMinutes = 0
        customers.forEachIndexed { idx, customer ->
            total += numOfCustomerWithGrumpy(customer, isSatisfied(idx))
            if (idx + minutes <= customers.size) {
                val sum = sumDissatisfied(idx)
                if (sum > maxInMinutes) {
                    maxInMinutes = sum
                }
            }
        }
        return total + maxInMinutes
    }

    companion object {
        const val SATISFIED = 0
        const val NO_CUSTOMER = 0
    }
}