package com.tjlcast.LeetCode

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * Created by tangjialiang on 2017/9/5.
  */
object _1_Two_Sum {
    def main(args: Array[String]): Unit = {
        val nums: Array[Int] = Array(3, 3)
        val target = 6

        val ans:Array[Int] = work(nums, target)

        println("work is: ")
        for(num <- ans) {
            print(num + " ")
        }
    }

    def work(nums: Array[Int], target: Int): Array[Int] = {
        val work = Solution.twoSum(nums, target)
        return work
    }

    object Solution {
        val ans = new ArrayBuffer[Int]()

        def twoSum(nums: Array[Int], target: Int): Array[Int] = {
            val map = new mutable.HashMap[Integer, Integer]()

            for((v, p) <- nums.zipWithIndex) { // todo tjl
                val reminder = target - v
                if (map.contains(reminder)) {
                    ans += (map(reminder), p)
                } else {
                    map(v) = p
                }
            }

            return ans.toArray
        }
    }

}


