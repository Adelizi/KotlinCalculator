package main.commands

import main.Command

class Add : Command {


        override fun execute() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override val commandType = "Add"
        override val weight = 1
        override val value: String = "+"
//        override val children = ArrayList<Any>()
}