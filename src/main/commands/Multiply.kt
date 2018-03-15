package main.commands;

import main.Command

class Multiply : Command {
    override val commandType = "Multiply"
    override val weight = 2
    override val value: String = "*"

    override fun execute(): Double{
        return 0.0//children?.get(0)!!.execute() * children?.get(1)!!.execute()
    }

    override fun undo(){

    }
    override fun toString(): String{
        return value
    }
}