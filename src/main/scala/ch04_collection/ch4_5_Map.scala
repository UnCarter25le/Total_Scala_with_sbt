package ch04_collection

object ch4_5_Map extends App{

  /*
  * Map也分成immutable.Map[A,B]  ,  mutable.Map[A,B]
  *
  *
  * */


  println("================================")
  println("(1)初始化不可變Map，左邊是key，右邊是value；取value")


  val studentInfo = Map("john" -> 21, "stephen" -> 22, "lucy" -> 20)

  println(studentInfo)

  //get value
  println(studentInfo.get("john"))


  //Map相加
  println(studentInfo ++ Map("carter" -> "yang"))

  println("================================")
  println("(2)初始化可變Map，左邊是key，右邊是value；取value")
  val studentInfoMutable = scala.collection.mutable.Map("john" -> 21, "stephen" -> 22, "lucy" -> 20)

  //另一種初始化方法。
  val xMap1 = scala.collection.mutable.Map(("spark",1),("hive",2))

  println(xMap1)

  //因為可變，所以可以呼叫clear
  println(studentInfoMutable.clear())

  println(studentInfoMutable)

  println("================================")
  println("(3)檢查Map")

  val studentInfoMutable1 = scala.collection.mutable.Map("john" -> 21, "stephen" -> 22, "lucy" -> 20)

  for (i <- studentInfoMutable1) println(i)

  //tuple
  for (i <- studentInfoMutable1) println(i.getClass)

  //將每組key value都進行迭代，再搭配匿名函式，將元素取出。
  studentInfoMutable1.foreach(e => {val (k,v)=e; println(k+":"+v)})

  //另一種迭代每組key-value的方式
  studentInfoMutable1.foreach(e => println(e._1+":"+e._2))


  println("================================")
  println("(4)定義空hashMap；放key-value進去")

  val xMap = new scala.collection.mutable.HashMap[String,Int]()

  xMap.put("spark",1)

  println(xMap)

  println("================================")
  println("(5)判斷key是否含有字串")

  println(xMap.contains("spark"))

  println(xMap.contains("carter"))






}
