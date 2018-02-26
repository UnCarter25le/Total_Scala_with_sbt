package ch06_object_oriented_first

object ch06_8_anonymous_class extends App{


  println("==================")
  println("(1)匿名類別定義。")

  /*
  * 匿名類別，沒有名字的類別。
  * 當某個類別在程式中只使用一次(不考慮再繼承、實做、創立物件的延伸應用)，可以考慮用匿名類別：將抽象類別物件化，並指定給變數。
  *
  * */
  abstract class Person(var name:String, var age:Int){
    def print:Unit
  }

  //使用匿名類別
  val p = new Person("carter",19){
    override def print: Unit = println(s"Person($name,$age")
  }
  p.print


  //上面的程式，等同下面這區。
  class NamedClass(name:String,age:Int) extends Person(name,age){
    override def print = println(s"Person($name,$age")
  }
  val pN = new NamedClass("carter",19)
  pN.print

/*
* 類別NamedClass被定義後，可以反覆使用，例如被繼承、實做物件。
*
* */


}
