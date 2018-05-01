package ch10_implicit

object ch10_4_the_obligation_of_implicit extends App{

  println("==============")
  println("(1)自動轉型的規則。")
  println("(1)_1_顯性定義規則。")

  def product(implicit x:Double, y: Double) = x*y

  implicit val x : Int = 5

//  println(product)  // 編譯器抓取隱式值時，無法幫忙自動轉型！

  println(product(3,5))  //若手動定義參數，編譯器會幫忙自動轉型。

  implicit val t : Double = 3.3

  println(product)


  println("==============")
  println("(1)_2_作用域規則。")

  class ggg{

    implicit def double2Int(x:Double) = x.toInt
  }

  //自動轉型定義在class ggg理事沒有用的。
  implicit def Double2Int(x:Double) = x.toInt


  val f : Int = 2.55


  println("==============")
  println("(1)_3_無問題規則。")

  println("(1)_3_1_不能存在兩個內容相同的自動轉型函數。")

//    implicit def Double2eInt(x:Double) = x.toInt  //解開註解，會造成混淆。

  val e : Int = 2.9

  println("(1)_3_2_不能存在兩個型態相同的隱式值。")

  def sum(implicit x:Int, y:Int) = x+y

//  implicit val sx:Int = 5  //與implicit val x : Int = 5 型態重複，sum會出錯。

  println(sum)



  println("(1)_3_3_不能存在兩個具有同時相同的主建構函數參數型態以及成員方法的隱式類別。")

  implicit class Dog(name:String){
    def bark = println(s"$name is barking.")
  }

  implicit class DDog(name:Int){
    def bark = println(s"$name is barking.")
  }

// 因為建構子型態重複、成員方法又一致，所以會出錯。
//  implicit class DDDog(name:String){
//    def bark = println(s"$name is barking.")
//  }

  "Nacy".bark


  println("==============")
  println("(1)_4_一次轉換原則。")

  //自動轉型函數，從源類型到目標類型只可以一次轉換。


  implicit class Cat(val name:String){
    def getName = name

    def mieo = println(s"$name is mieo.")

  }

  implicit class SpecialCat(cat:Cat){
    def specialBark = println(cat.getName + "is mieo Specially.")
  }

  "NNacy".mieo


  //下面程式希望將String類型轉型到Cat類型 ，在轉到 SpecialCat類型，進而呼叫specialBark方法。會出錯。
  //這個限制是為了不讓程式看來更迷幻。
//  "NNacy".specialBark


  println("==============")
  println("(2)多次自動轉型的問題。")
  /*
  *
  *   程式其實允許多次轉型，但增加軟體的複雜度，這將不利軟體的持續升級與維護。
  *
  *
  * */

  class TestA{
    override def toString="this is TestA"
    def printA=println(this)
  }

  class TestB{
    override def toString="this is TestB"
    def printB(x:TestC)=println(x)
  }

  class TestC{
    override def toString="this is TestC"
    def printC=println(this)
  }

  //TestA到TestB的自動轉型函數
  implicit def A2B(x:TestA)={
    println("TestA is being converted to TestB")
    new TestB
  }

  //TestB到TestC的自動轉型函數
  implicit def B2C(x:TestB)={
    println("TestB is being converted to TestC")
    new TestC
  }


  val a=new TestA

  //TestA中不會存在printB方法，因此會嘗試自動轉型，呼叫的是implicit def A2B(x:TestA)，return  new TestB物件，這是第一次自動轉型
  //在執行printB方法時，由於def printB(x:TestC)接受的參數型態為TestC，與實際不符合，因此會嘗試自動轉型
  //呼叫的是implicit def B2C(x:TestA)，return new TestC物件，這是第二次自動轉型
  a.printB(new TestB)
  //a.printB(new TestB)  最終會變成 println(new TestC)


  println("======override toString方法，會直接印出toStirng的內容=====")
  println(new TestC)
  val bb = new TestC
  println(bb.toString)




}
