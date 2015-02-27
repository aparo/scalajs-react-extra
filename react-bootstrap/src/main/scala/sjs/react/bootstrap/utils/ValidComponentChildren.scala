package sjs.react.bootstrap.utils

import japgolly.scalajs.react._

import scala.scalajs.js
import scala.scalajs.js.Any

/**
 * Created by alberto on 24/02/15.
 */
object ValidComponentChildren {
  /**
   * Maps children that are typically specified as `props.children`,
   * but only iterates over children that are "valid components".
   *
   * The mapFunction provided index will be normalised to the components mapped,
   * so an invalid component would not increase the index.
   *
   * @param {?*} children Children tree container.
   * @param {function(*, int)} mapFunction.
   * @param {*} mapContext Context for mapFunction.
   * @return {object} Object containing the ordered map of results.
   */
//  def map(children:PropsChildren, func: (ReactNode,Int) => ReactElement) = {
//    var index = 0
//    val f : js.Function1[ReactNode, Any]={
//      (child:ReactNode) =>
//        if (React.isValidElement(child)) {
//          var lastIndex = index
//          index += 1
//          func(child, lastIndex).asInstanceOf[Any]
//        }else {
//          child.asInstanceOf[Any]
//        }
//    }
//
//    React.Children.map(children, f)
//  }

  def map(children:PropsChildren, func: (ReactNode,Int) => ReactElement):js.Array[ReactNode] = {
    var index = 0
    val f : js.Function1[ReactNode, Any]={
      (child:ReactNode) =>
        if (React.isValidElement(child)) {
          var lastIndex = index
          index += 1
          func(child, lastIndex).asInstanceOf[Any]
        }else {
          child.asInstanceOf[Any]
        }
    }
    if(children==null)
      return js.Array()

    val result=React.Children.map(children, f)
//    if(result.isDefined)
//      return Nil
//    result.get.asInstanceOf[Seq[ReactNode]]
    val r = result.asInstanceOf[js.Array[ReactNode]]
    println(s"map $r")
    r
  }

  /**
   * Determine if the Child container has one or more "valid components".
   *
   * @param {?*} children Children tree container.
   * @returns {boolean}
   */
  def hasValidComponent(children:PropsChildren):Boolean= {
    var hasValid = false

    val f : js.Function1[ReactNode, Any]={
      (child:ReactNode) =>
        if (!hasValid && React.isValidElement(child)) {
          hasValid = true
        }
        "".asInstanceOf[js.Any]
    }

    React.Children.forEach(children, f)

    hasValid
  }
  /*

/**
 * Maps children that are typically specified as `props.children`,
 * but only iterates over children that are "valid components".
 *
 * The mapFunction provided index will be normalised to the components mapped,
 * so an invalid component would not increase the index.
 *
 * @param {?*} children Children tree container.
 * @param {function(*, int)} mapFunction.
 * @param {*} mapContext Context for mapFunction.
 * @return {object} Object containing the ordered map of results.
 */
function mapValidComponents(children, func, context) {
  var index = 0;

  return React.Children.map(children, function (child) {
    if (React.isValidElement(child)) {
      var lastIndex = index;
      index++;
      return func.call(context, child, lastIndex);
    }

    return child;
  });
}

/**
 * Iterates through children that are typically specified as `props.children`,
 * but only iterates over children that are "valid components".
 *
 * The provided forEachFunc(child, index) will be called for each
 * leaf child with the index reflecting the position relative to "valid components".
 *
 * @param {?*} children Children tree container.
 * @param {function(*, int)} forEachFunc.
 * @param {*} forEachContext Context for forEachContext.
 */
function forEachValidComponents(children, func, context) {
  var index = 0;

  return React.Children.forEach(children, function (child) {
    if (React.isValidElement(child)) {
      func.call(context, child, index);
      index++;
    }
  });
}

/**
 * Count the number of "valid components" in the Children container.
 *
 * @param {?*} children Children tree container.
 * @returns {number}
 */
function numberOfValidComponents(children) {
  var count = 0;

  React.Children.forEach(children, function (child) {
    if (React.isValidElement(child)) { count++; }
  });

  return count;
}



module.exports = {
  map: mapValidComponents,
  forEach: forEachValidComponents,
  numberOf: numberOfValidComponents,
  hasValidComponent: hasValidComponent
};*
  * */
}
