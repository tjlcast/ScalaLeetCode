package com.tjlcast.LeetCode

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * Created by tangjialiang on 2017/9/7.
  */
object _52_N_Queens_II {

    def main(args: Array[String]): Unit = {
        val n = 4 ;

        val ans = Solution.work(n)

        println("work is: " + ans)
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    import scala.collection.mutable
    import scala.collection.mutable.ArrayBuffer

    object Solution {
        def totalNQueens(n: Int): Int = {
            val solution = new Solution(n)
            return solution.totalNQueens(n)
        }

        def work(n: Int): Int = {
            return totalNQueens(n)
        }
    }

    class Solution(n: Int) {
        def totalNQueens(n: Int): Int = {
            return solveNQueens(n).length
        }

        private val len: Int = n
        private val ansList: ArrayBuffer[List[String]] = new ArrayBuffer[List[String]]()


        def solveNQueens(n: Int): List[List[String]] = {
            dfs(0, ArrayBuffer(0 until len:_*))
            return ansList.toList
        }

        def dfs(pos: Int, arr: ArrayBuffer[Int]): Unit = {
            if (pos == len) {
                val matrix = new ArrayBuffer[String]

                for(i <- 0 until len) {
                    val sb: mutable.StringBuilder = new mutable.StringBuilder()
                    for(j <- 0 until len) {
                        if (j == arr(i)) {
                            sb += 'Q'
                        } else {
                            sb += '.'
                        }
                    }
                    matrix += sb.toString()
                }
                ansList += matrix.toList
            }

            for(i <- pos until len){
                var swap = arr(pos)
                arr(pos) = arr(i)
                arr(i) = swap
                if (!canAttack(pos, arr)) dfs(pos+1, arr.slice(0, len))
            }
        }

        def canAttack(pos: Int, arr:ArrayBuffer[Int]): Boolean = {
            // the current position of queen is put
            val row = pos
            val col = arr(pos)

            for (i <- 0 until pos) {
                val j = arr(i)
                if (Math.abs(row-i) == Math.abs(col-j))
                    return true
            }
            return false ;
        }
    }
}
