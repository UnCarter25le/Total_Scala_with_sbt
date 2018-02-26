package ch04_collection

object ch4_4_Set extends App {
/*
* set裡的元素不可重複；也無順序。
*
*
* */


  import scala.collection.mutable.Set

  val numsSet = Set(3.0,5)

  println(numsSet)

  println("==================")
  println("(1)Set增加元素的方式")

  println(numsSet+6)

  //set插入元素時，並不保證元素的順序；Set的實現方式是hashSet，集中的元素透過hashcode值進行組織（不重複）

  println("==================")
  println("(2)Set檢查")

  for (i <- numsSet+6) println(i)

  println("==================")
  println("(3)在意順序的話，使用mutable.LinkedHashSet")

  val linkedHashSet = scala.collection.mutable.LinkedHashSet(3.0,5)

  println(linkedHashSet)

  println(linkedHashSet+6)

  println(linkedHashSet.+=(7.0))

  println(linkedHashSet.dropWhile(p => p == 3.0))


}
