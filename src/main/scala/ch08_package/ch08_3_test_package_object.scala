package ch08_package

import ch08_package._
object ch08_3_test_package_object extends App{

  //引用package object封裝的變數資料。
  def computeArea(r: Double) = ch08_3_package_object.PI * r * r

  println(computeArea(3))

}
