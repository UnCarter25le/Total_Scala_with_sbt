package ch08_package.cn.scala.chapter08

class TeacherPrivateThis(var name:String) {

  private[this] def printName(tName:String=""):Unit = {
    println(tName)
  }

  //在類別內部，可以呼叫private[this] 方法。
  def print(n:String) = this.printName(n)
}


object TeacherPrivateThis{

  //衍生物件也無法存取private[this]修飾子
//  def printName = new TeacherPrivateThis("carter").printName()

}