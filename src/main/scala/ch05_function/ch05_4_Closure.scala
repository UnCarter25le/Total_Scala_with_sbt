package ch05_function

object ch05_4_Closure extends App{


  println("==================")
  println("(1)閉包的定義。")

  /*
  *
  * An Object is data with functions. A closure is a function with data.
  *  閉包是由函數和執行時期的資料決定的。
  *
  *
  *  全域變數i(不一定是函數的參數)在執行過程會不斷變動（屬於開放狀態）；當執行匿名函數時，i的值會確定，所以執行時期是個固定、封閉的狀態。
  *  所以開放與封閉的結合，就稱作Closure。
  *
  *
  * */


  var i = 15

  val f = (x:Int)=> x+i

  println(f(10))

  i = 20

  println(f(10))



  println("==================")
  println("(2)高階函數也是種閉包。")


  def a(f:Double=>Double,p:Double=>Unit)={
    val x = f(10)
    p(x)
  }

//  定義f:Double=>Double的算法不一樣。
  val ff =(x:Double)=>x*2

  val pp ={x:Double => println(x)}

  a(ff,pp)

  val fff = (x:Double)=>x*x

  a(fff,pp)
}
