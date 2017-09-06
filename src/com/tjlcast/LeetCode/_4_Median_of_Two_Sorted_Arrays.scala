package com.tjlcast.LeetCode

/**
  * Created by tangjialiang on 2017/9/6.
  */
object _4_Median_of_Two_Sorted_Arrays {

    def main(args: Array[String]): Unit = {
        val nums1 = Array(1, 2, 3)
        val nums2 = Array(2, 3, 4)

        val ans = Solution.work(nums1, nums2)

        println("work is: ")
        println(ans)
    }

    object Solution {
        def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
            val solution = new Solution()
            return solution.findMedianSortedArrays(nums1, nums2)
        }

        def work(nums1: Array[Int], nums2: Array[Int]): Double = {
            return findMedianSortedArrays(nums1, nums2)
        }
    }

    class Solution {
        def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
            val numsLen: Int = nums1.length + nums2.length
            if (numsLen % 2 == 0) {
                val num1: Int = findKInArrs(nums1, nums2, numsLen/2)
                val num2: Int = findKInArrs(nums1, nums2, numsLen/2 + 1)
                return (num1+num2).toDouble/2.toDouble
            } else {
                val num1: Int = findKInArrs(nums1, nums2, numsLen/2 + 1)
                return num1
            }
        }

        def findKInArrs(nums1: Array[Int], nums2: Array[Int], k: Int): Int = {

            if (nums1.length==0 && nums2.length==0) return -1 ;
            if (k==1) return Math.min(if (nums1.length!=0) nums1(0) else Int.MaxValue, if (nums2.length!=0) nums2(0) else Int.MaxValue)

            val workPos = k/2-1
            val val1 = if (nums1.length!=0) nums1(workPos % nums1.length) else Int.MaxValue
            val val2 = if (nums2.length!=0) nums2(workPos % nums2.length) else Int.MaxValue

            if (val1 <= val2) {
                return findKInArrs(nums1.slice(workPos%nums1.length+1, nums1.length), nums2, k-workPos%nums1.length-1)
            } else  {
                return findKInArrs(nums1, nums2.slice(workPos%nums2.length+1, nums2.length), k-workPos%nums2.length-1)
            }


        }
    }

}
