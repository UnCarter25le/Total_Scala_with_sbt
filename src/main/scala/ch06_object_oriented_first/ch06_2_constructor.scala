package ch06_object_oriented_first

object ch06_2_constructor extends App{

  println("==================")
  println("(1)主建構子的建立。")

  /*
  * 區域變數和建構函數交織在一起的簡化呈現。
  *
  * */

  //class本身就具有帶建構子的功能；建構子需要定義val or var ，方法不用
  class Person(var name:String, var age:Int)

  /*
  * 當創立這樣的式子，scala就幫忙就作到
  * 1   定義一個類別，並實現建構子函數
  * 2    定義成員變數
  * 3   分別產生name  and  age對應scala風格setter  and getter方法
  *
  * */

  println("==================")
  println("(2)主建構子建立同時，仍可以複寫方法。")

  class Person_2(val name:String, val age:Int){

    println("constructing Person_2...")

    override def toString() = name + ":" +age
    //println時，就可以列印出程式

  }

  val p = new Person_2("john",19)

  println(p)

  println("==================")
  println("(3)預設參數的主建構子，可用預設或不用都可以。")

  class Person_3(var name:String="",var age:Int=18){

    override def toString()="name="+name+",age="+age
  }

  //不指定參數，使用預設值。
  val pp = new Person_3()
  println(pp)

  //指定name，但不指定age
  val ppp = new Person_3("John")
  println(ppp)

  println("==================")
  println("(4)部份參數是預設的主建構子。")

  class Person_4(var name:String,var age:Int =18){
    override def toString()="name="+name+",age="+age
  }

  val pppp = new Person_4("carter")
  println(pppp)

  println("==================")
  println("(5)私有主建構函數。")

  /*
  * 上述建構子的建立，預設都是public，所以都可以用物件去存取建構子。
  *
  * 可以透過private來將建構子參數私有化 。
  *
  * 不過怎麼存取呢？？？??????????????????????????????????????????????/
  * */

  class Person_5 private(var name:String,var age:Int){

    override def toString()="name="+name+",age="+age
  }

  object Person_5{

//    def apply(name:String,age:Int) ={ new Person_5(name,age)}

  }


  //無法如下使用
//  val ppppp = new Person_5("carter",19)
//  println(ppppp.age)

}
