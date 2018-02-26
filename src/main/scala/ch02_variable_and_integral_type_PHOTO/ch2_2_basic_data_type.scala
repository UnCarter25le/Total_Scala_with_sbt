package ch02_variable_and_integral_type_PHOTO

object ch2_2_basic_data_type extends App {
  println("===============")
  println("(2)基本資料型態")

  /*
  * 表2-1 scala基本資料型態表
  *
  * */

  /*
  * scala的data type必須要大寫，因為scala中所有的數值型態都是物件。
  * */


  println("===============")
  println("(2)_1_Int")

  //16進位
  val x = 0x29

  println(x)

  //十進位
  val xx = 41

  println(xx)

  //8進位
  //  val xxx = 051

  //  println(xxx)

  println("===============")
  println("(2)_2_Float")

  //  如果數字後不加f，scala會自動判斷成double
  val floatNumber = 3.1415F

  println(floatNumber)
  println(floatNumber.getClass)

  val floatNumber1 = 3.1415f

  println(floatNumber1)
  println(floatNumber1.getClass)

  println("===============")
  println("(2)_3_Double")

  val doublee = 3.141516

  println(doublee)
  println(doublee.getClass)

  val floatNumber3 = 0.314529e1  // e1 = 10的1次方

  println(floatNumber3)
  println(floatNumber3.getClass)


  println("===============")
  println("(2)_4_char")

  //   用 ' 包裹起來的，叫做字元

  var charLiteral = 'A'

  println(charLiteral)

  //使用正則表達的跳脫符號 \，讓系統捕捉跳脫符號後面的東西
  val xxxx = '\"'

  println(xxxx)

  //scala也可以印出unicode編碼
  val y = '\u0022'

  println(y)
  println(y.getClass)

  println("222"+'\b')
  /*常用特殊字元
  * \n  換行；(\u000A)
  * \b  backspace；(\u0008)
  * \t  tab；(\u0009)
  * \" (\u0022)
  * \' (\u0027)
  * \  (\u005C)
  *
  *
  *
  * */




  println("===============")
  println("(2)_5_String")

  /*
  * 要用 " 包裹起來的
  * */

  val helloWorld5 = "Hello World"

  println(helloWorld5)

  //使用跳脫符號
  val helloWorld8 = "\"Hello World\""
  println(helloWorld8)

  //使用""" 原樣輸出字串內容

  val ggg = """hello cruel world, \n \\\\ \b \\, I am " experienced" programmer """

  println(ggg)


  println("===============")
  println("(2)_6_Boolean")

  var x1 = true
  var x2 = false

  println(x1)
  println(x2)



}
