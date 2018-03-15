package main.commands

import main.Command

class Multiply : Command {
    override val commandType = "Multiply"
    override val weight = 2
    override val value: String = "*"

    override fun execute(){

    }

    override fun toString(): String{
        return value
    }
}