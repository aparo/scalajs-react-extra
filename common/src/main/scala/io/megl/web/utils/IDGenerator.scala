package sjs.utils

/* a simple incremental id generator to manage key */
class IDGenerator(val token:String){
  private var count=0
  def getId: String ={
    count +=1
    s"$token-$count"
  }
}
