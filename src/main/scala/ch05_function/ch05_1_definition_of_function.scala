package ch05_function

object ch05_1_definition_of_function extends App{



  /*
  * 圖5-1
  *
  *
  * */


  println("==================")
  println("(1)函數本體只有一行敘述。")
  /*
  * 函數本體只有一行敘述時，可以省略{}
  *
  *
  * */

  def gcd(x:Int,y:Int):Int = if (x%y==0) y else gcd(y,x%y)

  println(gcd(10,20))


  println("==================")
  println("(2)函數本體最後一行，預設為return。")

  def gcdd(x:Int,y:Int):Int={

    if(x%y==0)
      return y
    else
      gcd(y,x%y)
  }

  println(gcdd(10,20))


  println("==================")
  println("(3)自動推導類型。")

  /*
  * scala具有類型推導的功能，會根據最後的回傳值推導型態。
  *
  * */

  def sum(x:Int,y:Int)=x+y

  println(sum(10,20))


  println("==================")
  println("(4)函數的推導類型限制。")

  /*
  *
  * 如果使用return，函數就要指定類型。
  *
  * 如果回傳值是個方法，則要指定類型。
  *
  * */

//  def summ(x:Int,y:Int)= return x+y

//  def gcff(x:Int,y:Int)={
//
//    if(x%y==0)
//      y
//    else
//      gcd(y,x%y)
//  }
//
//  println(gdff(10,20))



}
