package ch06_object_oriented_first

object ch06_3_assist_construction extends App{

  println("==================")
  println("(1)輔助(覆載)建構子。")


  /*
  *
  * scala利用this完成輔助建構子的概念
  *
  * */


//  無參數的主建構子函數
  class Person{

  //成員變數
    private var name:String = null
    private var age:Int = 18
    private var sex:Int = 0

  //輔助建構函數
    def this(name:String){

      this() //呼叫無參數的主建構子函數；也就定義name age sex三個變數
      this.name = name  //給訂參數name，就會對private var name作到修改
    }

  def this(name:String,age:Int){

    this(name)//呼叫上面的輔助建構子。

    this.age =age

  }

  def this(name:String,age:Int,sex:Int){

    this(name,age)//呼叫上述的輔助建構子。
    this.sex = sex
  }

  override def toString={
    val sexStr = if(sex==1) "boy" else "girl"
    s"name=$name,age=$age,sex=$sexStr"
  }

}
  //使用具有輔助建構子的類別建立物件，可以直接呼叫類別名並指定參數來使用輔助建構的功能。
  //  程式會視給予的參數，去呼叫對應的建構子。

  //呼叫3個參數的建構子
  println(new Person("carter",19,1))
  //呼叫2個參數的建構子
  println(new Person("carter",19))
  //呼叫1個參數的建構子
  println(new Person("carter"))


  println("==================")
  println("(2)帶預設參數的輔助（覆載）建構子。")


  class Person_1 {

    //成員變數
    private var name: String = null
    private var age: Int = 18
    private var sex: Int = 0


    def this(name:String="",age:Int=18,sex:Int=1){

      this() //因為市地一個覆載建構子，必須要呼叫this()
      this.name=name
      this.age=age
      this.sex=sex
    }

    override def toString={

      val sexStr=if(sex==1)"boy" else "girl"
      s"name=$name,age=$age,sex=$sexStr"

    }


  }

  //雖然只給定一個參數，不過仍會呼叫覆載建構子，相當於叫出Person("carter",18,1)
  //也就是說，當給定建構子參數後，scala會自動搜尋符合的覆載建構子。
  println(new Person_1("carter"))
  //呼叫預設的主建構子函數
  println(new Person_1())




  println("==================")
  println("(3)無參數的主建構子函數為私有。")

  class Person_2 private{
    //成員變數
    private var name: String = null
    private var age: Int = 18
    private var sex: Int = 0 //girl

    def this(name:String="",age:Int=20,sex:Int=1){
      this()
      this.name=name
      this.age=age
      this.sex=sex
    }

    override def toString={
      val sexStr=if(sex==1)"boy" else "girl"
      s"name=$name,age=$age,sex=$sexStr"
    }


  }

  //因為設定主建構函數全部為private，所以不能透過外部建立物件來存取成員變數；無論怎樣物件呼叫，
  //都只會呼叫其中的輔助建構子。
  println(new Person_2("carter"))

  println(new Person_2())

}
