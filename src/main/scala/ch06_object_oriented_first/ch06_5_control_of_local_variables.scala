package ch06_object_oriented_first

object ch06_5_control_of_local_variables extends App{

  /*
  *
  * !!!!!!!!!!!!!表6-1!!!!!!!!!!!!!!!
  *!!!!!!!!!!!!!!!!表6-2!!!!!!!!!!!!!
  *
  *
  * scala成員存取控制有3種：default(java 的public)、private、protected
  *
  * */

  println("==================")
  println("(1)default。")

  class Person{
    var name:String = null
    def print= println(s"$name")
  }

  val p = new Person

//  直接存取變數與方法；可以在Person類別裡或類別外使用。
  p.name="carter"
  p.print


//  即是是主建構子函數，也可以直接存取使用、甚至修改。

  class Person_1(var name:String)

  val p_1 = new Person_1("carter")

  println(p_1.name)

  p_1.name = "John"

  println(p_1.name)



  println("==================")
  println("(2)protected。")

  /*
  * 只能在Person_2類別或其子類別中存取，外部不能使用。
  *  *!!!!!!!!!!!!!!!!表6-3!!!!!!!!!!!!!

  *
  * */


  class Person_2{

    protected var name:String="protected carter"
    def print=println(s"$name")
  }

  class Student_2 extends Person_2{
//    子類別可以存取父類別成員變數。
    override def toString: String = this.name
  }

  val p_2 = new Person_2

//  p_2.name  //外部不能存取

  val s_2 = new Student_2

  println(s_2)

  println("==================")
  println("(3)private。")

  /*
  *
  * 只能在內部被Person_3類別的成員存取，在外部或子類別都不能使用。
  * *!!!!!!!!!!!!!!!!表6-4!!!!!!!!!!!!!
  *
  * */



  class Person_3{

    private var name:String="private carter"

    def print= println(s"$name")

  }

  class Student_3 extends Person_3 {
//    override def toString:String = this.name //不能存取
  }
  val p_3 = new Person_3
//  p_3.name  //外部不能存取


  println("==================")
  println("(4)private[this]。")

  /*
  * private[this]修飾類別私有成員。
  *
  * 類別私有成員只能在該類別內部存取。
  * */

  class Person_4{
    private[this] var name:String= _
    def this(name:String)={
      //呼叫共同父類別Any的建構子
      this();

      this.name= name
    }

    def print=println(name)
  }


  //因為有用覆載建構子，所以創物件時，可以給參數。
  val p_4 = new Person_4("carter")

//  p_4.name //類別的私有成員，外部不能存取；只能在該類別存取使用。

  p_4.print


  println("==================")
  println("(5)private and private[this]修飾變數的差異。")

  /*
  * companion class and object可以互相存取private變數；不可以存取private[this]變數。
  * !!!!!!!!!!!!!!!!表6-5!!!!!!!!!!!!!
  *
  * */



  //衍生類別companion class
  class Person_5{
    private var name:String= _

    def this(name:String){
      this();
      this.name = name
    }
    def print=println(name)
  }
  //companion object
  object Person_5{
    //衍生物件可以存取衍生類別的private成員
    //new Person_5("    ") 裡面設定字串，會呼叫def this(name:string)，使得private var name = 設定的字串內容。
    //因為private var name 是以預留位置宣告，所以還需要靠 .name 來給予private var name真實值。

    def printName = println(new Person_5("private carter").name)
  }

  Person_5.printName

//  println(new Person_5("carter").name)    //外部無法存取private成員


  println("//////////////")


  class Person_6{

    private[this] var name:String = _

    def this(name:String){
      this();
      this.name = name
    }
    def print  = println(name)
  }

  object Person_6{
//衍生物件不能
//    def printName = println(new Person_6("private[this] carter").name)
  }

//  println(new Person_6("private[this] carter").name) //外部不能存取

  println("==================")
  println("(6)_1_主建構函數中的成員（建構子）設定存取控制，protected。")


  class Person_7(protected var name:String,var age:Int){
    override def toString = s"Person_7($name,$age)"
  }

  class Student_7(name:String,age:Int,var studentNo:String)extends Person_7(name,age)

  val p7 = new Person_7("carter",17)

  val s7 = new Student_7("carter",18,"343")

//  s7.name  子類別不能從外部存取protect成員
//  p7.name  本身類別也無法外部存取。

  println(p7.toString)

  println("==================")
  println("(6)_2_主建構函數中的成員（建構子）設定存取控制，private。")


  class Person_8(private var name:String,private var age:Int){
    override def toString = s"Person_8($name,$age)"
  }

  val p8 = new Person_8("carter",18)

  println(p8.toString)
//  p8.age    外部接無法存取
//  p8.name



  println("==================")
  println("(6)_3_主建構函數中的成員（建構子）設定存取控制，private[this]。")

  /*
  *
  * 建構子參數不加val  var，默認為private[this]
  *
  * */


  class Person_9(name:String,age:Int){

    override def toString = s"Person_9($name,$age)"
  }
  //等同於class Person_9(private[this] val name:String, private[this] val age:Int)
  val p9 = new Person_9("carter",19)

  println(p9.toString)




}
