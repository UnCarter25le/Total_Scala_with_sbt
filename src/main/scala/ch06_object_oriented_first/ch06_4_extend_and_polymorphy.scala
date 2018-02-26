package ch06_object_oriented_first

object ch06_4_extend_and_polymorphy extends App{

  /*季成為達致多型！
  * 繼承是物件導向程式語言實現程式重複使用的關鍵特性。
  * 實現子類別繼承父類別，子類別可以擁有父類別的屬性（變數）與方法（行為），也可以在子類別中，新增變數與方法、或改寫父類別的變數與方法。
  *
  *
  *
  * 多型是在繼承的基礎上，實現的一種語言特性，允許不同類別的物件，以父類別的名義，對同一訊息做出相對應的反應。
  *
  * */

  println("==================")
  println("(1)輔助(覆載)建構子。")

/*
* scala中以extends來實現繼承；如果同時繼承父類別並實做介面、或是實做兩個以上的介面，則以extends  with  with  表示。
*
* */

  class Person(var name:String,var age:Int){

    override def toString: String= "name=" +name+",age="+age
  }


  //透過extends完成繼承，並帶著被繼承的建構子變數名稱；
  // 繼承的建構子，前面不需要註明val  or var，但新增的建構子要註記。
  class Student(name:String,age:Int,var studentNo:String) extends Person(name,age){

    override def toString:String = super.toString+",studentNo="+studentNo
                                  //用super關鍵字，繼承父類別方法內容
  }

  println(new Person("carter",18))

  println(new Student("mary",19,"9527"))


  println("==================")
  println("(2)建構函數執行順序；子類別建立物件使用，會先呼叫父類別內容。")


  class Person_1(var name:String, var age:Int){

    println("執行Person_1主建構函數")
  }

  class Student_1(name:String,age:Int,var studentNo:String) extends Person_1(name,age){
    println("執行student類別的主建構函數")
  }

  /*
  * 建立子類別物件時，先呼叫父類別的主建構函數，再呼叫子類別的建構函數。
  *
  * */

  println(new Student_1("carter",29,"9527"))





  println("==================")
  println("(3)子類別重新定義父類別方法。")


  /*
  *
  * 透過override實現重新定義；事實現多型和動態聯繫的關鍵。
  *
  * override 方法時，方法在父類別有幾個參數，改寫時就要有幾個參數，否則參數不同，代表的是不同的方法。
  *
  * */


  class Person_2(var name:String,var age:Int){
//    對父類別Any中的toString方法，進行重新定義。
    override def toString = s"Person_2($name,$age)"
  }


  class Student_2(name:String,age:Int,var studentNo:String) extends Person_2(name,age){

    override def toString: String = super.toString.replace(')',' ')+s",$studentNo"
//    override def toString: String = s"Person_2($name,$age,$studentNo)"  也可以
  }

  println(new Student_2("carter",19,"9999"))


  println("==================")
  println("(4)子類別若沒有重新定義父類別方法，能傳回值是hashcode。")
//  如果不重新定義toString，建立物件使用傳回的結果會是類別名稱的hashcode。

  class Person_3(var name:String, var age:Int)

  println(new Person_3("carter",19))


  println("==================")
  println("(4)多型。")


  /*
  *  Polymorphic 多型也稱為動態繫結（dynamic Binding）或延遲綁定（late Binding）
  *
  * 子類別的參考可以指定給父類別，程式在執行時期根據實際類型，呼叫對應的方法。
  *
  * */

  class Person_4(var name:String,var age:Int){

    //方法回傳值型別定義為Unit，代表此方法無回傳值。
    def walk():Unit= println("walk() method in Person_4")

    def talkTo(p:Person_4):Unit=println("talkTo() method in Person_4")
  }


  class Student_4(name:String,age:Int) extends Person_4(name,age){
    private var studentNo_4 :Int = 0

    override def walk() = println("walk() method in Student_4 ")

    override def talkTo(p:Person_4) ={
      println("talkTo() method in Student_4")
//      方法中可以使用建構子。
      println(this.name+" is talking to "+p.name)
    }
  }



  class Teacher(name:String,age:Int)extends Person_4(name,age){
    private var teacherNo:Int = 0

    override def walk()=println("walk() method in Teacher")

    override def talkTo(p: Person_4)={
      println("talkTo() method in Teacher")
      println(this.name+" is talking to "+p.name)

    }

  }


  val p1:Person_4= new Teacher("albert",38)

  val p2:Person_4= new Student_4("carter",29)

  p1.walk()

  p1.talkTo(p2)

  println("///////////////////////////")

  p2.walk()

  p2.talkTo(p1)


/*
*
* p1和p2的型別都是Person_4，person_4裡也有原始的walk()、talkTo()方法。
* 不過，當p1、p2各自呼叫walk()、talkTo()方法時，會根據物件"實際"參考的類別，去那個類別裡呼叫正確對應方法。
* 所以當p1呼叫方法，程式會去class Teacher裡找方法。
*
* 多型的白話意義，向他人告知一個共同父類類型，就可以聯想到物件實際會做什麼事情；
* 所以可以將Person_4想成"去工作"，老師去工作就是XXXX，學生的去工作就是＠＠＠＠，雖然工作內容不一樣，但是在知道身份後，只需要告知他人去工作，
* 大家就會知道去工作的內容了！
*
*
* */







}
