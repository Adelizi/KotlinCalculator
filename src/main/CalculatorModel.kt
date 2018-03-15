package main
import main.CalcState
import main.Command
import main.SaveStrategy
import java.util.*

object CalcModel{
    var listOfAvailibleStates = ArrayList<CalcState>()
    var listOfCommands = ArrayList<Command>()
    var listOfValues = ArrayList<String>()
    var currentDisplay = ""
    var listOfStrategies = ArrayList<SaveStrategy>()
    var history = Stack<Any>()
    var curFunct = Stack<Any>()

    init {


    }

}