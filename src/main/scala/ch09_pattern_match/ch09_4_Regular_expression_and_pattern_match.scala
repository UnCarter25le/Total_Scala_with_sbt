package ch09_pattern_match

import java.util.regex.Matcher


object ch09_4_Regular_expression_and_pattern_match extends App {

  println("==============")
  println("(1)借用java正則表達式運用在scala。")

  /*
  *
  * 現代程式語言都支持Regular expression！
  *
  * 比對的步驟：
  * 建立規則-->建立規則物件-->建立比對物件
  *
  * */

  import java.util.regex.Pattern

  val line = "Hadoop has been the most popular big data " + "processing tool since 2005-11-21"

  //訂立正規表示法規則，用於比對年-月-日這樣的日期格式
  // scala的跳脫符號\\
  //括號不代表任何意義
  val regex = "(\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d)"

  //根據正規表示法規則建立Pattern物件
  val pattern = Pattern.compile(regex)

  //建立Matcher物件
  val m = pattern.matcher(line)
  if (m.find( )) {
    //m.group(0)傳回整個比對結果，即(\d\d\d\d)-(\d\d)-(\d\d)比對結果
    println(m.group(0))

    //m.group(1)傳回第一個分群組比對結果，即(\d\d\d\d)年比對結果
    println(m.group(1))

    //m.group(2)傳回第二個分群組比對結果，即(\d\d)月比對結果
    println(m.group(2))

    //m.group(3)傳回第三個分群組比對結果，即(\d\d)日比對結果
    println(m.group(3))
  } else {
    println("找不到比對項")
  }

  println("==============")
  println("(2)_1_scala本身的正則表達式。")

  import scala.util.matching.Regex

  /*
  * 建立比對規則物件dateP1。
  *
  * 將scala.collection.immutable.StringLike轉變為scala.util.matching.Regex
  * */
  val dateP1 = """(\d\d\d\d)-(\d\d)-(\d\d)""".r


  println("==============")
  println("(2)_2_直接引用scala.util.matching.Regex")

  val dateP2 = new scala.util.matching.Regex("""(\d\d\d\d)-(\d\d)-(\d\d)""")

  println("==============")
  println("(3)_1_scala的正規表達應用方法: def findAllIn(source: CharSequence):MatchIterator。")

  //  findAllIn:比對該字串中，所有與輸入模式相符合的字元。
  //  scala正規法比對到的內容，可以在迭代對應到字定義變數（需要對應自定義的正規物件規則）。

  val regexx =  """(\d\d\d\d)-(\d\d)-(\d\d)""".r

  for (date <- regexx findAllIn "2015-12-312016-02-20"){
    //規則               //被比對的字串
    println(date)
  }
  //迭代對應到自定義變數year,month,dat
  for (regexx(year,month,day) <- regexx.findAllIn( "2015-12-312016-02-20")){

    println(s"haha,$year,$month,$day")
  }


  println("==============")
  println("(3)_2_scala的正規表達應用方法: def findAllMatchIn(source: CharSequence):Iterator[Match]")

  //以iterator[Match]形式，傳回符合的分組數

  for(date <- regexx findAllMatchIn "2015-12-312016-02-20"){
    //跟規則比對中的分組數有幾個
    println(date.groupCount)
    //比對中的第幾的分組數
    println(date.group(0))
    println(date.group(1))
    println(date.group(2))
    println(date.group(3))

  }


  println("==============")
  println("(3)_3_scala的正規表達應用方法: def findFirstIn(source: CharSequence):Option[String]")

  /*
  * 模式比對結合正則表達式，將正則比對的結果，送進模式比對
  *
  * */


  //  傳回比對成功的第一個字串，成功回傳Option[String]，失敗回傳none

  val copyright : String = regexx findFirstIn "Date of this docuent: 2011-07-15  ; 2018-03-18" match{
    //雖然兩個日期都可以比對到，但是只取第一個
    case Some(date) => "Copyright "+date

    case None  => "No Copyright"
  }

  println(copyright)


  println("==============")
  println("(3)_4_scala的正規表達應用方法: def findFirstMatchIn(source: CharSequence):Option[Match]")

  /*
  * 傳回比對成功的每一個字串，以Match物件形式傳回，比對成功傳回Option[Match]，失敗則為None
  *
  * 與findFirstIn的區別在於， findFirstMatchIn可以取得更多關於符合的資訊，如分組數、比對字串的索引等資訊。
  *
  * */


  val dateP3 =new scala.util.matching.Regex("""(\d\d\d\d)-(\d\d)-(\d\d)""","year","month","day")
  //scala特殊表達方法，可以直接定義每個正則表示的String
  val result = dateP3 findFirstMatchIn "2015-12-312016-02-20" match{

    //m.group方法可以傳回對應比對分組的值。
    //Some()  表示正規有比對到，裡面的值暫時定義成m，在用匿名函式表達完整的m
    case Some(m) => "year對應分組的值為：" +m.group("year")

    case None =>
  }
  println(result)


  println("==============")
  println("(3)_5_scala的正規表達應用方法: def replaceAllIn(target: CharSequence,replacer:(Match) String):String")

  /*
  * 使用replacer函數對所有模式比對成功的字串進行取代。
  *
  * replacer的輸導入參數為Match，傳回值形態為String
  *
  *
  * */

  val datePattern = new Regex("""(\d\d\d\d)-(\d\d)-(\d\d)""","year","month","day")

  //  待取代的字串
  val text = "From 2011-07-15 to 2011-07-17"

  //如果在text中比對到datePattern的規則，就改成 m 。
  //  比對到的字串，可以就其元素就地改變。
  val repl = datePattern replaceAllIn(text,m => m.group("month")+ "/" +m.group("day"))

  println(repl)


  //  def replaceAllIn(target: CharSequence,replacement:String): String
  //比對到的話，就用replacement去取代
  val repll = datePattern replaceAllIn(text,"yeap")

  println(repll)


  println("==============")
  println("(4)正規表示法在模式比對中的應用。")

  println("(4)_1_findAllIn。")

  /*
  * 分析模式的分組值
  *
  * */

  val dateRegx = """(\d\d\d\d)-(\d\d)-(\d\d)""".r

  val textt = "2015-12-312016-02-20"

  for (date <- dateRegx.findAllIn(textt)){
    date match{
      case dateRegx(year,month,day) => println(s"match敘述中的模式比對：year=$year,month=$month,day=$day")
      case _ =>
    }
  }

  //  這個程式等同上面
  for (dateRegx(year,month,day) <- dateRegx.findAllIn(textt)){
    println(s"for循環中的正規表示法模式比對：year=$year,month=$month,day=$day")
  }




  println("==============")
  println("(4)_2_findFirstMatchIn。")

  val dateRegxxx =  """(\d\d\d\d)-(\d\d)-(\d\d)""".r

  val texttt=  "2015-12-312016-02-20"

  //findFirstMatchIn 傳回值型態為Option[Match]
  dateRegxxx.findFirstMatchIn(texttt) match{
    case Some(dateRegxxx(year,month,day)) => println(s"findFirstMatchIn 與 模式比對：year=$year,month=$month,day=$day")

    case None => println("沒有找到比對")
  }
  //findFirstIn 傳回值型態為Option[String]
  dateRegxxx.findFirstIn(texttt) match{
    case Some(dateRegxxx(year,month,day)) => println(s"findFirstIn 與 模式比對：year=$year,month=$month,day=$day")
    case None => println("沒有找到比對")
  }

  /*
  *   findFirstMatchIn and findFirstIn 回傳型態不一樣，但是模式比對結果確一樣
  *   事實上，正規表示法模式比對與序列模式的模式比對作用原理類似，正規表示法夜是透過unapplySeq作用的，可以將正規表示法物件進行解構。
  *
  *
  * */
  import scala.util.matching.Regex.Match

  def runMatcher(m: Matcher) = ???

  def unapplySeq(target:Any) :Option[List[String]] = target match{

    case s: CharSequence =>
      val m = pattern matcher s
      if (runMatcher(m)) Some((1 to m.groupCount).toList map m.group)
      else None
    case m: Match => unapplySeq(m.matched)
    case _ => None

  }

}
