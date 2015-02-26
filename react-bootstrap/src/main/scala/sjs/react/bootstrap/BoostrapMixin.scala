package sjs.react.bootstrap

import japgolly.scalajs.react._

/**
 * Created by alberto on 18/02/15.
 */
trait BoostrapMixinProps {

  def bsClass: String
  def bsStyle: String
  def bsSize: String

  def getBsClassSet: Map[String, Boolean] ={
    var classes= Map.empty[String, Boolean]
    if(bsClass.nonEmpty ){
      classes += (bsClass -> true)
      val prefix= bsClass+"-"
      if(bsSize.nonEmpty){
        classes += (prefix+bsSize -> true)
      }
      if(bsStyle.nonEmpty){
        classes += (prefix+bsStyle -> true)
      }
    }
    classes
  }

}

object BootStrapFunctionUtils {
  def createChainedFunction (one:(ReactEvent) => Unit, two:(ReactEvent) => Unit):(ReactEvent) => Unit ={
    if(one==null && two == null) return null
    if(one!=null) return one
    if(two!=null) return two
    val f : (ReactEvent) => Unit = {
      (event) => {
        one(event)
        two(event)
      }
    }
    f
  }

  def createChainedFunction (one:(Any, String, String) => Unit, two:(Any, String, String) => Unit):(Any, String, String) => Unit ={
    if(one==null && two == null) return null
    if(one!=null) return one
    if(two!=null) return two
    val f : (Any, String, String) => Unit = {
      (key,k1,k2) => {
        one(key,k1,k2)
        two(key,k1,k2)
      }
    }
    f
  }


  def joinClasses(className:String, classes:Map[String, Boolean]):String={
    (className+classes.filter(_._2).mkString(" ")).trim
  }
  def joinClasses(className:String, className2:String):String={
    s"$className $className2".trim
  }
}

