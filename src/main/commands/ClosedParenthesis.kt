package main.commands

import main.Command

class ClosedParenthesis : Command {
    override val commandType: String
        get() = "ClosedParenthesis"
    override val weight: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val value: String
        get() = ")"

    override fun execute() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}