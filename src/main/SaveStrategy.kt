package main

import java.io.File

interface SaveStrategy {
    fun save(filename: String, data: String)
}
class SaveAsText : SaveStrategy {
    override fun save(filename: String, data: String){

        val outString = data
        File("$filename.txt").printWriter().use { out ->out.println(outString) }
    }
}
class SaveAsXML : SaveStrategy {
    override fun save(filename: String, data: String){
        val outString = "<log>${data}</log>"
        File("$filename.xml").printWriter().use { out ->out.println(outString) }
    }
}