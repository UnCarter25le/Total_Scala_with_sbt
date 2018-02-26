package ch07_object_oriented_second

object ch07_3_trait_and_class extends App{


  println("==================")
  println("(1)trait與類別的相似點")

  /*
  * trait可以像普通類別一樣，定義成員變數與方法（無論是否是抽象）。
  *
  * trait跟抽象類別很相似。
  *
  * */

  trait Logger{
    println("Logger")

    def log1(msg:String):Unit
    def log2(msg:String):Unit=println(msg)
  }

  abstract class Logger_1{
    println("Logger")
    def log1(msg:String):Unit
    def log2(msg:String):Unit=println(msg)
  }

  class Person extends Logger{
    def log1(msg:String):Unit=println("log1:"+msg)
  }

  val p = new Person

  p.log1("Person extends Logger trait")


  class Person_1 extends Logger_1{
    def log1(msg:String):Unit=println("log1:"+msg)
  }

  val pp = new Person_1

  pp.log1("Person_1 extends Logger trait")

  /*
  *
  * 雖然上述Logger為trait和class時，程式碼都一樣，但是Person類別作為Logger的子類別，再認之上不符合邏輯，因為他們之間沒有"is-a"（是一種）的關係；
  * 不過若以Person類別混入、實做Logger trait，更符合我們認知習慣。
  *
  *
  * */

  println("==================")
  println("(2)trait 可以繼承類別；也可以物件化")

  class A{
    val msg:String = "msg"
  }

  trait B extends A{
    def print()=println(msg)
  }

  //trait的物件化，符號要用{}
  new B{}.print()

  println("==================")
  println("(3)trait和class的不同點")

  /*
  * 無論是普通類別或是抽象類別，都可以在類別定義時，使用主建構函數，定義類別的成員變數，但是trait不可以，這是兩者最重要的區隔。
  *
  * 其次，scala語言中類別不能繼承多個，但可以實做多個trait
  *
  * */

  abstract class Logger_2(val msg:String)

//  trait Logger_3(val msg:String)  //error

  trait AA

  trait BB

  class C extends AA with BB






}
