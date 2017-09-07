package com.tjlcast.LeetCode

import com.tjlcast.LeetCode.Type.{ListNode, ListNodeUtils}

/**
  * Created by tangjialiang on 2017/9/6.
  */
object _2_Add_Two_Numbers {
    def main(args: Array[String]): Unit = {
        val arr1 = Array(0, 8)
        val arr2 = Array(0, 2)
        val l1 = ListNodeUtils.buildList(arr1)
        val l2 = ListNodeUtils.buildList(arr2)

        val node: ListNode = Solution.addTwoNumbers(l1, l2)

        println("work is: ")
        ListNodeUtils.printList(node)
    }

    object Solution {
        def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
            val solution: Solution = new Solution()
            val ans = solution.addTwoNumbers(l1, l2)
            return ans
        }
    }


    class Solution {

        val root = new ListNode(-1)
        var tail = root

        def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
            // todo tjl
            addVal(Option(l1).collect({case n:ListNode if n!=null => n}), Option(l2).collect({case n:ListNode if n!=null => n}), 0)
            if (root.next == null) {
                root.next = new ListNode(0)
            }

            return root.next
        }

        def addVal(l1: Option[ListNode], l2: Option[ListNode], carr: Integer): Unit = {
            // todo tjl
            val val1 = l1 match {
                case Some(node) => node.x
                case None => 0
            }
            val val2 = l2 match {
                case Some(node) => node.x
                case None => 0
            }

            val total = val1 + val2 + carr

            if ((l1 isEmpty) && (l2 isEmpty) && total==0) return ()

            val node = new ListNode(total % 10)
            tail.next = node
            tail = tail.next

            addVal(l1.collect({case n: ListNode if n.next!=null => n.next}), l2.collect({case n: ListNode if n.next!=null => n.next}), total/10)
        }
    }
}

