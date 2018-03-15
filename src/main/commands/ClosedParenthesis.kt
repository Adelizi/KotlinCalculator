package main.commands

import main.Command

class ClosedParenthesis : Command {
    override val commandType: String
        get() = "ClosedParenthesis"
    override val value: String
        get() = ")"

    override fun execute(itr: MutableListIterator<Any>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}