package ch09_pattern_match

object ch09_6_caseclass_and_pattern_match extends App{

  /*
  * 如果將一個類別定義為範例類別後，編譯器會自動幫我們建立其衍生物件，並實現對應的unapply方法，
  * 進一步避免大量手動撰寫程式帶來的複雜性。
  *
  * 模式比對與case class範例類別是一對孿生兄弟。
  *
  * */

  /*
  * 假設類別或特質A有且僅有4個子類別，分別為B1、B2、B3、B4，在進行模式比對時，常常需要列出所有4種子類別待比對的情況，
  * 進一步避免由沒有被處理的情況而帶來的程式出錯。
  * 此時A最好被宣告為sealed trait A、sealed class A。
  *
  * 當模式比對未列出所有子類別要比對的情況時，編譯器會給出警告。
  *
  *
  * */


  println("==============")
  println("(1)sealed trait and sealed class 與模式比對。")


  sealed trait DeployMessage

  case class RegisterWorker(id : String, host: String, port : Int) extends DeployMessage

  case class UnRegisterWorker(id : String, host: String, port : Int) extends DeployMessage

  case class Heartbeat(workerId : String) extends DeployMessage

//  函數的回傳值被拿來模式比對；也是比對參數的一種
  //handleMessage會處理所有可能的情況，即窮列所有DeployMessage的子類別
  def handleMessage(msg:DeployMessage) = msg match{

    case RegisterWorker(id,host,port) => s"The worker $id is registering on $host:$port"

    case UnRegisterWorker(id,host,port) => s"The worker $id is registering on $host:$port"

      //即使註解此行程式仍可以執行，但是編譯器仍會提出警告
      //match may not be exhaustive(窮盡). it would fail ont the following input: Heartbeat(_)
    case Heartbeat(workerId) => s"The worker $workerId is sending heartbeat"
  }


  val msgRegister = RegisterWorker("204799","192.168.1.109",8079)

  val msgUnRegister = UnRegisterWorker("204799","192.168.1.109",8079)

  val msgHeartbeat = Heartbeat("204799")

  println(handleMessage(msgRegister))
  println(handleMessage(msgUnRegister))
  println(handleMessage(msgHeartbeat))




  println("==============")
  println("(2)case class => case object")

  /*
  * 沒有建構子、成員域的case class，編譯器會有警告，case class without a parameter list is deprecated.
  *
  *  因為deprecated，所以建議使用case object
  * */

  case object RequestWorkerState extends DeployMessage

  //窮列所有DeployMessage的子類別。
  def handleMessage_1(msg:DeployMessage) = msg match{

    case RegisterWorker(id,host,port) => s"The worker $id is registering on $host:$port"

    case UnRegisterWorker(id,host,port) => s"The worker $id is registering on $host:$port"

    case Heartbeat(workerId) => s"The worker $workerId is sending heartbeat"

    case RequestWorkerState => "Request Worker State"
  }

  println(handleMessage_1(msgRegister))
  println(handleMessage_1(RequestWorkerState))


  /*
  * 使用上case class and case object 的差異在：
  *
  * （）在模式比對時，case class需要建立物件，case object可以直接使用。
  *
  * （）case class類別會產生兩個位元處碼檔案，而case objecy只會有一組。
  *
  * （）case class產生衍生物鍵會自動實現apply and unapply方法，而case object則不會！
  *
  *
  * 所以，case object可以提昇程式的執行速度。～
  * */



  println("==============")
  println("()")

  println("==============")
  println("()")

}
