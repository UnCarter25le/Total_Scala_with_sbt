package ch05_function

object ch05_2_function_literal extends App{

  println("==================")
  println("(1)function literal 函數字面常數、或稱值函數。")
  /*
  *
  * scala語言中函數也是物件，也可以指定給變數物件。
  *
  *
  *
  * 圖5-2
  *
  *
  * => 為函式映射符號
  * 以下的方法是匿名函式用法；也稱作lambda運算式
  * 把匿名函式指定給變數後，變數可以以呼叫函數的方式，定義匿名函式導入值，進而得到回傳值。
  *
  * 值函數不像普通函數一樣，需要指定回傳值型態。
  *
  *
  *
  * */

  //將匿名函數指定給變數物件，稱為值函數。
  val sum=(x:Int,y:Int)=>{
    x+y
  }

  println(sum(10,20))
//  val summ =(x:Int,y:Int):Int=> {x+y}


  println("==================")
  println("(2)值函數也可以使用lazy修飾；當使用該變數時，函數才會被建立。")


  val f = (x:Double)=>x*2

  println(f(2.0))


  lazy val ff = (x:Double)=>x*2

  println(ff.getClass)
  println(ff(9.2))
  println(ff(9.2).getClass)


  println("==================")
  println("(3)值函數應用在map迭代方法的簡化；高階函式的應用。")

  /*
  * 值函數最常使用的場景是作為高階函數的輸入。
  *
  * */


  val arrInt = Array(1,2,3,4)

  val increment = (x:Int)=> x+1

  println(arrInt.map(increment))
// 產出是 res0: Array[Int] = Array(2, 3, 4, 5)
  println(arrInt.map{x:Int => x+1})
//  上面兩種寫法同意。


  println(arrInt.map{x=>x+1})
//  由於arrInt是整數陣列，所以可由回傳值定義型態，型態可以省略。


  println("==================")
  println("(4)值函數進一步的簡化。")

  /*
  * 若匿名函式的導入參數在映射符號右側只出現一次，則可以將參數用預留符號 _ 代替；
  *
  * 不過不能對increment進行同樣的簡化，因為型別推斷會錯誤；除非明確指定類型。
  *
  * */


  println(arrInt.map(_+1))


//無法進行類型推斷  val increment = 1+_
  val incrementt = (_:Int)+1

  val incrementtt: Int => Int= _ + 1








}
