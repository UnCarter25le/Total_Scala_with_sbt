package ch10_implicit

object ch10_3_implicit_class_and_object_and_parameter extends App{

/*
* 自動轉型函數，不只是將一個類型轉成另外一個類型而已。
*
*
*
*
*
* */



  println("==============")
  println("(1)隱式類別—參數就可以呼叫類別裡的方法。")

  implicit class Dog(val name: String) {

    def bark = println(s"$name is barking")

  }

  println("Nacy".bark)

  /*
  * String類型並不存在bark方法，但由於定義的隱式類別會進行自動轉型，因此編譯器會將String類型轉換成Dog類型，再執行bark方法。
  *
  * */


  val ggg = new Dog("carter")

  println(ggg.bark)



  //上面隱式類別的程式碼，編譯時會以下面的形式執行；事實上隱示類別是由自動轉型函數來實現。
  //隱式類別帶來程式的簡潔的同時，也會讓程式看來迷幻～
  class Dogg(val name:String){

    //這裡不能取名bark，因為會讓編譯器造成混淆
    def barkk = println(s"$name is barking.")

  }
  implicit def string2Dogg(name:String):Dogg = new Dogg(name)





  println("==============")
  println("(2)隱式類別的主建構函數參數只能有一個。")


//  implicit class Doggg(val name:String, val age:Int)

//  之所以只能一個主建構參數原因在於，自動轉型是將一種類型轉換成另外一種類型，彼此需要一一對應。

  println("==============")
  println("(3)隱式物件—————————概念類似覆載建構子。")

  //定義一個trait Multiplicable
  trait Multiplicable[T] {
    def multiply(x: T): T
  }

  //因為沒有牽涉到類型轉型，所以物件MultiplicableInt、MultiplicableString中的方法名稱可以相同，不會有混淆的問題。
  //定義一個隱式物件MultiplicableInt，用於整數資料的相乘
  implicit object MultiplicableInt extends Multiplicable[Int] {
    def multiply(x: Int) = x*x
  }
  //定義一個隱式物件MultiplicableString，用於字串資料的乘積
  implicit object MultiplicableString extends Multiplicable[String] {
    def multiply(x: String) = x*2
  }


  //定義一個函數，函數具有泛型參數；函數參數的型態，以泛型定義在前面。
  def multiply[T: Multiplicable](x:T) = {
    //implicitly方法，存取隱式物件；相當於eν實作了介面Multiplicable！
    val ev = implicitly[Multiplicable[T]]
    //根據實際的型態(x:T)呼叫對應的隱式物件中的方法—————————概念類似覆載建構子
    ev.multiply(x)
  }



  //  本來是從類別、物件本身才可以使用方法；不過藉由參數的實做介面（val ev = implicitly[Multiplicable[T]]），可以透過外部方法本身驅動，進而使用隱式物件、隱式類別裡方法！！！
  //呼叫隱式物件MultiplicableInt中的multiply方法
  println(multiply(5))
  //呼叫隱式物件MultiplicableString中的multiply方法
  println(multiply("5"))



  println("==============")
  println("(4)隱式參數—————————可以讓物件（參數的形式）直接實作介面；促使外部方法驅動使用隱式物件裡的方法，以及讓編譯器找尋對應的隱式值的手段。")


  /*
  *  改寫（3）程式。
  *
  * */


  //定義一個trait Multiplicable
  trait Multiplicablee[T] {
    def multiplyy(x: T): T
  }

  //定義一個隱式物件MultiplicableIntt，用於整數資料的相乘
  implicit object MultiplicableIntt extends Multiplicablee[Int] {
    def multiplyy(x: Int) = x*x
  }
  //定義一個隱式物件MultiplicableStringg，用於字串資料的乘積
  implicit object MultiplicableStringg extends Multiplicablee[String] {
    def multiplyy(x: String) = x*2
  }

  //使用隱式參數ev，型態是介面Multiplicablee，相當於eν實作了介面Multiplicable！！！定義multiplyy函數
  def multiplyy[T: Multiplicablee](x:T)(implicit  ev:Multiplicablee[T]) = {
    //根據實際的型態呼叫對應的隱式物件中的方法—————————概念類似覆載建構子
    ev.multiplyy(x)
  }


  //multiplyy有兩個參數，但指接收一個的情況下，編譯器會在目前作用域尋找對應的隱式值或隱式物件。
  //呼叫隱式物件MultiplicableIntt中的multiply方法
  println(multiplyy(5))
  //呼叫隱式物件MultiplicableStringg中的multiply方法
  println(multiplyy("5"))



  println("==============")
  println("(5)隱式值———也可以稱作隱式變數—————————概念類似覆載建構子。")


  /*
  * 隱式值的作用與隱式物件的作用類似，當函數中有隱式參數時，可以不指定參數而將該隱式值傳入。
  *
  * */

  implicit val xx:Double = 2.55

  def sqrt(implicit xx:Double) =  Math.sqrt(xx)


  //呼叫sqrt時不指定參數，此時編譯器會在目前作用域尋找對應的隱式值或隱式物件。
  println(sqrt)



  /*
  *  改寫（4）程式。
  *
  * */


  //定義一個trait Multiplicableee
  trait Multiplicableee[T]{
    def multiplyyy(x:T):T
  }
  //定義一個普通類別MultiplicableInt，用於整數資料的相乘
  class MultiplicableInttt extends Multiplicableee[Int]{
    def multiplyyy(x:Int) = x*x
  }
  //定義一個普通類別MultiplicableString，用於字串資料的乘積
  class MultiplicableStringgg extends Multiplicableee[String]{
    def multiplyyy(x:String) = x*2
  }
  //使用隱式參數定義multiplyyy函數
  def multiplyyy[T:Multiplicableee](x:T)(implicit evvv : Multiplicableee[T]) = {
    //根據實際的型態呼叫對應的隱式物件中的方法
    evvv.multiplyyy(x)
  }

  //型態為MultiplicableInttt的隱式值mInt
  implicit val mInt = new MultiplicableInttt
  //型態為MultiplicableStringgg的隱式值mStr
  implicit val mStr = new MultiplicableStringgg

  //multiplyyy有兩個參數，但指接收一個的情況下，編譯器會在目前作用域尋找對應的隱式值或隱式物件。
  //隱式值mInt當作參數傳入evvv，給相當於呼叫multiplyyy(5)(mInt)
  println(multiplyyy(5))
  //隱式值mStr當作參數傳入evvv，相當於呼叫multiplyyy(5)(mStr)
  println(multiplyyy("5"))






  println("==============")
  println("(6)隱式參數使用常見問題。")
  println("(6)_1_當函數沒有柯里化表現時，implicit關鍵字會作用於函數參數清單中的所有參數。")

  //使得xx、yy都是隱式參數。

  def product(implicit xx:Double, yy:Double) = xx * yy


  //在未指定參數時，編譯器會在目前作用域搜索對應的隱式值，以隱式值implicit xx為例
  //xx 就成為隱式參數了！ product相當於product(xx,xx)
  println(product)



  println("==============")
  println("(6)_2_若使用隱式值時，隱式值會全部指定到隱式參數的位置，無法部份指定；是可以在隱式參數的位置上，直接給予正確的參數。")

//  println(product(2.3))
  println(product(3,6))

  println("==============")
  println("(6)_3_同類型的隱式值在目前作用域只能出現一次。")

  implicit val xxx = 3.2
//  println(product)  //會發生不知道要取 implicit val xxx 還是implicit val xx


  println("==============")
  println("(6)_4_在定義隱式參數時，implicit關鍵字只能出現在參數列的開頭。")

//  def productt(x:Double, implicit y:Double)  //這是無法的



  println("==============")
  println("(6)_5_隱式參數進行柯里化時，implicit關鍵字只能作用於最後一個參數。")


  implicit val r = 5



  def productt(a:Int)(b:Int)(implicit f:Int):Double ={
        a + b + f
    }

  println(productt(22)(33))

  //  def producttt(implicit  a:Double)(b:Double):Double ={
  //    a + b
  //  }



  println("==============")
  println("(6)_6_implicit關鍵字在參數列只能出現一次，對柯里化的函數也不例外。")

  def producttt(implicit a:Double,b:Double) = a * b

//  def productttt(implicit a:Double, implicit b:Double)  //不行

//  def production(implicit a:Double)(implicit b:Double)  //不行


  println("==============")
  println("(6)_7_匿名函數不能使用隱式參數。")

  val prodoct1 = (x : Double, y: Double) => x*y

//  val prodoct2 = (implicit x : Double, y: Double) => x*y   //不行


  println("==============")
  println("(6)_8_如果柯里化的函數使用了隱式參數，仍能使用偏應用函數。")

  val rrr = productt _

 println(rrr(2)(3))


  println("==============")
  println("()")

}
