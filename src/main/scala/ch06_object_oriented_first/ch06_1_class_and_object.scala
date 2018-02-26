package ch06_object_oriented_first

object ch06_1_class_and_object extends App{


  println("==================")
  println("(1)宣告類別")
  /*
  * 一旦宣告類別，就要初始化變數。
  *
  * */


  /*
  * 使用預留位置 _  對成員變數（區域變數）初始化時，如果是值物件類型如Double、Int，在scala中對應AnyVal類別，初始值是0。
  * 如果是值物件類型如String，在scala中對應AnyRef類別，初始值是Null。
  * */


  class Person{
//    初始化成員變數
    var name : String = null
//    var person:String 只有這樣，類別會出錯

    //可以用預留法滿足初始化。
    var weight : Double = _

    val tall : Double = 172.0
  }



  println("==================")
  println("(2)建立物件")

/*
* 透過new關鍵字，建立Person類別的物件
*
* 如果沒有使用建構子，()可以省略。
* */
  val p = new Person()

  val p1 = new Person



  println("==================")
  println("(3)成員變數的存取與限制。")

//  顯性呼叫setter方法修改、賦予成員變數值；java中的set方法

  p.name = ("john")

  //呼叫getter方法；java中的get方法
  println(p.name)


  //可以多次使用setter方法
  p.name = "John"

  println(p.name)





// 如果區域變數初始化設定val，則不能使用setter方法修改。

//  p.tall = 175.0  //不被允許



  println("==================")
  println("(4)在scala中呼叫java的編寫風格。")

  //引用套件，並在區域變數前加上符號
  import scala.beans.BeanProperty

  class Person1{
    @BeanProperty var name:String = null

  }

  val pp = new Person1()
/*
* @BeanProperty除了產生scala風格的getter and setter方法外，也會產生public void setName(java.lang.String)
* public java.lang.String getName() 等java風格的getter  and setter 方法。
*
* 一旦引用@BeanProperty，就可以用setName  and getName存取區域變數。
* */


  pp.setName("John")

  println(pp.getName)

  println("==================")
  println("(5)Singleton單例物件。")

  /*
  * 實際應用中，常常存在不建立物件就可以存取對應成員變數或方法。
  *
  * scala語言並不支持靜態類別成員（static）這一語法，而是透過單利物件來實現。
  * */

  object Student{
    private var studentNo:Int = 0

    def uniqueStudentNo()={
      studentNo += 1
      studentNo
    }

  }


//  直接透過單例物件名稱存取成員方法。
  println(Student.uniqueStudentNo())

  println(Student.uniqueStudentNo())




  println("==================")
  println("(6)scala中的main方法；只要在單例物件中定義main方法，單例物件就稱作應用程式物件。")


  /*
  * 定義單例物件的方法一。
  * main方法需要定義在單例物件中
  *
  * */
  object Student_1{
    private var studentNo:Int = 0

    def uniqueStudentNo()={
      studentNo += 1
      studentNo
    }

    def main(args: Array[String]){
      println(Student_1.uniqueStudentNo())
    }
  }


  println("==================")
  println("(7)應用程式物件繼承trait App，無須main方法，就可以執行程式。")

  /*
  * 定義單例物件的方法二。
  * 這是最常用的定義單例物件的方式。
  *
  *
  * */
  object Student_2 extends App{
    private var studentNo:Int = 0

    def uniqueStudentNo()={
      studentNo += 1
      studentNo
    }

//    def main(args: Array[String]){
      println(Student_2.uniqueStudentNo())
//    }

  }



  println("==================")
  println("(8)衍生物件companion object與衍生類別companion class。")

  /*
  *
  * 這個是scala中重要的概念，重要在於利用這個概念，實現存取控制的許可權
  *
  * */


  class Student_3{

    private var name:String=null
  }

  object Student_3{
    private var studentNo:Int = 0

    def uniqueStudentNo()={
      studentNo+=1
      studentNo
    }

  }


  class Student_4{
    private var name:String=null
    def getStudentNo={

      Student_4.uniqueStudentNo()
      //利用衍生物件的方法
      Student_4.studentNo
      //呼叫衍生物件的私有變數
    }
  }

  object Student_4{
    private var studentNo:Int = 0
    def uniqueStudentNo()={
      studentNo+=1
      studentNo
    }

    def printStudentName = println(new Student_4().name)
    //存取衍生類別物件的私有變數
  }


  //在衍生類別、衍生物件外，不允許直接存取對方裡面的私有成員。
//  println(Student_4.studentNo)
//  println(new Student_4().name)


//  不過可以自己使用自己內部的變數。
/*
* class創物件，需要new關鍵字；object不需要new就可以創物件。
*
* */
  println(new Student_4().getStudentNo)

  Student_4.printStudentName


  println("==================")
  println("(9)!!!無new關鍵字建立物件!!!!")

  class Student_5{
    var name:String = null
  }

  object Student_5{

    //使用apply方法，提供無需要new關鍵字，就可以使用class Student_5，創立物件使用
    def apply()=new Student_5()

  }

  //無new方式建立物件，呼叫衍生物件的apply方法，完成衍生類別的建立。
  val s = Student_5()


  s.name="John"

  println(s.name)







}
