package ch08_package   //套件以資料夾區分；這份檔案在ch08_package下，所以表頭需要有這行指令。

object ch08_1_what_is_package extends App{


  /*
  * java語言中使用套件來進行大型工程程式的組織，scala也是如此。
  *
  *
  *
  * */


  abstract class Animal{

    var height:Int

    def eat:Unit

  }

  class Person(var height:Int) extends Animal{
    override def eat()={
      println("eat by mouth")
    }
  }

  object Person extends App{
    new Person(172).eat()
  }


}
