package com.tjlcast.LeetCode

/**
  * Created by tangjialiang on 2017/9/7.
  */
object _53_Maximum_Subarray {

    def main(args: Array[String]): Unit = {
        val arr: Array[Int] = Array(-2)

        val ans = Solution.work(arr)

        println("work is: " + ans)
    }

    object Solution {

        def work(nums: Array[Int]): Int = {
            return maxSubArray(nums)
        }

        def maxSubArray(nums: Array[Int]): Int = {
            val solution = new Solution()
            return solution.maxSubArray(nums)
        }
    }

    class Solution {
        private var maxVal: Int = Int.MinValue

        def maxSubArray(nums: Array[Int]): Int = {
            var lastSum: Int = 0 // before compution result

            for(num <- nums) {
                lastSum += num

                if (maxVal < lastSum) maxVal = lastSum

                if (lastSum < 0) lastSum = 0
            }

            return maxVal
        }
    }
}
