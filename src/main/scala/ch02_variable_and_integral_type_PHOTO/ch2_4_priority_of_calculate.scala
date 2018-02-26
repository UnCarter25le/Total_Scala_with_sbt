package ch02_variable_and_integral_type_PHOTO

object ch2_4_priority_of_calculate extends App{

  println("===============")
  println("(1)")

  /*
  * 表2-2
  *
  * */

  /*
  * 在執行程式時，如果存在多個同一優先順序的運算子，則按照從左到右的執行順序（：：、：：：是例外，由右到左）。
  *
  * */

  println(1 % 2 *3)

//  如果要改變運算子的順序，可以使用（）

  println(1 % (2 * 3))

  println(1*10-2::2+2::Nil:::List(2,3):::List(5,6))
  /*
  * 1*10-2、2+2會先輩執行
  * 再執行：：
  * 再執行：：：
  *
  * */

}
