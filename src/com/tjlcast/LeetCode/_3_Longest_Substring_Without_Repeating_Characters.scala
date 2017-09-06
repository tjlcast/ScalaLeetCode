package com.tjlcast.LeetCode



/**
  * Created by tangjialiang on 2017/9/6.
  */
object _3_Longest_Substring_Without_Repeating_Characters {
    def main(args: Array[String]): Unit = {
        val str: String = "abba"

        val len = Solution.lengthOfLongestSubstring(str)

        println("result is: ")
        println(len)
    }

    import scala.collection.mutable

    object Solution {
        def lengthOfLongestSubstring(s: String): Int = {
            val solution = new Solution()
            val len = solution.lengthOfLongestSubstring(s)

            return len
        }

        def work(s: String): Int = {
            return lengthOfLongestSubstring(s)
        }
    }

    class Solution {
        private val map: mutable.HashMap[Char, Int] = new mutable.HashMap()
        private var maxLen = 0

        def lengthOfLongestSubstring(s: String): Int = {
            var r = 0 ;
            var l = 0 ;

            while(r < s.length) {
                val k = s.charAt(r)
                val v = r
                if (map.contains(k) && map(k)>=l) {
                    l = map(k) + 1
                    map(k) = r
                } else {
                    map(k) = v
                }

                 println("l: " + l + " r: " + r)
                maxLen = Math.max(maxLen, r-l+1) ;
                r += 1 ;
            }

            return maxLen
        }
    }
}