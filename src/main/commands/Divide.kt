package main.commands;

import main.Command

class Divide(binaryChildren: List<Command>) : Command {
    override val commandType = "Divide"
    override val weight = 2
    override val value: String = "/"
    //override val children: List<Command>? = binaryChildren;

    override fun execute(): Double{
        return 0.0//children?.get(0)!!.execute() / children?.get(1)!!.execute()
    }
    override fun undo(){

    }
    override fun toString(): String{
        return value
    }
}