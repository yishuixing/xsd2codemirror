package com.what

import scala.xml.XML

import com.what.utils.FileUitls
import org.json4s.jackson.Serialization

case class Person(name: String, address: Address)

case class Address(city: String, state: String)

object Xsd2CodeMirror {
  def main(args: Array[String]): Unit = {
    toJson("data/4.2/descript.xsd")
  }

  def toJson(f: String):String = {
    val xsd = XML.loadFile(f)
    val all = (xsd \ "element").map(e => (e \ "@name", e \ "@type")).map(
      nt => {
        val m = (xsd \ "complexType").filter(c => (c \ "@name").toString == nt._2.toString).map {
          case c =>
            val children = (c \\ "element" \\ "@ref").map(_.toString)
            val attrs = (c \\ "attribute" \\ "@ref").map(_.toString)
            (children, attrs)
        }
        (nt._1.toString(), Map("children" -> m.map(_._1).flatten, "attrs" -> m.map(_._2).flatten.map(a => (a, null)).toMap))
      }
    ).toMap
    val first =  (xsd \ "element" \\ "@name").toList.take(1).map(_.toString())
    val tags = all + ("!top" -> first)
    implicit val formats = org.json4s.DefaultFormats
    val jsonString = Serialization.write(tags)
//    println(Serialization.write(tags))
    FileUitls.writeFile("test.json", jsonString)
    jsonString
  }
}
