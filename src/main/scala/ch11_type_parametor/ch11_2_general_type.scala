package ch11_type_parametor

import scala.collection.{GenMap, MapLike, mutable}

/*
* 在java中泛型語法格式為< >，在scala中是[ ]。使用的效果一樣，只是撰寫的形式不一樣。
*
*
*
*
*
* */



object ch11_2_general_type extends App{


  println("===============")
  println("(1)只有一個泛型參數")

  //類別的主建構子參數型態是T
  class Person[T](var name:T)

  class Student[T](name:T) extends Person[T](name)


  println(new Student[String]("後來的我們").name)





  println("===============")
  println("(2)兩個以上的泛型參數")


  class Student2[T,S](name:T, var age:S) extends Person(name)

  println(new Student2[String,Integer]("後來的我們",10).age)


  println("===============")
  println("(3)泛型介面與泛型方法。")

  //scala泛型介面，透過trait替代java interface來實做泛型介面。

//  trait Map[A, B] extends Iterable[(A,B)] with GenMap[A,B] with scala.collection.Map[A,B] with MapLike[A,B,Map[A,B]]
//
//  override def empty: Map[A,B] = Map.empty
//
//  override def seq: Map[A,B] = this





  println("===============")
  println("(4)_1_類型萬用字元，配合scala的存在類型（Existential） ")


  // 在scala中，透過存在類型（Existential） 來解決沒辦法使用java泛型萬用字元  "？"  的問題
  //語法為:  類別[T] forSome {type T}

  val arrStr:Array[String] = Array("Hadoop","Hive","Spark")
  val arrInt:Array[Int] = Array(1,2,3)

  printAll(arrInt)
  printAll(arrStr)

  def printAll(x: Array[T] forSome {type T})={
    for(i <- x){
      print(i + " ")
    }
    println()
  }


  println("=======簡化=======")
  val arrStrr: Array[String] = Array("Hadoop", "Hive", "Spark")
  val arrIntt: Array[Int] = Array(1, 2, 3)
  printAlll(arrStrr)
  printAlll(arrIntt)

  //透過_簡化設計，Array[_]與Array[T] forSome {type T}等值 ；  "_"  可以視為scala風格的萬用字元。
  def printAlll(x: Array[_]) = {
    for (i <- x) {
      print(i + " ")
    }
    println()
  }

  println("===============")
  println("(4)_2_類型的參數變為多個。")

  //語法為:  類別[T,U,...] forSome {type T; type U; ...}

  var MapInteger = new scala.collection.mutable.HashMap[String,Int]()

  MapInteger.put("hey", 1)
  MapInteger.put("heyy",2)


  //使用萬用字元 "_"
  def prin(x:scala.collection.mutable.HashMap[_,_]) = {
    for(jj <- x){
      print(jj + " ")
    }
    println()
  }

  prin(MapInteger)

  //使用存在類型方法

  def pri(x:scala.collection.mutable.HashMap[T,S] forSome {type T; type S}) = {
    for(jj <- x){
      print(jj + " ")
    }
    println()

  }
  pri(MapInteger)

  println("===============")
  println("()")


  println("===============")
  println("()")

}
