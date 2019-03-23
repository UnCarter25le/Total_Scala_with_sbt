package ch09_pattern_match

import scala.reflect.ClassTag

object ch09_3_principle_of_pattern_match extends App {

  println("==============")
  println("(1)建構函數模式比對原理。")


  class Dog(val name:String, val age:Int)

  val dog = new Dog("PPet",2)

  def patternMatching(x:AnyRef) = x match{
//      如果沒有在下面定義衍生物件object Dog，這邊的case Dog編譯不會通過！
    case Dog(name,age) => println(s"Dog name = $name, age =$age")

    case _ =>
  }


  /*
  * 手動在類別的衍生物件中，實現unapply方法
  *
  * 得知，建構模式函數之所以能夠析取建構子，是透過衍生物件的unapply方法對輸入物件的解構。
  *
  * */

  object Dog{

//    定義unapply方法
    def unapply(dog: Dog): Option[(String, Int)] = {
      //如果dog物件有值（建構子），就建立一個物件Some()，析取dog物件的建構子。    Some物件只能含一個值。
      if (dog != null) Some(dog.name,dog.age)
      else None
    }
  }

  patternMatching(dog)


  /*
  *
  * 類別一旦被定義成case class案例物件，編譯器自動幫我們"產生該類別的衍生物件"，並實現apply（建立）和unapply（解構）方法。
  *
  *
  *
  * */

  println("==============")
  println("(2)序列模式比對原理。")


  // creates an array with given elements
  def apply[T: ClassTag](xs: T*): Array[T] = {
    val array = new Array[T](xs.length)
    var i = 0
    for (x <- xs.iterator) {
      array(i) = x; i += 1
    }
    array
  }

  //creates an array of Boolean objects

  def apply(x:Boolean, xs: Boolean*): Array[Boolean]={
    val array = new Array[Boolean](xs.length + 1)
    array(0) = x
    var i = 1
    for(x <- xs.iterator){ array(i) = x; i += 1}
    array
  }

  def unapplySeq[T](x:Array[T]): Option[IndexedSeq[T]] =
    if (x == null) None else Some(x.toIndexedSeq)


  // toIndexedSeq  轉為有序的陣列。

  println("==============")
  println("()")

  println("==============")
  println("()")

}
