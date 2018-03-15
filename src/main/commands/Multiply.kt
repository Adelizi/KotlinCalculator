package main.commands;

import main.Command

class Multiply() : Command {
    override val commandType = "Multiply"
    override val weight = 2
    override val value: String = "*"
    override val children: List<Command> = list()

    override fun execute(): Double{
        return children?.get(0)!!.execute() * children?.get(1)!!.execute()
    }

    override fun undo(){

    }
    override fun toString(): String{
        return value
    }
}