package ch07_object_oriented_second

object ch07_1_what_is_trait extends App{

  /*
  * scala中並沒有提供java語言的interface關鍵字來定義介面，而是提供trait（特質）關鍵字，來封裝（設定存取權限）成員方法、成員變數。
  *
  * java中，用with來實做（implement）介面，scala是以extends實做第一個trait，with實做第二個以上的trait。
  *
  * 一個類別只能繼承一個父類別，卻能實做多個trait
  *
  *
  *
  * */

  println("==================")
  println("(1)定義trait，並實做trait")

  //以trait關鍵自來定義。
  trait Closable{
    //抽象方法
    def close():Unit
  }

  //實做trait，使用關鍵字extends
  class File(var name:String) extends Closable{
    def close():Unit= println(s"File $name has been closed")
  }

  new File("config.txt").close()

  println("==================")
  println("(2)類別繼承父類別，並實做多個trait")

  class File_1(var name:String) extends java.io.File(name) with Closable with Cloneable{

    def close() = println(s"File $name has been closed")
  }

  new File_1("yeap.txt").close()

  println("==================")
  println("(3)trait實做多個trait")

  //即使只有實做trait，一樣要用extends 起頭
  trait Processable extends Closable with Cloneable


}
