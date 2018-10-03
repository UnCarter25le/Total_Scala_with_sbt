package ch02_variable_and_integral_type_PHOTO




object ch2_1_definition_of_varivable extends App{

  /*
  *
  * scala變數有兩種類型，var可變變數，val不可變變數
  *
  * */


  println("===============")
  println("(1)變數")
  println("(1)_1_宣告val變數")

  //宣告一個val變數，scala會自動進行類型推斷
  val helloString = "Hello World"

  println(helloString)

  //明確指定變數類型
  val helloString1: String = "Hello World"

  println(helloString1)

  //scala會自動引用套件，java.lang.String

  val helloString2: java.lang.String = "Hello World"

  println(helloString2)

//  helloString = "Hello Crazy World" // val變數，一經宣告，就無法再指定值
  //這點跟java中的final  變數類似。


  println("===============")
  println("(1)_2_宣告var變數")

  var helloString3 = "Hello Cruel World"

  println(helloString3)

  helloString3 = "GoodBye Cruel World"

  println(helloString3)


  println("===============")
  println("(1)_3_宣告var、val變數時，必須初始化")

//  val s2 : String  //會報錯

  val s3 : String = ""

  /*定義變數時不想定義其值，可以用預留法。
  *
  * 只適用在var變數
  *
  * */

  var s2: String = _

  println(s2)

  var s4: Int = _

  println(s4)

  var s5: Float = _

  println(s5)

  var s6: Char =_

  println(s6)

  println("===============")
  println("(1)_4_lazy變數")

  /*
  * 只有在要使用變數時，變數才會被賦予值
  *
  * lazy只能修飾val，主要避免程式執行過程中，變數未被使用就被重新設定值。
  *
  * */

  lazy val v1 =  "test"

  println(v1)




}

