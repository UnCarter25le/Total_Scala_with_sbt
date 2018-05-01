package ch10_implicit

object ch10_2_the_definition_of_implicit  extends App{


  println("(1)定義自動轉型函數。")

  implicit def int2float(x:Int):Float = x.toFloat

  var x: Float = 1



  /*
  * 如果沒有定義float2int方法，下面的程式會出錯。
  * 其原因是，編譯器發現設定值物件的類型與最後類型不相符時，會自前作用域範圍內尋找能夠將Float類型轉換成Int類型的自動轉型函數。
  * */
  implicit def float2int(x:Float) = x.toInt

  var intValue: Int =  2.55f



  println("==============")
  println("(2)自動轉型函數名稱。")




  /*
  * 即便定義了自動轉型函數，但是有兩個函數提供一樣的內容，會讓編譯器混淆，程式仍不能執行。
  *
  * 證明，定義自動函數時，名稱不重要，重要的是參數與函數內容有無重複、定義清楚。
  *
  * */

//  implicit def f2i(x:Float) = x.toInt    //def f2i  內容跟def float2int 一樣

  val intValuee:Int = 2.55f






  println("==============")
  println("()。")

}
