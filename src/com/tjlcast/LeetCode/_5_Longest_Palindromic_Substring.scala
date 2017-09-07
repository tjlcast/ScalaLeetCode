package com.tjlcast.LeetCode

/**
  * Created by tangjialiang on 2017/9/7.
  */
object _5_Longest_Palindromic_Substring {

    def main(args: Array[String]): Unit = {
        val str: String = "abcba"
        val ans = Solution.work(str)

        println("work is: " + ans)
    }

    object Solution {
        def work(s: String): String = {
            val str = longestPalindrome(s)
            return str
        }

        def longestPalindrome(s: String): String = {
            val solution = new Solution(s)
            val str = solution.longestPalindrome(s)
            return str
        }
    }

    class Solution(s: String) {
        private val len = s.length
        private var l = 0
        private var r = 0
        private var maxLen = 0
        private val dp = Array.ofDim[Int](s.length, s.length) // todo tjl

        def longestPalindrome(s: String): String = {
            initial(s)

            for(k <- 2 to len) {
                for(i <- 0 until len+1-k) { // todo tjl
                    val j = i + k - 1
                    if (dp(i)(j) == -1) {
                        if (s.charAt(i)==s.charAt(j) && dp(i+1)(j-1)==1){
                            dp(i)(j) = 1
                            maxLen = if(maxLen < j-i+1) {l=i; r=j; j-i+1} else {maxLen} // todo tjl
                        }
                    }
                }
            }

            return s.substring(l, r+1)
        }

        def initial(s: String): Unit = {
            for(i <-0 until len ; j <- 0 until len) {
                if (i == j) {
                    dp(i)(j) = 1
                    maxLen = if(maxLen < 1) {l=i; r=j; j-i+1} else {maxLen}
                }else if (j-i==1 && s.charAt(i)==s.charAt(j)) {
                    dp(i)(j) = 1
                    maxLen = if(maxLen < 2) {l=i; r=j; j-i+1} else {maxLen}
                }else {
                    dp(i)(j) = -1
                }
            }
        }
    }
}
