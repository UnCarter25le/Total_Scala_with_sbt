package ch08_package.cn.scala


object Utils {

  def toString(x:String)={
    println(x)
  }

  //外層套件（ch08_package.cn.scala）無法直接存取內層套件（ch08_package.cn.scala.chapter08._），必須要引入套件才可以使用
  import ch08_package.cn.scala.chapter08._

  def getTeacher():Teacher= new Teacher("carter")

}
