package main

interface Command {
    val commandType: String
    val weight: Int // order Of Pres
    val value: String // number for
//    val children: List<Command>?//question  mark means could be null, if noth there then there is a compilation error
    fun execute()
    fun undo()
}
//class NumberEntry(number: Int) : main.Command {
//    override val commandType: String = "num"
//    override val weight: Int = 0
//    override val value: Int = number
//    override val children: List<main.Command>? = null
//
//    override fun execute(): Int{
//        return this.value
//    }
//    fun undo(): Any{
//
//    }
//    override fun toString(): String {
//        return value.toString()
//    }
//}

//class Multiply(binaryChildren: List<Command>) : Command {
//    override val commandType = "*"
//    override val weight = 2
//    override val value: String = "*"
//    override val children: List<Command>? = binaryChildren;
//
//    override fun execute(): Double{
//        return children?.get(0)?.execute() * children?.get(1)?.execute()
//    }
//
//    override fun undo(): Any {
//
//    }
//    override fun toString(): String{
//        return value
//    }
//}

//class Divide(binaryChildren: List<Command>) : Command {
//    override val commandType = "/"
//    override val weight = 2
//    override val value: String = "/"
//    override val children: List<Command>? = binaryChildren;
//
//    override fun execute(): Double{
//        return children?.get(0)?.execute() / children?.get(1)?.execute()
//    }
//    override fun undo(): Any {
//
//    }
//    override fun toString(): String{
//        return value
//    }
//}

//class Add(binaryChildren: List<Command>) : Command {
//    override val commandType = "+"
//    override val weight = 1
//    override val value: String = "+"
//    override val children: List<Command>? = binaryChildren;
//
//    override fun execute(): Double{
//        return children?.get(0)?.execute() + children?.get(1)?.execute()
//    }
//    override fun undo(): Any {
//
//    }
//    override fun toString(): String{
//        return value
//    }
//}

//class Subtract(binaryChildren: List<Command>) : Command {
//    override val commandType = "-"
//    override val weight = 1
//    override val value: String = "-"
//    override val children: List<Command>? = binaryChildren;
//
//    override fun execute(): Double{
//        return children?.get(0)?.execute() - children?.get(1)?.execute()
//    }
//    override fun undo(): Any {
//
//    }
//    override fun toString(): String{
//        return value
//    }
//}

//class Undo() : Command {
//    override val commandType: String = "num"
//    override val weight: Int = 0
//
//    override val value: Any = null
//    override val children: List<Command>? = null
//
//    override fun execute(): Int{
//        return this.value
//    }
//    override fun undo(): Any {
//
//    }
//    override fun toString(): String {
//        return value.toString()
//    }
//}