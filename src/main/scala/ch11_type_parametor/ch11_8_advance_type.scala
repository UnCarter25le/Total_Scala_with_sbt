package ch11_type_parametor

object ch11_8_advance_type extends App {



  println("===============")
  println("(1)函數類型。")


  //定義一個高階函數，參數是函數類型，傳入值是double，傳回值要是int
  def test(x:Double => Int)=x(33.0)

  def double2int(x:Double) = x.toInt


  println(test(double2int))


  println("===============")
  println("()")


  println("===============")
  println("()")

}
