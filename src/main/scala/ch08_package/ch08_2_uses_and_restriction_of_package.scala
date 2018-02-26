package ch08_package

//scala允許在任何地方進行套件的引用，  _  的意思是，引用該套件下所有類別和物件。
import ch08_package.cn.scala._
import ch08_package.cn.scala.chapter08._

object ch08_2_uses_and_restriction_of_package extends App{

  println("==================")
  println("(1)套件的使用")


  //scala的main方法
//  def main(args:Array[String]):Unit={
    Utils.toString(new Teacher("carter").name)

    new Teacher("carter").printName()

//  }




  println("==================")
  println("(2)_1_套件的作用域，private。")

  /*
  *
  * 在scala中沒有public關鍵字，僅有private and protected，當類別成員沒有加上private or protected，預設是public。
  *
  * scala另外提供以private[X]、protected[X]方式，將private and protected 限定到X，X可以是套件、類別、也可以是單例物件。
  *
  *  private[this]限定只有該類別的物件才可以存取。即使是衍生物件也無法存取。
  *
  * */

  //沒辦法使用物件的private printName方法
//  new TeacherPrivate("carter").printName("dd")


  println("==================")
  println("(2)_2_套件的作用域，private[X]。")

  //無法在這邊使用物件UtilsPrivate，只能在cn.scala套件和其子套件裡面才可以使用。
//  UtilsPrivate.toString(new Teacher("carter").name)


  println("==================")
  println("(2)_3_套件的作用域，private[this]")

//無法使用TeacherPrivateThis的printName方法，因為pirvate[this]的關係。
//  new TeacherPrivateThis("carter").printName()


  /*
  *
  *
  * ！！！！！！！！！！！！！！！表8-1！！！！！！！！！！！！
  *
  * */




}


