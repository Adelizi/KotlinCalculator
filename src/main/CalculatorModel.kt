package main
import main.CalcState
import main.Command
import main.SaveStrategy
import java.util.*

object CalcModel{
    var listOfAvailibleStates = ArrayList<CalcState>()
    var listOfCommands = ArrayList<Command>()
    var listOfValues = ArrayList<String>()
    var listOfStrategies = ArrayList<SaveStrategy>()
    var history = Stack<String>()
    var curCommands = Stack<Command>()
    var curValues = Stack<Int>()
    val curStringVal = Stack<String>()

    init {


    }

    fun solveCurFunction() {
        //do stuff
    }

}