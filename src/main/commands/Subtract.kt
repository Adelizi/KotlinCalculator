package main.commands

import main.Command

class Subtract : Command {
    override val commandType = "Subtract"
    override val value: String = "-"


    override fun execute(itr: MutableListIterator<Any>){


    }
    override fun toString(): String{
        return value
    }
}