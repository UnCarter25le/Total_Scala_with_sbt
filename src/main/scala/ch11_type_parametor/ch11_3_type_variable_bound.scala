package ch11_type_parametor

object ch11_3_type_variable_bound extends App{


  /*
  *
  *
  *
  * */

  println("===============")
  println("(1)用<:進行型態變數界定。")


  //以下的程式編譯不過的原因是，泛型T沒辦法確定型態，所以無法比較，也因為並不是所有類別都存在compareTo方法。
//  class TypeVariableBound{
//    def compare[T](first:T,second:T)={
//      if (first.compareTo(second)>0)
//        first
//      else
//        second
//    }
//  }

  val tvb = new TypeVariableBound
  println(tvb.compare("A","B"))


  //透過type variable bound 對泛型T的類型進行限定，使得T限定為comparable的子類別
  class TypeVariableBound {
    //采用<:進行型態變數界定該語法的意思是泛型T必須是  "實做(<:)"   了Comparable接口的型態
    //類型實做了comparable[T]，參數們就可以比較（compareTo）了
    def compare[T <: Comparable[T]](first: T, second: T) = {
      if (first.compareTo(second) > 0)
        first
      else
        second
    }

  }




  println("===============")
  println("(2)以物件、類型的形式示範型態變數界定。")

//宣告Person類別為case class且實現comparable介面
  case class Person(var name: String, var age:Int) extends Comparable[Person] {
    //參數們可以比較了
    def compareTo(o: Person): Int = {
      if (this.age > o.age) 1
      else if (this.age == o.age) 0
      else -1
    }
  }

  val tvbb = new TypeVariableBound
  println(tvbb.compare(Person("stephen",19),Person("carter",20)))


  println("===============")
  println("(3)<:  上界（upper bound）")

  //定義Student類別為case class，且泛型T的型態變數界定為AnyVal；
  // T <: AnyVal代表泛型T的最頂層類別是AnyVal
  //  <:  上界（upper bound）
  //在建立類別時，所有處於AnyVal類別繼承階層結構的類別都是合法的，如Int、Double相等型態


  case class Student[S,T <: AnyVal](var name: S, var hight : T)

//  val s1 =Student("carter","170") // s1物件中的String類型，不是AnyVal的子類別，所以編譯不過。

  val s2 = Student("john",170)

  val s3 = Student("john", 170L)


  println(s2.hight)
  // >:  下界（upper bound）：  [R >: T] 代表泛型R必須是T類別以上的類別才行。


  println("===============")
  println("()")

  println("===============")
  println("()")


  println("===============")
  println("()")


}
