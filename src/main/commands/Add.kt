package main.commands

import main.Command

class Add : Command {


        override fun execute(itr: MutableListIterator<Any>) {
//                itr.
                val me =
                        itr.remove()
                itr.set(" + ")
        }

        override val commandType = "Add"
        override val value: String = "+"
//        override val children = ArrayList<Any>()
}