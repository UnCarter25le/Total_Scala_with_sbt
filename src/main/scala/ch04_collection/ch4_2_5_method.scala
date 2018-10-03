package ch04_collection

//4.2.5

object ch4_2_5_method extends App {

  val intArr = Array(1,2,3,4,5,6,7,8,9,10)

  println(intArr.sum)

  println(intArr.max)

  println(intArr.min)

  println(intArr.length)

  //將類型Array轉成字串String
  println(intArr.toString)

  //將Array中的元素萃取出來，放進字串String集合裡，並以什麼分開
  println(intArr.mkString(";"))

  //元素轉成字串
  println(intArr.mkString)
  //類型是String
  println(intArr.mkString.getClass)

}
