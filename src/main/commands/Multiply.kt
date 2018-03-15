package main.commands

import main.Command

class Multiply : Command {
    override val commandType = "Multiply"
    override val value: String = "*"

    override fun execute(itr: MutableListIterator<Any>){

    }

    override fun toString(): String{
        return value
    }
}