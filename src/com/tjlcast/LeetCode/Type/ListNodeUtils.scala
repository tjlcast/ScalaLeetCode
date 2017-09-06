package com.tjlcast.LeetCode.Type

/**
  * Created by tangjialiang on 2017/9/6.
  */
object ListNodeUtils {
    def buildList(array: Array[Int]): ListNode = {
        val root: ListNode = new ListNode(-1)
        var tail = root

        for(i <- array) {
            val node = new ListNode(i)
            tail.next = node
            tail = tail.next
        }

        return root.next
    }

    def printList(node: ListNode): Unit = {
        var tail = node
        print("print a list: ")
        while(tail != null) {
            print(tail.x + " ")
            tail = tail.next
        }
        println()
    }
}
