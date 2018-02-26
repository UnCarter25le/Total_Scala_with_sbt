package ch02_variable_and_integral_type_PHOTO

object ch2_6_genre_of_foohow extends App {

  /*
  * 符號類型 ，就是Symbol，需要使用'符號
  *
  * */

  val s='start

  //輸出時，以原樣輸出
  println(s)
  println(s.getClass)

//符號類型主要作用在標識，用在scala的模式比對與內容判斷
  val s1:Symbol = 'stop

  if(s1 == 'start) println("start:...") else println(" other...")

//  符號類型變數在使用==時，一樣比較的是內容
  val s2 = 'start

  val s3 = 'start

  println(s2==s3)

}
