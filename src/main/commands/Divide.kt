package main.commands;

import main.Command

class Divide() : Command {
    override val commandType = "Divide"
    override val weight = 2
    override val value: String = "/"


    override fun execute(){

    }
    override fun undo(){

    }
    override fun toString(): String{
        return value
    }
}