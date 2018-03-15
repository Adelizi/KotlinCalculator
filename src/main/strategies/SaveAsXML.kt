package main.strategies

import main.SaveStrategy
import java.io.File
import java.util.*


class SaveAsXML : SaveStrategy {

    override fun save(filename: String, data: Stack<String>) {
        val outString = "<log>${data}</log>"
        File("$filename.xml").printWriter().use { out ->out.println(outString) }
    }

    override val title = "Export Log As XML"
    override val name = "SaveAsXML"

}
