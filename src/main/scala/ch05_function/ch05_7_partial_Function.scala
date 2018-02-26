package ch05_function

object ch05_7_partial_Function extends App{

  /*
  *
  * 圖5-4
  *
  *
  * 定義域的x不能全部對應到值域的y，就稱作偏函數。
  * */


  /*
  *
  * scala中的偏函數定義為trait PartialFunction[-A, +B] extends(A=>B)
  *
  * 泛型參數A為偏函數的輸導入參數類型，泛型參數B為偏函數的傳回結果類型。
  *
  * 由於偏函數可以只處理參數定義域的子集，對子集之外的參數會拋出異常，這一特點使得偏函數與scala模式比對能夠完美結合。
  *
  * */

  println("==================")
  println("(1)偏函數的數入與輸出型別。")



  val sample = 1 to 10

  println(sample.getClass)

  val isEven:PartialFunction[Int,String] = {

    case x if x % 2 == 0 => x+ "  is even. "
  }

  println(isEven(10))
  println(isEven(10).getClass)


  //符合isEven方法的數，才會被提取出來
  println(sample.collect(isEven))


  val isOdd:PartialFunction[Int,String]={
    case x if x % 2 == 1 =>x+ "  is odd. "

  }

  println(isOdd(11))


  println("==================")
  println("(2)偏函數與map結合。")
  //多個偏函數丟入map裡進行資料判斷。
  val numbers = sample.map(isEven orElse isOdd)

  println(numbers)


  println("==================")
  println("(3)偏函數以Any、Unit修飾")
/*
*
* 表示receive方法，可以接受任何型態的參數，並且沒有回傳值。
*
* */


  def receive:PartialFunction[Any,Unit]={

    case x:Int=>println("Int Type")

    case x:String=>println("String Type")

    case _=>println("other type")
  }

  receive(10)

  receive("10")

//模式比對可以用在物件。
  val receivee:PartialFunction[Any,Unit]= {
    case x:Int=>println("Int Type")

    case x:String=>println("String Type")

    case _=>println("other type")

  }

  receivee(10)
//上面兩種方式意思相同，
}
