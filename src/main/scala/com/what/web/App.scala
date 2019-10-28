package com.what.web

import com.what.Xsd2CodeMirror

object App extends cask.MainRoutes {
  val workdir = System.getProperty("workdir")
  val port_arg = System.getProperty("port")
  println(workdir)
  var port2 = 8080
  try {
    if (port_arg.toInt > 0) {
      port2 = port_arg.toInt
      println("run port :"+port2)
    }
  } catch {
    case e: Exception => println("run port :"+port2)
  }
  override val port = port2
  override  val host="0.0.0.0"

  @cask.get("/")
  def index() = {
    "Hello World!"

  }

  //http://localhost:8080/tags/descript
  @cask.get("/tags/:name")
  def tags(name: String ) = {
  var str=""
    if (workdir.length > 0) {
   str=   Xsd2CodeMirror.toJson(s"$workdir/$name.xsd")
    } else {
    str=  Xsd2CodeMirror.toJson(s"data/4.2/$name.xsd")
    }
    cask.Response(str,headers = Seq(("Access-Control-Allow-Origin","*")))
  }

  //  @cask.post("/do-thing")
  //  def doThing(request: cask.Request) = {
  //    new String(request.readAllBytes()).reverse
  //  }
  initialize()
}
