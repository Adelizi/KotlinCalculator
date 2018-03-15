package main.Controls

import main.Command
import java.util.*
import kotlin.collections.ArrayList

class Undo : Command {
    override val commandType: String = "Undo"

    override val value: String = "Undo"
    var historyIndex  = 0

    fun reset(){historyIndex = 0}


    override fun execute(itr: MutableListIterator<Any>){

    }
    override fun toString(): String {
        return value
    }
}