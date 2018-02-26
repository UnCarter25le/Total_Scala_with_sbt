package ch02_variable_and_integral_type_PHOTO

object ch2_3_basic_manipulate_of_data_type extends App{

  println("===============")
  println("(3)基本類型操作")

  /*
  * scala是純物件導向的語言，在scala中一切都是物件，所有的操作都是方法呼叫。
  *
  * */


  println("===============")
  println("(3)_1_算術運算")

  //+ - * / %
  var sumValue = 1+2

  println(sumValue)

  //var 在上面已經定義過了，在此可以不用定義
  sumValue = (1).+(3)

  println(sumValue)

  val longSum = 1+2L

  println(longSum)

  println(1-3)

  println(1/3)

  println(1L*3L)

  println(1%3)

  // -號可以直接加在數字前，形成複數
  val yy = 1+ -3

  println(yy)


  println("===============")
  println("(3)_2_關係運算子")

  // > < <= >=

  println(3 > -3)

  println(3 < -3)

  println( 3 <= -3)

  println( 3 <= 3)

  //!違反轉操作
  println(!(3 <= 3))


  println("===============")
  println("(3)_3_邏輯運算操作")

  // &&and  ||or

  val bool = true

  println(bool && bool)

  println(bool && !bool)

  //同時為false才會是false
  println(bool || bool)

  println(bool || !bool)

  println(!bool || !bool)

  println("===============")
  println("(3)_4_位元運算操作")



  println("===============")
  println("(3)_5_物件比較運算操作")
  /*
  * java 的物件內容比較，比較的是物件參考的記憶體位址是否一樣；如真要比較內容，需要另定義比較方法
  * scala的物件內容比較，就是直接比對物件的內容。
  *
  * scala中，== 和 .equals 是一樣的
  *
  * */

  println(1 == 1)

  println(1 == 1.0)

  val a = "hello"

  val aa = "hello"

  println(a == aa)

  var aaa = new String("hello")

  val aaaa = new String("hello")


  println(aaa.equals(aaaa))

  //用java中，比較物件的記憶體參考位置，要用eq
  println(a.eq(aa))   //true原因，java在記憶體中會有個字串池，放置所有是字串的值
  //那字串物件記憶體的位置，一定是一樣的
  println(aaa.eq(aaaa)) //false的原因，因為定義兩個不塗的物件，記憶體參照位置會不一樣


  println("===============")
  println("(3)_6_字串運算操作")

  /*
  * scala中運用的字串類型，就是java.lang.String，所以可以呼叫java的String類型所有方法
  *
  * */

  var str = "Hello"

  //所有字串也算是集合
  println(str.indexOf("o"))

  println(str.toUpperCase)

  println(str.toLowerCase)


  println(str.reverse)

  println(str.drop(3))

  println(str.slice(1,4)) //切割字元的方式，同python


  /*
  * 之所以可以呼叫reverse , drop的方法在java.lang.String中，是因為呼叫該方法時，字串類型
  * 被自動轉型成StringOps類型的物件
  * */

}
