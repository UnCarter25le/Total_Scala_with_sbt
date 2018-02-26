package ch08_package.cn.scala.chapter08

class TeacherPrivate(var name:String) {
  private def printName(tName:String="") : Unit={
    println(tName)
  }

  //類別內部，可以存取private方法
  def print(n:String) = this.printName(n)


}


object TeacherPrivate{

  //衍生物件可以存取private 方法
  def printName = new TeacherPrivate("carter").printName()

}
