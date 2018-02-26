package ch08_package.cn.scala


//限定物件UtilsPrivate只能在scala套件中、及其子套建中使用
private[scala] object UtilsPrivate {

  def toString(x:String): Unit ={
    println(x)
  }

  import ch08_package.cn.scala.chapter08._
  def getTeacher():Teacher = new Teacher("carter")

}
