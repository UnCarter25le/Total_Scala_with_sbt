package ch03_loop

object ch03_3_for_loop extends App{

  /*
  * 無論for loop  或者while loop  ，scala語言都沒有提供java語言中的break and  continue關鍵字；
  * 但是if 卻是有的。
  *
  * python中都有的！
  *
  * */




  println("=========")
  println("（1）_1_ 基本敘述")

  /*
  * for(i <- 運算式）{
  *
  * //執行循環中的敘述
  *
  * }
  *
  *
  * <-  is generator
  *
  *
  * for循環是透過對集合的檢查來達到循環的目的。
  **/

  /*
  * 1 to 5  相當於  1.to(5)
  * 整數沒有to方法，會將Int類型自動轉形成scala.runtime.RichInt類型
  * 然後呼叫RickInt中的to方法
  *
  * def to(end:Int): Range.Inclusive = Range.inclusive(self,end)
  *
  * */


  for(i <- 1 to 5){
    println("i="+i)
  }


  for(i <- 1.to(5)){
    println("i="+i)
  }

  /*
  *  所以 to 的範圍是[1-5]
  *  上界下界都包含
  * */
  println("==============")
  println("（1）_2_ until")

  for(i <- 1 until 5){
    println("i="+i)
  }

  /*
  *  所以 until 的範圍是[1-4)
  *  下界不包含5
  * */


  println("==============")
  println("（1）_3_ step值（步進值）")

//  印出起始值後，每間隔多少，在印出下一個
  for(i <-1 until(10,2)) println("i="+i)
/*
*1 until(10,2)呼叫是RichInt 的until方法：
*
* def until(end:Int,step:Int):Range = Range(self,end,step)
*
* */



  for(i <- 1 to(11,2)) println("i="+i)
  /*
  *1 to(10,2)呼叫是RichInt.inclusive 的to方法：
  *
  * def until(end:Int,step:Int):Range = Range.inclusive(self,end,step)
  *
  * */


  println("==============")
  println("（1）_4_ 提供跟break同樣功能的寫法")

  import scala.util.control.Breaks._

//  透過提供Boolean類型的變數，在for and while 迴圈中進行條件判斷，跳出迴圈。

  breakable(
    for(i <- 1 to 5){
      if(i > 2 ) break
      println("i=" + i)
    }
  )


  println("==============")
  println("（1）_5_ 有條件地過濾for循環")

  /*
  * for(x <- 運算式 if 條件判斷1; if 條件判斷2;...){
  *
  * //所有條件都滿足時，才會執行循環中的敘述。
  * }
  *
  * */

  //  循環運算式中加入過濾條件，在for and while 迴圈中進行條件判斷，跳出迴圈。

  for(i <- 1 to 5 if(i < 3) ){

    println("i= "+i)
  }


  for (i <- 1 to 40 if (i % 4 == 0);if(i % 5 == 0)){

    println("i= "+i)

  }

  println("==============")
  println("（1）_6_ 多重for 循環")

  /*
  * for(x <- 運算式 if 條件判斷1; if 條件判斷2;...){
  *   for(x <- 運算式 if 條件判斷1; if 條件判斷2;...){
  *
  *   //所有條件都滿足時，才會執行循環中的敘述。
  *
  *   }
  *
  * }
  *
  *
  * */

  for(i <- 1 to 5 if (i > 3)){
    for(j <- 5 to 7 if (j == 6)){
      println("i="+i+",j="+j)

    }

  }


  println("==============")
  println("（1）_7_ 將for loop值指定給物件")

  /*
  * for 循環同關鍵自yield一起使用可作為運算式，循環執行完成後對每一個"傳回值"做另外處理。
  *
  * 經過yield處理過得回傳值，是個vector
  *
  * */

  var x = for (i <- 1 to 5) yield i
  println(x)
  println(x.getClass)


  var xx = for(i <- 1 to 5) yield i%2==0
  println(xx)
  println(xx.getClass)

  var xxx = for(i <- 1 to 5) yield i/2

  println(xxx)
  println(xxx.getClass)





}
