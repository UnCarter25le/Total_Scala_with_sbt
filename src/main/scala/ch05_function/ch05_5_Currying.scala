package ch05_function

object ch05_5_Currying extends App{

  println("==================")
  println("(1)類似currying的形式。")

  /*
  *
  * 傳回值是匿名函數，可以丟完參數後，接著再對預期的傳回匿名函數做呼叫。
  *
  * */

  def higherOrderFunction(factor:Int)=(x:Double)=>factor*x

  higherOrderFunction(10)(50)
//  higherOrderFunction(10)傳回的函數物件的類型是Double=>Double，然後再呼叫該函數物件，獲得結果。

  val f = higherOrderFunction(10)

  println(f.getClass)

  println(f(50))
//此法跟上面同意思。


  println("==================")
  println("(2)currying。參數有多個的方法。柯里化函數不是高階函數。")

  def multify(factor:Int)(x:Double)=factor*x
  /*
  *
  *
  * 圖5-3
  *
  *
  * 柯里化函數不是高階函數，不能使用傳回的函數物件。
  *
  *
  * */

  println(multify(10)(50))

//  println(multify(10))
//如果要這樣使用，就要用部份應用函數。





}
