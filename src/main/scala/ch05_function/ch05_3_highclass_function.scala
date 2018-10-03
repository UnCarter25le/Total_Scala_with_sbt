package ch05_function

object ch05_3_highclass_function extends App{

  println("==================")
  println("(1)高階函數的定義。")

  /*
  * 高階函數定義：函數的參數也是一個函數，例如5-2節的例子。
  *
  * */


  def higherOrderFunction(f:Double=>Double)= f(100)


//  定義輸入的方法，它的參數型態必須是Double，傳回值型態是Double
  def sqrt(x:Double) = Math.sqrt(x)

  //代表higherOrderFunction接受的參數要是函式才可以。
  println(higherOrderFunction(sqrt))


  println("==================")
  println("(2)高階函數的傳回值是函數。")

// 此函數的傳回型態是Double=>Double
  def highOrderFunctionn(factor:Int):Double=>Double={
    println("傳回新的函數")

    (x:Double)=>factor*x

  }

  println(highOrderFunctionn(10))


  println("==================")
  println("(3)scala也可以進行函數類型的推導。")

  def highOrderFunctionnn(factor:Int)=(x:Double)=>factor*x

  println(highOrderFunctionnn(10).getClass)

  val multiply = highOrderFunctionnn(100)

  println(multiply(10))
  println(multiply(10).getClass)


  println("==================")
  println("(4)常見集合高階函數應用。")

  /*
  * def map[B](f:(A) B):Array[B]
  * 將函數f應用於陣列所有元素，並傳回一個新的陣列Array[B]。
  * A是參數型態、B是傳回值型態
  *
  * */

  println("==================")
  println("(4)_1_map。")

  val array = Array("spark","hive","hadoop").map(_*2)
  println(array)

  val list = List("spark" -> 1,"hive" -> 2,"hadoop" -> 2)
  println(list)

  println(list.map(x=>x._1))  // ._1 只取key的意思

  println(list.map(_._1))


  val MMap = Map("spark"->1,"hive"->2,"hadoop"->3).map(_._1)
  println(MMap)

  val MMMap = Map("spark"->1,"hive"->2,"hadoop"->3).map(_._2)
  println(MMMap)

  println("==================")
  println("(4)_2_flatMap。")

  /*
  *
  * def flatMap[B](f:(A)  GenTraversableOnce[B]):Array[B]
  *
  *
  * */

  val listInt = List(1,2,3)

//  flatMap作用於每個元素時，要求傳回的是集合
  val tt = listInt.flatMap(x => x match{

    case 1 => List(1)

    case _ => List(x)
  })

  println(tt)

  println("==================")
  println("(4)_3_map and flatMap差異。")



  //val listInt = List(1,2,3)

  //map  每迭代一個元素，就成為一個集合
  val rr = listInt.map(x=> x match{
    case 1 => List(1)

    case _ => List(x*2,x*3,x*4)

  })

  println(rr)

  //flatmap迭代完元素後，才會形成集合
  val dd = listInt.flatMap(x=> x match{
    case 1 => List(1)

    case _ => List(x*2,x*3,x*4)

  })

  println(dd)


  println("==================")
  println("(4)_4_filter。")

  /*
  * def filter(p:(T) Boolean):Array[T]
  *
  * 傳回所有滿足條件p的元素集合
  * */

  val listIntt = List(1,4,6,8,6,9,12)

  val qq = listIntt.filter(x=>x>6)

  println(qq)

  val hh = listIntt.filter(_>6)

  println(hh)


  println("==================")
  println("(4)_5_reduce。")
/*
*
* def reduce[A1 >: A](op: (A1,A1) A1):A1
*
* 按照一個順序，持續跌加過去。
*
* */


  Array(1,2,3,4,5).reduce((x:Int,y:Int)=>{println(x,y); x+y})

  println("==")
  println(Array(1,2,3,4,5).reduce(_+_))

//  以上兩個同意思。
  println("==")
  Array(1,2,3,4,5).reduceLeft((x:Int,y:Int)=>{println(x,y); x+y})
  println("==")
  Array(1,2,3,4,5).reduceRight((x:Int,y:Int)=>{println(x,y); x+y})
  println("==")


  println("==================")
  println("(4)_5_fold。")
/*
*
* fold{  (error handling)  , (correct handling )}
*
*
* 0為指定初始值。
*
* */

  Array(1,2,3,4,5).fold(0)((x:Int,y:Int)=>{println(x,y);x+y})

  println(Array(1,2,3,4,5).fold(0)(_+_))

/*
* foldLeft按左到右的順序進行fold操作。
*
* foldRight相反。
*
* */

  println("=====")
  Array(1,2,3,4,5).foldLeft(0)((x:Int,y:Int)=>{println(x,y);x+y})
  println("=====")
  Array(1,2,3,4,5).foldRight(0)((x:Int,y:Int)=>{println(x,y);x+y})

}
