package main.strategies

import main.SaveStrategy
import java.io.File

class SaveAsText : SaveStrategy {
    override val name = "SaveAsText"
    override fun save(filename: String, data: String){

        val outString = data
        File("$filename.txt").printWriter().use { out ->out.println(outString) }
    }
}