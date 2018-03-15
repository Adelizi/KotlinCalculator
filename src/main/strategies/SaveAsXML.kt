package main.strategies

import main.SaveStrategy
import java.io.File



class SaveAsXML : SaveStrategy {
    override val name = "SaveAsXML"
    override fun save(filename: String, data: String){
        val outString = "<log>${data}</log>"
        File("$filename.xml").printWriter().use { out ->out.println(outString) }
    }
}