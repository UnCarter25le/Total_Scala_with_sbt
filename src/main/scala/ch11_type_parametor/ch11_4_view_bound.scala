package ch11_type_parametor

object ch11_4_view_bound extends App{


  println("===============")
  println("(1)不指定視圖變數界定。")


  //泛型T  S  實做 Comparable介面，且型態跟S一樣！
  case class Student[T,S <: Comparable[S]](var name:T, var height:S)

  val s = Student("carter","170")

//  val s2 = Student("carter",170)   //建構子參數的型態不一致，所以編譯不過。


  println("===============")
  println("(2)指定視圖變數界定。")

  //泛型T  S  實做 Comparable介面，且型態不一定要跟S一樣！
  case class Studentt[T,S <% Comparable[S]](var name: T, var height:S)

  val ss = Studentt("carter","170")

  val ss2 = Studentt("carter",170)



  println("===============")
  println("()")


}
