package main.factories

import main.Command
import main.commands.*
import java.io.File

class CommandFactory {
    companion object {
        fun createCommand(commandType: String): Command {
            val kClass = Class.forName("main.commands.$commandType")

            return kClass.newInstance() as Command
        }
        fun listCommandNames(): ArrayList<String>?{

            var names: ArrayList<String> = ArrayList()
            for(name in File("../KotlinCalculator/src/main/commands").list()){
                names.add(name.toString())
            }
            return names
        }
        fun getCommandList(): ArrayList<Command>?{
            var commands: ArrayList<Command> = ArrayList()
            for (name in this.listCommandNames()!!){

                commands.add(createCommand(name.split(".")[0]))
            }
            return commands
        }
    }
}