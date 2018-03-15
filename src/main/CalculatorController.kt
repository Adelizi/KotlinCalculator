package main

import main.Controls.BackSpace
import main.Controls.Enter
import main.factories.CommandFactory
import main.factories.SaveStrategyFactory
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import main.factories.StateFactory
import main.states.Decimal

object CalcController : ActionListener {

    val view : CalcView
    val model = CalcModel

    init{
        model.listOfAvailibleStates = StateFactory.getCalcStateList()!!
        model.listOfCommands = CommandFactory.getCommandList()!!
        model.listOfStrategies = SaveStrategyFactory.getSaveStrategyList()!!
        model.listOfValues = model.curState.values as ArrayList<String>
        view = CalcView
    }

    override fun actionPerformed(e: ActionEvent?) {
    }

    fun handleCommand(e: ActionEvent?){
        val command = CommandFactory.createCommand(e!!.actionCommand)
        if (paramaterizeInput(command)) {
            model.log(command)
            view.renderWindow()
        }
    }

    fun handleValue(e: ActionEvent?){
        model.log(e!!.actionCommand)
        view.resultWindow.text = view.resultWindow.text + e.actionCommand
    }

    fun handleStateChange(e: ActionEvent?){
        model.stateChange()
        model.curState = StateFactory.createCalcState(e!!.actionCommand)
        if (!model.stateChange()){
            print("here")
            return
        }
        model.MasterLog.add("State Change to " + e.actionCommand)
        model.listOfValues = model.curState.values as ArrayList<String>
        view.renderValues()
        model.recalcDispaly()
        view.renderWindow()
    }

    fun handleSaveStratagy(e: ActionEvent?){
        val strat = SaveStrategyFactory.createSaveStrategy(e!!.actionCommand)
//        strat.save("CalculatorLog", model.history)
        TODO("needs model to be finalized")
    }

    fun handleEnter(e: ActionEvent) {
        model.MasterLog.add(Enter())
        if(paramaterizeInput("Enter"))
            model.solveCurFunction()
        TODO("needs model to be finalized")

    }

    fun handleBackSpace(e: ActionEvent) {
        model.MasterLog.add(BackSpace())
        model.curCommands.pop()
    }

    fun paramaterizeInput(input : Any): Boolean {
        return when(input){
            is Command, "Enter" -> view.resultWindow.text.last() != ' '
            else -> { true }
        }

    }
}
