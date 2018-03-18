package ch09_pattern_match

object ch09_1_introduction_of_pattern_match extends App {

  println("==============")
  println("(1)模式比對的原理。")

  val (first,second) = (1,2)
  println(first)
  println(second)


  for (i <- 1 to 5 ){

    i match{

      case 1 => println(1)
      case 2 => println(2)
      case 3 => println(3)
        //   case _ 表示比對其他的情況
      case _ => println("其他")
    }
  }
  println("==============")
  println("(2)scala模式比對比java的switch還強大的地方在於，case 可以加入運算式")

  for(j <- 1 to 6){

    j match{

      case 1 => println(1)
      case x if (x % 2 == 0) => println(s"$x 能夠被2整除")
      case _ =>
      //其他情況，不進行操作
    }
  }

  println("==============")
  println("(3)scala模式比對除了可以在一般程式中使用外，還可以作為函數回傳值。")

  def patternMatching(x:Int) = x match{

    case 5 => "整數5"
    case x if (x%2 == 0) =>"能被2整除的數"
    case _ => "其他整數"

  }

  println(patternMatching(5))
  println(patternMatching(2))
  println(patternMatching(3))

}
