package main

import main.commands.ClosedParenthesis
import main.commands.OpenParenthesis
import main.states.Decimal
import java.util.*
import kotlin.collections.ArrayList

object CalcModel {
    var listOfAvailibleStates = ArrayList<CalcState>()
    var listOfCommands = ArrayList<Command>()
    var listOfValues = ArrayList<String>()
    var listOfStrategies = ArrayList<SaveStrategy>()
    var MasterLog = ArrayList<Any>()
    var history = Stack<ArrayList<Any>>()
    var stateHistory = Stack<CalcState>()
    var curCommands = Stack<Any>()
    var curValues = ArrayList<String>()
    var curDisplay = StringBuilder()
    var prevState: CalcState = Decimal()

    var curState: CalcState = Decimal()

    init {

    }

    fun solveCurFunction() {
        val historyString = StringBuilder()
        val funArray = ArrayList<Any>()

    }

    fun log(cin: Any) {
        curCommands.push(cin)
        updateDisplay(cin)
    }

    fun updateDisplay(cin: Any) {
        when (cin) {
            is OpenParenthesis -> curDisplay.append("(")
            is ClosedParenthesis -> curDisplay.append(")")
            is Command -> curDisplay.append(" " + cin.value + " ")
            is String -> curDisplay.append(cin)
            else -> curDisplay.append("error!")
        }
    }

    fun recalcDispaly() {
        curDisplay.setLength(0)
        var numBuffer = StringBuilder()
        for (i in curCommands) {
            if (i is Command) {
                updateDisplay(i)
                if (numBuffer.isNotEmpty()) {
                    val temp = prevState.stringToNum(numBuffer.toString())
                    updateDisplay(curState.numToString(temp))
                    numBuffer.setLength(0)
                }
            } else numBuffer.append(i)
        }

        if (numBuffer.isNotEmpty()) {
            val temp = prevState.stringToNum(numBuffer.toString())
            updateDisplay(curState.numToString(temp))
            numBuffer.setLength(0)
        }
    }

    fun stateChange(): Boolean {
        if (prevState == curState)
            return false
        else
            prevState = curState
        return true
    }


}