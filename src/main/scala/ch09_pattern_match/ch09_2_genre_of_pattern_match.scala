package ch09_pattern_match

object ch09_2_genre_of_pattern_match extends App {

  println("==============")
  println("(1)常數模式。")

  //case敘述後面接的全部為常數，稱為常數模式。

  for (i <- 1 to 5 ){

    i match{

      case 1 => println(1)
      case 2 => println(2)
      case 3 => println(3)
      //   case _ 表示比對其他的情況
      case _ => println("其他")
    }
  }

  /*
  * 其他類型的常數：null、Nil(空列表)、布林true or false、char
  *
  * */

  println("==============")
  println("(2)變數模式。")

  for (i <- 1 to 6){
    i match {
      case 1 => println(1)
      //變數模式，可以比對任何值
      case x if (x % 2 == 0)=> println(s"$x 可以被2整除")
      case _ =>
    }
  }

  println("==============")

  //比對變動的參數，是變數模式
  def patternMatching(x:Int) = x match{
    case 5 => "整數5"
    case x if (x%2 == 0) =>"能被2整除的數"
    case _ => "其他整數"

  }
  println(patternMatching(5))
  println(patternMatching(2))
  println(patternMatching(3))

  println("==============")
  def patterMatchingg(x:Int) = x match{
    //case i == case _
      //所以模式比對也要注意比對順序
    case i => "比對任何整數，因為是最先被比對的，所以後面兩條變數模式不會執行"
    case i if(i % 2 == 0) => "被2整除"
    case i if(i % 3 == 0) => "被3整除"
  }

  println(patterMatchingg(2))
  println(patterMatchingg(3))
  println(patterMatchingg(4))

  println("==============")
  println("(3)建構函數模式。")

  /*
  * 建構函數模式要做的事情與建立物件建構子想返，用於解構物件。
  *
  * 模式比對是比對物件（含有建構子的物件）
  *
  * */

  case class Dog(val name:String,val age:Int)

  //案例物件會呼叫object Dog，使用apply方法建立物件
  val dog = Dog("Pet",2)

  def patterMatchingg(x:AnyRef) = x match{

    case Dog(name,age) => println(s"Dog name = $name, age = $age")
      //比對成功，將建構子解出來，指定給後面的變數
    case _ =>
  }
  patterMatchingg(dog)

  def patternMatchinggg(x:AnyRef) = x match{

    case Dog(_,age) => println(s"Dog age = $age")
      //表示Dog物件的第一個建構子是什麼都不管
    case _ =>
  }

  println(patternMatchinggg(dog))


  println("==============")
  println("(4)序列模式。")

  /*
  * 序列模式，與建置序列的作用相反，用於對被比對的序列中的元素內容進行析取。
  *
  * */

  val arrInt = Array(1,2,3,4)
  def patternMatchingQ(x:AnyRef)= x match {

//  arrInt有4個元素，所以不會比在這裡。
    case Array(first,second) => println(s"序列中的第一個元素=$first,第二個元素=$second")
//      _*代表序列中剩餘的其他元素
    case Array(first,_,three,_*) => println(s"序列中第一個元素=$first,序列中第三個元素=$three")

    case _ =>
  }
  patternMatchingQ(arrInt)

  /*
  *
  * 序列模式與建構函數模式有一定的相似之處，首先都次透過類別名來進比對。
  * 其次，都可以使用萬用字元"_"來比對不需要析取的內容，
  * 但與建構函數模式所不同的是，由於陣列的元素個數會非常大，所以序列模式可以使用"_*"比對序列中剩餘的許多元素內容，建構函數模式則不可以。
  *
  *
  *      _*，只能用序列模式！！
  * */


  println("==============")
  println("(5)元組模式。")

  /*
  * tuple可以將不同類型的值組合成一個物件。
  * 組成後m元素不得更改。
  *
  * */

  val tuple = ("nest",1)

  val tupleInt=(1,2,3,4)

  def patternMatchhhh(x:AnyRef) = x match {

    case (first,second) => println(s"元組中第一個元素= $first,第二個元素 = $second")

      //元祖模式不能使用  _*
    case (first,_,three,_) => println(s"元組中第一個元素=$first,序列中第三個元素=$three")

    case _ =>
  }
  patternMatchhhh(tupleInt)

  println("==============")
  println("(6)類型模式。")

  /*
  *
  * scala是一種靜態類型語言，任何變數在定義時都有類型的！
  * 在不指定的情況下，scala會使用類型推導，確定變數的類型。
  *
  * */


  class A
  class B extends A
  class C extends A

  val b = new B

  val c = new C

  def patternMatchi(x:AnyRef) = x match {

    case x:String => println("字串類型")
    case x:B => println("物件類型為B")
    case x:A => println("物件類行為A")
    case _=> println("其他類型")
  }

  patternMatchi("scala pattern matching")
  patternMatchi(b)
  patternMatchi(c) //c的類型為A的子類別，仍滿足case x:A；模式比對也有多型！！！！！

  println("==============")
  println("(7)變數綁定模式。")

  /*
  * case Dog(name,age) => println(s"Dog name = $name, age = $age") 是析取物件成員；
  *
  * 如果不要析取物件，而是要傳回比對該模式的物件，就要用變數綁定。
  *
  * */

  case class Dogg(val name:String,val age:Int)

  val dogg = Dog("Peet",2)

  def patternMatchh(x:AnyRef) = x match {
//    d  是自訂的
    case d@Dog(_,_) => println("變數綁定模式傳回的變數值為：" + d )
    case _ =>
  }

  patternMatchh(dogg)


  val list = List(List(1,2,3,4),List(4,5,6,7,8,9))

  def patternMatcc(x:AnyRef) = x match {

    case e1@List(_,e2@List(4,_*)) => println("變數e1="+e1  +  "\n,變數e2="+e2)
    case _ =>
  }
  patternMatcc(list)


  println("==============")
  println("()")


}
