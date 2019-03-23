package ch10_implicit

/*
* 與scala中的模式比對一樣，scala的自動轉型也無處不在。
*
*
*
*
* */


/*
*隱式引用： 不引用任何套件，scala會預設引用java.lang._  and  scala.Predef._ 物件中的所有類別和方法
*
* scala.Predef._ 物件中，包含許多自動轉型函數。
*
* */

object ch10_1_the_introduction_of_implicit extends App{



  println("(1)scala.Predef._ 物件中，包含許多自動轉型函數。")


//  例如～
  implicit def int2Long(x: Int) :Long = x.toLong

  implicit def int2float(x:Int) : Float = x.toFloat

  implicit def int2double(x: Int) : Double = x.toDouble







}
