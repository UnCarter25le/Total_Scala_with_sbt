package ch07_object_oriented_second

object ch07_4_multiple_inherit extends App{

  /*
  * 透過trait可以達到多重繼承，不過也又菱形繼承的問題
  *
  * */

  println("==================")
  println("(1)菱形繼承問題")
/*
* 物件呼叫的trait方法有重複時，會以最右邊實做的trait中的方法為主要方法。
*
* */


  trait A{
    def print:Unit
  }

  trait B1 extends A{
    var B1 = "Trait B1"
    override def print=println(B1)
  }

  trait B2 extends A{
    var B2= "Trait B2"

    override def print=println(B2)
  }

  class C extends B1 with B2

  val c = new C

  //c物件使用的是B2 trait
  c.print

  println("==================")
  println("(2)super關鍵字解決菱形繼承問題")

  trait AA{
    val a  = "Trait AA"
    def print(msg:String) = println(msg+":"+a)
  }

  trait b1 extends AA{
    var b1 = "Trait B1"
    override def print(msg:String) = super.print(msg+":"+b1)
  }

  trait b2 extends AA{
    var b2= "Trait B2"

   override def print(msg:String) = super.print(msg+":"+b2)
  }

  class CC extends b1 with b2

  //print方法，不僅僅是trait b2的
  new CC().print("print method In")

  /*
  *
  * 使用super關鍵字是一種惰性求值，super關鍵字定義的改寫方法不會馬上執行，
  * 而是將方法名稱同樣的敘述都整理蒐集完畢（:Trait B2:Trait B1:Trait AA），
  * 待呼叫方法時，才把整理好的內容執行送出。
  * 整理順序依然是由右往左。
  * */




}
