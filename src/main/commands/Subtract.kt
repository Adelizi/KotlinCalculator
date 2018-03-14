package main.commands;

import main.Command

class Subtract(binaryChildren: List<Command>) : Command {
    override val commandType = "-"
    override val weight = 1
    override val value: String = "-"
    override val children: List<Command>? = binaryChildren;

    override fun execute(): Double{

        return children?.get(0)!!.execute() - children?.get(1)!!.execute()
    }
    override fun undo() {

    }
    override fun toString(): String{
        return value
    }
}