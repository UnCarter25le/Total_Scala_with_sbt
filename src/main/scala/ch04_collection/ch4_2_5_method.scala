package ch04_collection

//4.2.5

object ch4_2_5_method extends App {

  val intArr = Array(1,2,3,4,5,6,7,8,9,10)

  println(intArr.sum)

  println(intArr.max)

  println(intArr.min)

  //轉成字串
  println(intArr.toString)

  //轉成字串，並以什麼分開
  println(intArr.mkString(";"))

  //元素轉成字串
  println(intArr.mkString)

}
