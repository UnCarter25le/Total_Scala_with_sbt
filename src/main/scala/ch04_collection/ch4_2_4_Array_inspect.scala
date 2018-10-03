package ch04_collection

// 4.2.4

/*
*
* 陣列或集合，都可以迭代檢查
*
*
* */

object ch4_2_4_Array_inspect extends App {

import scala.collection.mutable.ArrayBuffer

  var intArrayVar = ArrayBuffer[Int]()

  intArrayVar += (1,2,3,4,5,6,7,8,9,10)


  println("================================")
  println("(1)索引值檢查")

  for (i <- 0 to intArrayVar.length -1 ) {

    println(intArrayVar(i))

  }

  for (i <- 0 until intArrayVar.length) println(intArrayVar(i))

  println("================================")
  println("(2)索引值加入過濾條件：reverse and step")

  //倒序輸出
  for (i <- (0 to intArrayVar.length - 1).reverse) println(intArrayVar(i))

  println("===")

  //索引值間隔取出
  for (i <- 0 until (intArrayVar.length,2)) println(intArrayVar(i))

  println("================================")
  println("(3)直接陣列檢查。較建議使用這個。")

  for (i <- intArrayVar){

    println(i)
  }




  println("================================")
  println("(4)直接陣列檢查的同時，也可以產生'yield 新陣列。")

  //產生的新陣列，與原陣列無關；mutable 產生的仍是mutable、 原陣列、原集合的類別，會保留在新陣列、新集合上

  var intArrayVar2 = for (i <- intArrayVar) yield i*2

  println(intArrayVar2)

  println(intArrayVar2.getClass)  //ArrayBuffer

  //immutable 產生的仍是immutable

  var intArrayNoBuffer = Array(1,2,3)


  var intArrayNoBuffer2 = for (i <- intArrayNoBuffer ) yield  i*2

  println(intArrayNoBuffer2(0))

  println(intArrayNoBuffer2.getClass)  //immutable Array

  //加入過濾條件
  var intArrayNoBuffer3 = for(i <- intArrayNoBuffer if i >= 2 ) yield  i*3

  println(intArrayNoBuffer3(0))

  println(intArrayNoBuffer3.getClass)  //immutable Array



}
