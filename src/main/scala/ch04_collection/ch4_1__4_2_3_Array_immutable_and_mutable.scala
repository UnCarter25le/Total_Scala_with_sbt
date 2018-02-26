package ch04_collection

//4-1 ~ 4-2.3

object ch4_1__4_2_3_Array_immutable_and_mutable extends App {
  //陣列是相同資料類型的元素，按一定順序排列的集合。可分為immutable、mutable。


  println("(1)以new 來創立immutalbe Array。長度不可變，內容可以變。")
  //以Array為例
  //數值物件類型被初始化為0
  val numberArray = new Array[Int](10)
  
  //指定索引0為1
  numberArray(0) = 1

  println(numberArray(0))
  println(numberArray(2))

  //非數值物件類型在陣列定義被初始化為null
  val strArray = new Array[String](10)

  strArray(0) = "First element"
  
  println(strArray(0))
  println(strArray(1))

  println("================================")
  println("(2)不用new來創立immutable Array。長度不可變，內容可以變。")

  val strArray2 = Array("First element","Second element")
                      //可以直接指定，是因為有apply方法

  println(strArray2(0))

//  strArray2(2)="third element"      // 會出錯，因為immutable array
//  println(strArray2(2))

  println("================================")
  println("(3)不需要new，創立mutable ArrayBuffer。")
  //以ArrayBuffer[String]為例

  import scala.collection.mutable.ArrayBuffer

  val strArrayVar = ArrayBuffer[String]()
                                    //因為是mutable，所以（）可以空白

  //用＋＝ ，在後面增加元素
  strArrayVar += "Hello"

  println(strArrayVar)

  strArrayVar += "yeap"

  println(strArrayVar)

  strArrayVar += ("carter","yang")

  println(strArrayVar)


  //用＋＋＝ ，在後面增加任何集合，會將集合內的元素加進來原來的集合

  strArrayVar ++= Array("is","the","baseball player")

  println(strArrayVar)

  strArrayVar ++= List(";","and" ,"also","the","basketball player")

  println(strArrayVar)

  //trimEnd()刪除最後面的元素

  strArrayVar.trimEnd(5)

  println(strArrayVar)

  //insert加入元素。在索引0的位置加入多個元素
  strArrayVar.insert(0,"lalala","yayaya")

  println(strArrayVar)

  println("================================")
  //以ArrayBuffer[Int]為例

  var intArrayVar = ArrayBuffer[Int]()

  //insert加入元素
  intArrayVar.insert(0,6)

  println(intArrayVar)

  //在索引0的位置加入多個元素
  intArrayVar.insert(0,3,4,5)

  println(intArrayVar)

//  intArrayVar.trimEnd(2)  //刪除最後兩個元素
//  intArrayVar.remove(2)    // 刪除索引值為2的元素
  intArrayVar.remove(2,2)   //從索引值2開始，刪除兩個元素

  println(intArrayVar)



  println("================================")
  println("(4)mutable ArrayBuffer and immutalbe Array的轉換。")

/*********************************
*                                *
*
*
*
*
* ********************************/

  var ggg = intArrayVar.toArray

  println(ggg(0))

  println(intArrayVar.toArray.toBuffer)
}
