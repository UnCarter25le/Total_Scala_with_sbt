package ch02_variable_and_integral_type_PHOTO

object ch2_5_tuple extends App{

  /*
  * 元組 是不同類型的值的聚集。
  *
  * */


  println(("hello","china","beijing"))
  println(("hello","china","beijing").getClass)

  println(("hello","china",1L))

  var tuple1 = ("hello","china",1L)
  println(tuple1)

//  取用tuple的數值，索引值從1開始

  println(tuple1._1)
  println(tuple1._2)
  println(tuple1._3)

//  透過模式比對，取得tuple內容

  val(first, second,third) = tuple1

  println(first)
  println(second)
  println(third)

//  tuple數值的比較，使用==，進行內容的比較

  val tuple2 = ("hello","china",1L)

  println(tuple1 == tuple2)

}
