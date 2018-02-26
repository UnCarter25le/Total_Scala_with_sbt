package ch06_object_oriented_first

object ch06_6_abstract_class extends App{

  /*
  * 抽象類別不能夠用來創立物件。
  * 抽象類別因為存有抽象變數或抽象方法，所以才稱為抽象abstract。
  *
  * scala中透過abstract來定義抽象類別。
  *
  *
  * 抽象類別內，可以存有practical的變數或方法；一旦類別區域內存有抽象的東西，一定要宣告abstract class
  *
  * */




  println("==================")
  println("(1)區域（成員）變數，若沒有賦予值，則要宣告為抽象。")


  class Person_1{
    var name:String = _

  }

  abstract class Person_2{

    var name:String
  }


  println("==================")
  println("(2)子類別繼承父類別，應注意是否有抽象的變數或方法，有的話，子類要宣告抽象")

  class Student_1 extends Person_1



  abstract class Student_2 extends Person_2

  //因為將抽象變數初始化了，所以不用宣告抽象
  class Student_3 extends Person_2{
    override var name:String = _
  //省略override也可以
//    var name : String = _
  }

  println("==================")
  println("(3)抽象類別的使用。")

  abstract class Person_3{
    //抽象類別裡也可以有實際成員
    var age:Int = 0

    var name:String
    //抽象方法
    def walk()

    override def toString=name

  }

  class Student_4 extends Person_3{

    override var name:String = _

    override def walk():Unit = println("Walk like a Student")
  }

  val s4 = new Student_4

  s4.walk()




}
