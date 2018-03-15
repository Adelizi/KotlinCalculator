package main

import main.Controls.BackSpace
import main.Controls.Enter
import main.commands.OpenParenthesis
import main.factories.CommandFactory
import main.factories.SaveStrategyFactory
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import main.factories.StateFactory

object CalcController : ActionListener {

    val view: CalcView
    val model = CalcModel

    init {
        model.listOfAvailibleStates = StateFactory.getCalcStateList()!!
        model.listOfCommands = CommandFactory.getCommandList()!!
        model.listOfStrategies = SaveStrategyFactory.getSaveStrategyList()!!
        model.listOfValues = model.curState.values as ArrayList<String>
        view = CalcView
    }

    override fun actionPerformed(e: ActionEvent?) {
    }

    fun handleCommand(e: ActionEvent?) {
        val command = CommandFactory.createCommand(e!!.actionCommand)
        if (paramaterizeInput(command)) {
            model.log(command)
            view.renderWindow()

        }
    }

    fun handleValue(e: ActionEvent?) {
        if (paramaterizeInput(e!!.actionCommand)) {
            model.log(e.actionCommand)
            view.resultWindow.text = view.resultWindow.text + e.actionCommand


        }
    }

    fun handleStateChange(e: ActionEvent?) {

        model.prevState = model.curState
        model.curState = StateFactory.createCalcState(e!!.actionCommand)
        if (model.prevState.name == model.curState.name) {
            return
        }
        model.MasterLog.add("State Change to " + e.actionCommand)
        model.listOfValues = model.curState.values as ArrayList<String>
        view.renderValues()
        model.recalcCommandStack()
        view.renderWindow()
    }

    fun handleSaveStratagy(e: ActionEvent?) {
        val strat = SaveStrategyFactory.createSaveStrategy(e!!.actionCommand)
//        strat.save("CalculatorLog", model.history)
        TODO("needs model to be finalized")
    }

    fun handleEnter(e: ActionEvent) {
        if (paramaterizeInput(model.MasterLog.last())) {
            model.MasterLog.add(Enter())
            model.solveCurFunction()
        }

    }

    fun handleBackSpace(e: ActionEvent) {
        if(paramaterizeInput(BackSpace())) {
            model.MasterLog.add(BackSpace())
            val len = model.curCommands.size
            model.curCommands.removeAt(len - 1)
            model.recalcCommandStack()
            view.renderWindow()
        }
    }

    fun handleUndo(e: ActionEvent) {
        TODO("make undo do stuff")
    }

    fun paramaterizeInput(input: Any): Boolean {
        var end = ' '
        if (model.curCommands.isNotEmpty())
            end = view.resultWindow.text.last()
        return when (input) {
            is BackSpace -> model.curCommands.size > 0
            '.' -> end != ' ' && end != ')' && end != '('
            is Enter -> false
            is OpenParenthesis -> end == ' '
            is String -> end != ')'
            is Command -> end != ' ' && end != '('
            else -> {
                true
            }
        }
    }
}
