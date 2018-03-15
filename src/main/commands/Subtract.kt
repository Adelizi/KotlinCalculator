package main.commands;

import main.Command

class Subtract() : Command {
    override val commandType = "Subtract"
    override val weight = 1
    override val value: String = "-"


    override fun execute(){


    }
    override fun undo() {

    }
    override fun toString(): String{
        return value
    }
}