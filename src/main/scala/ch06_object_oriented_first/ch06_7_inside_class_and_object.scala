package ch06_object_oriented_first

object ch06_7_inside_class_and_object extends App {

  /*
  * 內部類別是指，定義在物件或類別內部的類別。
  * 內建物件是指，定義在物件或類別內部的物件。
  *
  * */


  println("==================")
  println("()。")

  //companion class
  class Student(var name:String,var age:Int){

    //內部類別
    class Grade(var name:String)

    //內建物件
    object Utils1{
      def print(name:String)=println(name)
    }
  }

  //companion object
  object Student{

    //內部類別
    class Printer{
      def print(name:String)=println(name)
    }
    //內建物件
    object Utils2{
      def print(name:String) = println(name)
    }
  }

  //建立衍生類別物件
  val student = new Student("carter",19)

  //建立衍生類別的內部類別物件
  val grade = new student.Grade("大學一年級")
  //取得內部類別物件的建構子
  println("取得內部類別物件的建構子:"+grade.name)


  //呼叫衍生類別的內建物件方法。
  student.Utils1.print("student.Utils1.print:呼叫衍生類別的內建物件方法")

  //建立衍生物件的內部類別物件
  val printer = new Student.Printer()
  printer.print("printer.print：呼叫衍生物件的內部類別物件方法。")

  //呼叫衍生物建的內建物件方法
  Student.Utils2.print("Student.Utils2.print：呼叫衍生物建的內建物件方法。")





}
