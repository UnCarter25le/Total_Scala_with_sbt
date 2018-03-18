package ch09_pattern_match

object ch09_5_pattern_match_in_for_loop extends App{

  /*
  * 被for迴圈迭代的集合，可以指定給物件，不只是變數而已。
  *
  * */



  println("==============")
  println("(1)變數模式比對。")


  for(i <- 1 to 5){
    print(i +" ")
  }

  println


  for((language,framwork) <- Map("Java" -> "Hadoop","Closure" -> "Storm", "Scala" -> "Spark")){
    println(s"$framwork is developed by $language language.")

  }


  println("==============")
  println("(2)常數模式比對。")

  //Spark 已經固定位置。
  for((language,"Spark") <- Map("Java" -> "Hadoop","Closure" -> "Storm", "Scala" -> "Spark")){
    println(s"Spark is developed by $language language.")

  }



  println("==============")
  println("(3)變數綁定模式比對。")

//  e可以隨意命名
  for((language,e@"Spark") <- Map("Java" -> "Hadoop","Closure" -> "Storm", "Scala" -> "Spark")){
    println(s"$e is developed by $language language.")
  }


  println("==============")
  println("(4)類型模式比對")

//  因為Java and Strom的value都是數字，所以framework只好是spark
  for((language,framework:String) <- Map("Java" -> "Hadoop".length,"Closure" -> "Storm".length, "Scala" -> "Spark")){
    println(s"$framework is developed by $language language.")

  }

  println("==============")
  println("(5)建構函數模式比對")

  case class Dog(val name:String, val age:Int)

  for(Dog(name,age) <- List(Dog("Pet",2),Dog("Penny",3),Dog("Digo",2))){

    println(s"Dog $name is $age years old.")
  }


  println("==============")
  println("(6)序列模式比對")

  for(List(first,_*) <- List(List(1,2,3),List(4,5,6,7))){

    println(s"the first element is $first")
  }


  println("==============")
  println("()")




}
