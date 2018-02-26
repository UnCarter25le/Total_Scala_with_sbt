package ch08_package

import scala.collection.mutable

object ch08_4_feature_of_import extends App{



  println("==================")
  println("(1)隱式引用")
  /*
  * 不引用任何套件，scala會預設引用java.lang._  and  scala.Predef._ 物件中的所有類別和方法
  *
  *
  * */

  //在REPL中，輸入:import，可以查看預設的引用。


  println("==================")
  println("(2)引用重新命名")

  /*
  * 例如需要同時引用java.util.HashMap  and  scala.collection.mutable.HashMap時，可以使用重新命名以防命名衝突。
  *
  * */

  //將java的HashMap重新命名成JavaHashMap
  import java.util.{HashMap => JavaHashMap}
  import scala.collection.mutable.HashMap

  println("java=======")
  val javaHashMap = new JavaHashMap[String,String]()
  javaHashMap.put("Spark","excellent")
  javaHashMap.put("MapReduce","good")
  //keySet() 取出所有的key
  for(key <- javaHashMap.keySet().toArray){
    println(key+":"+javaHashMap.get(key))
                                //get(key) 取出值
  }

  println("scala=======")
  val scalaHashMap = new HashMap[String,String]()
  scalaHashMap.put("Spark","excellent")
  scalaHashMap.put("MapReduce","good")
  scalaHashMap.foreach(e =>{

    //tuple指定
    val (k,v) = e
    println(k+":"+v)
  })


  println("==================")
  println("(3)引用的套建中隱藏類別")


  import java.util.{HashMap => _,_}  //如此，除了java HashMap這個類別不引用外，其他都引用。
  import scala.collection.mutable.HashMap

  //這邊的HashMap就是指scala的
  val scalaHashMap_1 = new HashMap[String,String]()
  scalaHashMap_1.put("Spark","excellent")
  scalaHashMap_1.put("MapReduce","good")
  scalaHashMap_1.foreach(e =>{

    //tuple指定
    val (k,v) = e
    println(k+":"+v)
  })


}
