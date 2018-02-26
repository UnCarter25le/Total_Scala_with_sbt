package ch04_collection

object ch4_6_Queue extends App {

  /*
  *Queue也有兩種，scala.collection.mutable.Queue  and  scala.collection.immutable.Queue
  *
  * */

  println("================================")
  println("(1)初始化")

  val queue = scala.collection.immutable.Queue(1,2,3)

  println(queue)

  println("================================")
  println("(2)method")

  //將第一個元素踢出
  println(queue.dequeue)

  //在最後增加排隊元素
  println(queue.enqueue(6))
  println(queue.enqueue(4,5))
  println(queue.enqueue(3,3,3))

  var queue1 = scala.collection.mutable.Queue(1,2,3,4,5)

  println(queue1 += 6)

  //與上面enqueue的不同，全部攤平
  println(queue1 += (1,2,3,4))

  println("================================")
  println("(3)queue 和List結合")
  println(queue1 ++= List(6,7,8))


}
