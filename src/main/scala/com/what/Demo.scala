package com.what

object Demo {
  def main(args: Array[String]): Unit = {
    val a=List("a","b","c")
    val b=a.map{
      case t=>t.map{
        case t1=>(t,null)
      }
        (t,null)
    }.toMap
    val b1=a.map((_,null)).toSet
    println(b)
    println(b.getClass)
    println(b1)
    println(b1.getClass)
    val c=a.map((_,1)).toMap
    println(c)
    println(c.getClass)
  }
}
