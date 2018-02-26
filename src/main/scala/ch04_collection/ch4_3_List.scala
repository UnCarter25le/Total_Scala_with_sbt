package ch04_collection

object ch4_3_List extends App{

  /*
  * List 是scala語言中應用十分廣泛的集合累類型資料結構，也是有immutable and mutable
  *
  * scala.collection.immutable.List[A]
  * * scala.collection.mutable.DoubleLinkedList[A]  and  LinkedList[A] and ListBuffer[A]
  *
  *
  * */


  //Nil 表示空集合

  //::  表示連接集合的符號

  println("(1)建立List，字串型態。")
  val listStr = List("Spark","Hive","Flink")

  println(listStr)

  val listStr2 = List.apply("Spark","Hive","Flink")

  println(listStr2)

  //以上兩個方法同意。
  println("==================")
  println("(2)建立List，數值型態。")

  val doubleList = List(1.0,2.0,3.0)

  println(doubleList(0))

  println("==================")
  println("(3)建立多維List。")

  val multiDList = List(List(1,2,3),List(4,5,6),List(7,8,9))

  println(multiDList)
  println(multiDList(0)(1))

  println("==================")
  println("(4)檢查List。")

  for (i <- multiDList) println(i)

  for (i <- multiDList) println(i.mkString)



  println("==================")
  println("(5)採用::、Nil，生成List")

  //::運算符號的優先順序是由右往左
  val nums = "yeap"::1::(2::(3::(4::Nil)))

  println(nums)

  val nums1 = 1::2::3::4::Nil

  println(nums)

  //兩個是同意的。

  println("==================")
  println("(6)List常用方法。")

  //是否為空
  println(nums1.isEmpty)

  //取第一個元素
  println(nums1.head)

  //除了第一個元素外的，其他元素，還是list
  println(nums1.tail)

  println(nums1.tails)
  println("=將前列的元素一個個拿掉，列印所有list結果=")
  for(i <- nums1.tails) println(i)
  println("==")

  //取第二個元素
  println(nums1.tail.head)

  //除了最後一個元素外的，其他元素，還是list
  println(nums1.init)


  println("==將後列的元素一個個拿掉，列印所有list結果")
  println(nums1.inits)
  for(i <- nums1.inits) println(i)
  println("==")

  //取最後一個元素
  println(nums1.last)

  //將元素反轉，還是list
  println(nums1.reverse)

  //反轉後，去掉最後一元素，還是list
  println(nums1.reverse.init)

  //去掉第一個元素，反轉，還是list
  println(nums1.tail.reverse)

  //去掉前n個元素，還是list
  println(nums1 drop 2)

  println(nums1.drop(2))
  //取得前n個元素，還是list
  println(nums1 take 3)

  println(nums1.take(3))

  println("將一list分割")
  println(nums1.splitAt(2))


  val nums2 = List(1,2,3,4,5)

  val chars = List('1','2','3','4')

  // 兩個list縫合，型態是tuple
  println(nums2.zip(chars))

  val ggg = nums2.zip(chars)

  println(ggg(0).getClass)

  println(nums2.toString)

  println(nums2.mkString(";"))


  //list可以轉成Array
  println(nums2.toArray)

  val fff = nums2.toArray

  println(fff(0))



  println("兩個list合併")
  println(List(1,2,3):::List(4,5,6))



  println("==================")
  println("(7)List衍生物件方法。")

  println(List(1,2,3))
  println(List.apply(1,2,3))

  //until 效果
  println(List.range(2,6))
  //索引值間隔n
  println(List.range(2,6,3))

  println(List.range(6,2,-2))

//  println(List.makes(5,"hey"))

  //List中有List元素，將其flatten攤平
  val xss = List(List('a','b'),List('c'),List('d','e'))
  println(xss)
  println(xss.flatten)

  //List的相加，元素會自己加進原來的LIst
  val hhh = List.concat(List('a','b'),List('c'))
  println(hhh)
}
