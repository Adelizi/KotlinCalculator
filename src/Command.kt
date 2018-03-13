import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget

interface Command {
    val commandType: String
    val weight: Int
    val value: Any
    val children: List<Command>?//question  mark means could be null, if noth there then there is a compilation error
    fun execute(): Any
    override fun toString(): String
}
class NumberEntry(number: Int) : Command {
    override val commandType: String = "num"
    override val weight: Int = 0
    override val value: Int = number
    override val children: List<Command>? = null

    override fun execute(): Int{
        return this.value
    }

    override fun toString(): String {
        return value.toString()
    }
}

class Multiply(binaryChildren: List<Command>) : Command {
    override val commandType = "*"
    override val weight = 2
    override val value: String = "*"
    override val children: List<Command>? = binaryChildren;

    override fun execute(): Double{
        return children?.get(0)?.execute() * children?.get(1)?.execute()
    }
    override fun toString(): String{
        return value
    }
}
class Divide(binaryChildren: List<Command>) : Command {
    override val commandType = "/"
    override val weight = 2
    override val value: String = "/"
    override val children: List<Command>? = binaryChildren;

    override fun execute(): Double{
        return children?.get(0)?.execute() / children?.get(1)?.execute()
    }
    override fun toString(): String{
        return value
    }
}
class Add(binaryChildren: List<Command>) : Command {
    override val commandType = "+"
    override val weight = 1
    override val value: String = "+"
    override val children: List<Command>? = binaryChildren;

    override fun execute(): Double{
        return children?.get(0)?.execute() + children?.get(1)?.execute()
    }
    override fun toString(): String{
        return value
    }
}

class Subtract(binaryChildren: List<Command>) : Command {
    override val commandType = "-"
    override val weight = 1
    override val value: String = "-"
    override val children: List<Command>? = binaryChildren;

    override fun execute(): Double{
        return children?.get(0)?.execute() - children?.get(1)?.execute()
    }
    override fun toString(): String{
        return value
    }
}

