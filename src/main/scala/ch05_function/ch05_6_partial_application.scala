package ch05_function



object ch05_6_partial_application extends App{

  println("==================")
  println("(1)生成部份應用函數：部份參數已經被定義了。")


  def multify(factor:Int)(x:Double)=factor*x

  val paf = multify(10)_

  println(paf.getClass)

  println(paf(50))



  println("==================")
  println("(2)柯里化函數可以產生與其參數個數相當的部份應用函數。")

  /*
  * 柯里化函數可以產生與其參數個數相當的部份應用函數。
  *
  *
  * */


  def paf2 = multify _  //產生multify另一部份的應用函數。

  //可以柯里化的利用。
  println(paf2(10)(50))

  //可以高階函數的使用，傳回值是函數物件。
  println(paf2(10))
  println(paf2(10).getClass)




  println("==================")
  println("(3)普通的函數也有部份應用函數。")
//  普通函數
  def product(x1:Int,x2:Int,x3:Int)=x1*x2*x3

  def product_1 = product(_:Int,2,3)

  println(product_1(2))


  def product_2 = product(_:Int,_:Int,3)

  println(product_2(2,2))


  def product_3 = product(_:Int,_:Int,_:Int)

  println(product_3(2,2,3))

  def product_4 = product _ //相當於 product(_:Int,_:Int,_:Int)

  println(product_4(2,2,3))


}
