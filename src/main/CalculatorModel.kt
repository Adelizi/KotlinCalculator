package main

import main.CalcState
import main.Command
import main.SaveStrategy

object CalcModel{
    var listOfAvailibleStates = ArrayList<CalcState>()
    var history = List<String>(0) { "" }
    var listOfCommands = ArrayList<Command>()

    var listOfValues = ArrayList<String>()//
    var currentDisplay = ""
    var listOfStrategies = ArrayList<SaveStrategy>()

    var commandStack = ArrayList<Command>()
    var log = ArrayList<Command>()
    var curState = "Decimal"
    init {
        listOfValues.add("7")
        listOfValues.add("8")
        listOfValues.add("9")
        listOfValues.add("0")

        listOfValues.add("4")
        listOfValues.add("5")
        listOfValues.add("6")
        listOfValues.add("0")

        listOfValues.add("1")
        listOfValues.add("2")
        listOfValues.add("3")
        listOfValues.add("0")

        listOfValues.add("0")

        listOfValues.add("6")
        listOfValues.add("6")
        listOfValues.add("6")

    }

}