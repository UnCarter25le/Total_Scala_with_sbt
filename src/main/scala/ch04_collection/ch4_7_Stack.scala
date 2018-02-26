package ch04_collection

object ch4_7_Stack extends App {


  /*
  *
  * stack 也有兩種，scala.collection.mutable.Stack  and  scala.collection.immutable.Stack
  *
  *
  * */


  import scala.collection.mutable.Stack

  println("================================")
  println("(1)初始化")

  val stack = new Stack[Int]

  val stack1 = Stack(1,2,3)

  println(stack)


  println(stack1)

  println("================================")
  println("(2)method")

  //存進元素，元素順序會相反
  println(stack.push(4,5,6))

  println(stack.push(1,2,3))

  //移出第一個元素
  println(stack1.top)

}
