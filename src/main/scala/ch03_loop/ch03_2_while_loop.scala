package ch03_loop

object ch03_2_while_loop extends App{

  println("=========")
  println("（1）_1_ while 敘述")

  /*
* while(條件判斷1){
*    條件2真時執行
* }
*
* */

  var i = 15
  while(i<20) {
    println("i=" + i)
    i += 1
  }


  println("=========")
  println("（1）_2_ do  while 敘述")

  /*
*
* do{
*    不管有沒有符合條件，都會先執行；如果符合while的條件判斷，do區就會一直做
* }
* while(條件判斷1)
*
* */


  var ii = 15

  do{
    println("ii=" + ii)
    ii += 1
  }while(ii < 20)


  /*
  *
  * while也有回傳值，型態為Unit（沒辦法印出他的值）；所以可以指派給變數
  *
  * */


  var iii = 15

  var xx = while(iii< 20){
    println("iii = " + iii)
    iii += 1
  }
  println(xx)
  println(xx.getClass)



  /*
  * scala屬函數式語言，推崇使用val類型變數，而使用while需要搭配var，可見scala並不是純函數式語言。
  *
  *
  *
  * */





}
