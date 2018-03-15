package main

import main.commands.ClosedParenthesis
import main.commands.OpenParenthesis
import main.states.Decimal
import java.util.*
import kotlin.collections.ArrayList

object CalcModel {
    var listOfAvailibleStates: ArrayList<CalcState>
    var listOfCommands: ArrayList<Command>
    var listOfValues: ArrayList<String>
    var listOfStrategies: ArrayList<SaveStrategy>
    var MasterLog: ArrayList<Any>
    var history: Stack<Array<Any>>
    var stateHistory: Stack<CalcState>
    var curCommands: ArrayList<Any>
    var curDisplay: StringBuilder
    var prevState: CalcState
    var adapter: MathAdapter

    var curState: CalcState

    init {
        listOfAvailibleStates = ArrayList<CalcState>()
        listOfCommands = ArrayList<Command>()
        listOfValues = ArrayList<String>()
        listOfStrategies = ArrayList<SaveStrategy>()
        MasterLog = ArrayList<Any>()
        history = Stack<Array<Any>>()
        stateHistory = Stack<CalcState>()
        curCommands = ArrayList<Any>()
        adapter = MathAdapter()
        curDisplay = StringBuilder()
        prevState = Decimal()
        curState = Decimal()

    }

    fun solveCurFunction() {
        stateHistory.push(curState)
        history.push(curCommands.toArray())
        for(i in curCommands.indices){
            if(curCommands[i] is Command){
                var cur = curCommands[i] as Command
                cur.execute(curCommands.listIterator())
            }
        }
        for (i in curCommands){
            print(i)
        }
        println()
//        val answer = adapter.solve(curCommands.toArray())
    }

    fun log(cin: Any) {
        curCommands.add(cin)
        MasterLog.add(cin)
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

    fun recalcCommandStack() {
        curDisplay.setLength(0)
        var numBuffer = StringBuilder()
        val oldCom = curCommands.toArray()
            curCommands.clear()
        for (i in oldCom) {
            if (i is Command) {
                if (numBuffer.isNotEmpty()) {
                    val temp = prevState.stringToNum(numBuffer.toString())
                    log(curState.numToString(temp))
                    numBuffer.setLength(0)
                }
                log(i)
            } else numBuffer.append(i)
        }

        if (numBuffer.isNotEmpty()) {
            val temp = prevState.stringToNum(numBuffer.toString())
            log(curState.numToString(temp))
            numBuffer.setLength(0)
        }
    }


}