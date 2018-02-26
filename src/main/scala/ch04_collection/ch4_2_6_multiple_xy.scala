package ch04_collection

object ch4_2_6_multiple_xy extends App {

  var multiDimArr = Array(Array(1,2,3),Array(4,5,6))


  //取第0列第2行的元素
  println(multiDimArr(0)(2))



  for(i <- multiDimArr) {
    //將每一個陣列做轉字串處理
    println(i.mkString(";"))
  }

  println("==========")
  println("對多為陣列可以透過多重for迴圈來檢查。")
  //先將每一個陣列指定給i，再將陣列內的元素指定給j

  for ( i <- multiDimArr){
    for(j <- i) {

      println(j+" ")
    }

  }

}
