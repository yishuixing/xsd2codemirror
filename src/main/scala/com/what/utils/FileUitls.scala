package com.what.utils

import java.io.{BufferedWriter, File, FileWriter}

object FileUitls {
  def writeFile(filename: String, s: String): Unit = {
    val file = new File(filename)
    val bw = new BufferedWriter(new FileWriter(file))
    bw.write(s)
    bw.close()
  }

}
