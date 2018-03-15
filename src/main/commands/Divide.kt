package main.commands

import main.Command

class Divide : Command {
    override val commandType = "Divide"
    override val value: String = "/"


    override fun execute(itr: MutableListIterator<Any>){

    }

    override fun toString(): String{
        return value
    }
}