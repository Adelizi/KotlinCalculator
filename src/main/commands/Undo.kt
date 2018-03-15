package main.commands

import main.Command

class Undo() : Command {
    override val commandType: String = "Undo"
    override val weight: Int = 0

    override val value: String = "Undo"


    override fun execute(){

    }
    override fun undo(){

    }
    override fun toString(): String {
        return value
    }
}