package ch03_loop

object ch03_1_if extends App{




  /*
  * if(條件判斷)
  * {
  *
  * 條件判斷為真時執行
  *
  * }
  *
  *
  * */
  println("=========")
  println("（1）_1_if敘述")

  val x = 8

  if(x<10) println(s"$x is smaller than 10")



  println("=========")
  println("（1）_2_if  else 敘述")

  /*
* if(條件判斷)
* {
*
* 條件判斷為真時執行
*
* }else{
*
* 條件判斷為假時執行
*
* }
*
*
* */


  val xx = 9

  if(xx<9) println("small") else println("big")

  println("=========")
  println("（1）_3_if  else 多重敘述")

  /*
* if(條件判斷2)
* {
*
* 條件判斷為真時執行
*
* }else if (條件判斷2){
*
* 條件判斷為真時執行
*
* }else{
*
* 條件判斷為假時執行
* }
*
*
* */


  //  python 中else if 簡化為elif
  if (x == 8){
    println("8")
  }else if (x == 7){
    println("7")
  }else if (xx == 9){
    println("9")
  }else{
    println("other")
  }

  //x=8  xx=9 在上面的敘述都符合，但編譯器會優先以最上面的為主

  println("=========")
  println("（1）_4_if  巢狀結構")

  /*
* if(條件判斷1){
*   if(條件判斷2){
*
*     條件2真時執行
*   }else{
*     條件2為假時執行
*   }
*
* }else{
*
*   條件1為假時執行
* }
* */

  val xxx =9
  if(xxx < 10){
    if(xxx ==9){
      println("9")
    }else{
      println("other")
    }

  }else{
    println("bigger than 9")
  }



  println("=========")
  println("（1）_5_if 運算式，將if的回傳值，指派給變數")

  val xxxx = if("hello" == "hello") 1 else 0

  println(xxxx)

  val xxxxx = if("hello" == "hell") println("1") else println("0")











}
