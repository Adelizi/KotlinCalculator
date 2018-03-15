package main

import main.factories.CommandFactory
import main.factories.SaveStrategyFactory
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import main.factories.StateFactory
import main.states.Decimal

object CalcController : ActionListener {

    val view : CalcView
    val model = CalcModel
    var curState : CalcState = Decimal()

    init{
        model.listOfAvailibleStates = StateFactory.getCalcStateList()!!
        model.listOfCommands = CommandFactory.getCommandList()!!
        model.listOfStrategies = SaveStrategyFactory.getSaveStrategyList()!!
        model.listOfValues = curState.values as ArrayList<String>
        view = CalcView
    }

    override fun actionPerformed(e: ActionEvent?) {
    }

    fun handleCommand(e: ActionEvent?){
        val command = CommandFactory.createCommand(e!!.actionCommand)
        if (paramaterizeInput(command)) {
            model.curValues.push(curState.stringToNum(view.resultWindow.text.split(" ").last()))
            model.curStringVal.push(view.resultWindow.text.split(" ").last())
            view.resultWindow.text = view.resultWindow.text + " " + command.value + " "
            model.curCommands
        }
    }

    fun handleValue(e: ActionEvent?){
        view.resultWindow.text = view.resultWindow.text + e?.actionCommand
    }

    fun handleStateChange(e: ActionEvent?){
        curState = StateFactory.createCalcState(e!!.actionCommand)
        model.listOfValues = curState.values as ArrayList<String>
        view.renderValues()
    }

    fun handleSaveStratagy(e: ActionEvent?){
        val strat = SaveStrategyFactory.createSaveStrategy(e!!.actionCommand)
        strat.save("CalculatorLog", model.history)
    }

    fun paramaterizeInput(input : Any): Boolean {
        return when(input){
            is Command, "Enter" -> view.resultWindow.text.last() != ' '
            else -> { true }
        }

    }

    fun handleEnter(e: ActionEvent) {
        if(paramaterizeInput("Enter"))
            model.solveCurFunction()

    }
    fun handleBackSpace(e: ActionEvent) {}
}
