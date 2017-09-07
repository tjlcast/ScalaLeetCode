package com.tjlcast.LeetCode

/**
  * Created by tangjialiang on 2017/9/7.
  */
object _51_N_Queens {
    def main(args: Array[String]): Unit = {
        val n = 4

        val matrixs = Solution.work(n)

        println("work is: ")
        for(matrix <- matrixs) {
            println("a Solution: ")
            for(row <- matrix) {
                println(row)
            }
            println()
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    import scala.collection.mutable
    import scala.collection.mutable.ArrayBuffer

    object Solution {
        def work(n: Int): List[List[String]] = {
            return solveNQueens(n)
        }

        def solveNQueens(n: Int): List[List[String]] = {
            val solution = new Solution(n)
            return solution.solveNQueens(n)
        }
    }

    class Solution(n: Int) {
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
