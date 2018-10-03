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


  //Nil 表示List的空集合
  println(Nil)
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

  println(nums1)

  //  val nums22 = 1::2::3 // 會報錯，使用::、:::  一定要跟list或Nil搭配。
  // :: 會將右邊的物件，以元素的形式和左邊物件相加。
  // ::: 兩旁一定是集合；將雙方集合的元素打散重組起來。

  println(List(5,7)::List(2,3))
  println(List(5,7):::List(2,3))

  println(4::5::(11::(22::List(111,222))))


  println("==================")
  println("(6)List常用方法。")

  //  nums1 = List(1, 2, 3, 4)
  //是否為空
  println(nums1.isEmpty)

  //取第一個元素
  println(nums1.head)

  //除了第一個元素外的，其他元素，還是list     ；跟 nums1.init相反
  println(nums1.tail)

  println(nums1.tails)
  println(nums1.tails.mkString(" "))
  println("==================")
  println("(6)_1_將前列元素從首部一個個拿掉，列印所有list結果=")
  for(i <- nums1.tails) println(i)
  println("==")

  //取第二個元素
  println(nums1.tail.head)

  //除了最後一個元素外的，其他元素，還是list
  println(nums1.init)

  println("==================")
  println("(6)_2_將後列元素從尾部一個個拿掉，列印所有list結果")
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

  println("==================")
  println("(6)_3_drop 和  take  相對===")
  //去掉前n個元素，還是list
  println(nums1 drop 2)

  println(nums1.drop(2))

  println("==================")
  println("(6)_4_drop 和  take  相對===")
  //取得前n個元素，還是list
  println(nums1 take 3)

  println(nums1.take(3))

  println("==================")
  println("(6)_5_將一list分割---從第幾條分割線分割陣列、集合===")
  println(nums1.splitAt(2))


  val nums2 = List(1,2,3,4,5,6)

  val chars = List('1','2','3','4')

  println("==================")
  println("(6)_6_兩個list縫合，元素型態是tuple，整體還是list===")
  println(nums2.zip(chars).getClass)
  println(nums2.zip(chars))

  val ggg = nums2.zip(chars)


  println(ggg(0).getClass)

  println("==================")
  println("(6)_7_list 轉成 String===")
  //toString通常是將原來集合物件println出的東西，轉成String，所以使用上不太好用
  println(nums2.toString)

  //mkString可以將集合裡的元素轉成String，這才是我們要的。
  println(nums2.mkString(";"))

  println("==================")
  println("(6)_8_list可以轉成Array===")
  println(nums2.toArray)

  val fff = nums2.toArray

  println(fff(0))


  println("==================")
  println("(6)_9_兩個list合併")

  //兩個list元素打散結合。
  println(List(1,2,3):::List(4,5,6))

  //List(4,5,6)中的元素與List(1,2,3)結合。
  println(List(1,2,3)::List(4,5,6))



  println("==================")
  println("(7)List衍生物件方法，apply  range  concat。")

  println(List(1,2,3))
  println(List.apply("aa","bb","cc"))

  //until 效果
  println(List.range(2,6))
  //索引值間隔n
  println(List.range(2,6,3))

  println(List.range(6,2,-2))

//  println(List.makes(5,"hey"))

  //多維List集合，用flatten攤平
  val xss = List(List('a','b'),List('c'),List('d','e'))
  println(xss)
  println(xss.flatten)

  //List的相加，元素會自己加進原來的LIst
  val hhh = List.concat(List('a','b'),List('c'))
  println(hhh)
}
