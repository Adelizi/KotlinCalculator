package main.strategies

import main.SaveStrategy
import java.io.File
import java.util.*

class SaveAsText : SaveStrategy {
    override fun save(filename: String, data: Stack<String>) {
        var theString = StringBuilder()
        for (thing in data)
            theString.append(thing)


        File("$filename.txt").printWriter().use { out -> out.println(theString) }
    }

    override val title = "Export Log As Text"
    override val name = "SaveAsText"
//    override fun save(filename: String, data: String){
//

//    }
}