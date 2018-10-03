package ch07_object_oriented_second

object ch07_2_uses_of_trait extends App {

  /*
  * 看過下面trait的使用方法，可以知道scala的trait，跟java中的抽象類別更接近。
  *
  * trait裡面可以有抽象、實際的變數和方法。
  *
  * java裡的interface不允許有抽象成員變數、不允許有實際成員方法。
  *
  *
  * */

  println("==================")
  println("(1)只有抽象方法的trait；變數的型態可以是trait")

  //案例類別，跟單例物件(singleton) object Person有同樣的好處，不需要new就可以建立物件
  case class Person(var id: Int, var name: String, var age: Int)

  trait PersonDAO {

    def add(p: Person)

    def update(p: Person)

    def delete(id: Int)

    def findById(id: Int)

  }

  class PersonDAOImpl extends PersonDAO {
    //加入方法
    override def add(p: Person): Unit = {
      println("Invoking add Method....adding " + p)
    }

    //更新方法
    override def update(p: Person): Unit = {
      println("Invoking update Method,updating " + p)
    }

    //查詢方法
    override def findById(id: Int): Unit = {
      println("Invoking findById Method,id=" + id)
      Person(1, "John", 18)
    }

    //移除方法
    override def delete(id: Int): Unit = {
      println("Invoking delete Method,id=" + id)
    }
  }

  // 變數類型是trait
  val p: PersonDAO = new PersonDAOImpl

  //case class Person具有跟單例物件(singleton) object Person有同樣的好處，不需要new就可以建立物件
  p.add(Person(1, "carter", 18))

  println("==================")
  println("(2)有抽象成員變數和方法的trait")

  //  抽象成員變數設定，最後會產生抽象getter  and  setter方法

  trait PersonDAO_1 {
    //抽象成員變數
    var recordNum: Long

    def add(p: Person)

    def update(p: Person)

    def delete(id: Int)

    def findById(id: Int): Person
  }

  class PersonDAOImpl_1 extends PersonDAO_1 {
    //抽象成員實際化
    override var recordNum: Long = _

    override def add(p: Person): Unit = {
      println("Invoking add Method....adding " + p)
    }

    override def update(p: Person): Unit = {
      println("Invoking update Method,updating " + p)
    }

    override def findById(id: Int): Person = {
      println("Invoking findById Method,id=" + id)
      Person(1, "John", 18)
    }

    override def delete(id: Int): Unit = {
      println("Invoking delete Method,id=" + id)
    }
  }

  val p_1: PersonDAO_1 = new PersonDAOImpl_1
  p_1.add(Person(1, "John", 19))


  println("==================")
  println("(3)有實際成員變數的trait")

  trait PersonDAO_2 {
    //實際成員
    var recordNum: Long = _

    def add(p: Person)

    def update(p: Person)

    def delete(id: Int)

    def findById(id: Int): Person
  }

  class PersonDAOImpl_2 extends PersonDAO_2 {

    override def add(p: Person): Unit = {
      println("Invoking add Method....adding " + p)
    }

    override def update(p: Person): Unit = {
      println("Invoking update Method,updating " + p)
    }

    override def findById(id: Int): Person = {
      println("Invoking findById Method,id=" + id)
      Person(1, "John", 18)
    }

    override def delete(id: Int): Unit = {
      println("Invoking delete Method,id=" + id)
    }

  }

  val p_2: PersonDAO_2 = new PersonDAOImpl_2
  p_2.add(Person(1, "John", 20))


  println("==================")
  println("(4)有實際成員方法的trait")

  trait PersonDAO_3 {

    var recordNum: Long = _

    //實際方法
    def add(p: Person): Unit = {
      println("Invoking add Method....adding " + p)
    }

    def update(p: Person)

    def delete(id: Int)

    def findById(id: Int): Person
  }

  class PersonDAOImpl_3 extends PersonDAO_3 {

    override def update(p: Person): Unit = {
      println("Invoking update Method,updating " + p)
    }

    override def findById(id: Int): Person = {
      println("Invoking findById Method,id=" + id)
      Person(1, "John", 18)
    }

    override def delete(id: Int): Unit = {
      println("Invoking delete Method,id=" + id)
    }

  }

  val p_3: PersonDAO_3 = new PersonDAOImpl_3
  p_3.add(Person(1, "John", 21))


  println("==================")
  println("(5)混入trait類別物件創建；以trait建立的物件，也跟抽象類別建立的物件一樣，也稱作匿名類別物件。")
  /*
*
* 如果混入的trait有父類trait，他會按照繼承層次，先呼叫父類trait的建構函數。
* 有多個父trait，則按照從左至又順序執行。
*
*
* */


  import java.io.PrintWriter

  trait Logger {
    println("Logger")

    def log(msg: String): Unit
  }

  trait FileLogger extends Logger {
    println("FileLogger")

    //建立寫出物件，檔名是file.log
    val fileOutput = new PrintWriter("file.log")
    //寫進檔案內容：
    fileOutput.println("#")

    def log(msg: String): Unit = {
      //寫進檔案內容，並且關閉檔案接口。
      fileOutput.print(msg)
      fileOutput.flush()
    }
  }

  //以trait FileLogger建立物件，呼叫log方法。
  new FileLogger {}.log("trait")


  println("==================")
  println("(6)混入多個trait類別物件創建")

  /*
  *
  * * 如果混入的trait有父類trait，他會按照繼承層次，先呼叫父類trait的建構函數。
* 有多個父trait，則按照從左至又順序執行。
* 執行完所有父類trait後，才會執行本體。
  *
  * */


  trait Logger_1 {
    println("Logger")
  }

  trait FileLogger_1 extends Logger_1 {
    println("FileLogger")
  }

  trait Closable_1 {
    println("Closable")
  }

  class Person_1 {
    println("Constructing Person_1...")
  }

  class Student_1 extends Person_1 with FileLogger_1 with Closable_1 {
    println("Constructing Student_1")
  }

  new Student_1

  println("==================")
  println("(7)提前定義與懶載入")

/*
*
* 為避免建立的物件，呼叫到的程序是沒有被實際定義的，因此有提前定義、或者懶載入解決方法。
*
* */


//  ===================================提前定義：
  import java.io.PrintWriter

  trait Logger_2 {
    def log(msg: String): Unit
  }

  trait FileLogger_2 extends Logger_2 {
    //增加了抽象成員變數
    val fileName: String
    //將抽象成員變數作為PrintWriter參數
    val fileOutput = new PrintWriter(fileName: String)
    fileOutput.println("#")

    def log(msg: String): Unit = {
      fileOutput.print(msg)
      fileOutput.flush()
    }
  }

  class Person_2

  class Student_2 extends Person_2 with FileLogger_2 {

    override val fileName: String = "file.log"

  }

  /*
  * 下面會出錯的原因是因為，Student_2物件建立，會執行Person敘述，再來Logger敘述，然後
  * 在執行FileLogger敘述遇到fileName沒有被定義，就會報錯。
  *
  * */
  //  new Student_2().log("trait demo")

  val s = new {
    //提前定義
    override val fileName = "file.log"
  } with Student_2
  s.log("predifined variable ")


//  ======================================懶載入(建議使用)：

  /*
  * 懶載入的程式碼與提前定義的相差無幾，關鍵在於lazy的使用，用上這關鍵字，使得物件建立時(val ss = new Student_3)
  * ，不會執行沒有明確敘述的fileName；
  * 反而在執行ss.log( )時，才會去找fileOutput使用的fileName的值是什麼，因為ss物件是用Student_3建立的，所以fileName就是file.log
  *
  * */

  trait Logger_3 {
    def log(msg: String): Unit
  }

  trait FileLogger_3 extends Logger_3 {

    //成員變數依然為抽象。
    val fileName: String
    //成員變數定義為lazy
    lazy val fileOutput = new PrintWriter(fileName: String)


    def log(msg: String): Unit = {
      fileOutput.print(msg)
      fileOutput.flush()
    }
  }

    class Person_3

    class Student_3 extends Person_3 with FileLogger_3 {
      override val fileName = "file.log"
    }

    val ss = new Student_3
    ss.log("#")
    ss.log("lazy demo")




}
