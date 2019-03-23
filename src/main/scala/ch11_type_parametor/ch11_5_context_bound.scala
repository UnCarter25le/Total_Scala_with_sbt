package ch11_type_parametor

/*
* type variable bound <: 代表的是  is a 的關係
* view bound（視圖界定） <% 代表是 can be seen as 的關係
* context bound（上下文界定） 代表是 has a 的關係
*
* */





object ch11_5_context_bound extends App {

  class PersonOrdering extends Ordering[Person]{

    override def compare(x:Person, y: Person):Int ={

      if(x.name > y.name)
        1
      else
        -1
    }

  }

  case class Person(val name:String){
    println("正在建構："+name)

  }


  class Pair[T:Ordering](val first:T,val second : T){

    def smaller(implicit ord:Ordering[T])={
      if(ord.compare(first, second) > 0)
        first
      else
        second
    }
  }


  implicit val p1 = new PersonOrdering

  val p = new Pair(Person("123"),Person("456"))

  println(p.smaller)


}
