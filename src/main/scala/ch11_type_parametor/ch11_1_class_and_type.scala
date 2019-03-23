package ch11_type_parametor

//引用套件，可以使用typeOf取得類型資訊
import scala.reflect.runtime.universe._


import java.util



object ch11_1_class_and_type extends App{


  println("(1)類別與類型。")

  class Test

  val a = new Test

  //取得類型資訊。
  println(typeOf[Test])

  //取得類別資訊，相當於java中的Test.class
  println(classOf[Test])

  //使用getClass方法取得Class[Test]的子類別
  println(a.getClass)


  println("===========")

  val listStr = new util.ArrayList[String]()

  val listInteger = new util.ArrayList[Integer]()

  println(listInteger.getClass)

  println(listStr.getClass)

  println("=====類型不同，一個是Integer、另一個是String======")
  println(typeOf[List[Integer]])

  println(typeOf[List[String]])

  println("=====類別相同，都是scala.collection.immutable.List======")
  println(classOf[List[Integer]])

  println(classOf[List[String]])


}
