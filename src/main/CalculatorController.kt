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
        //val comand = e.
        print(if (e != null) e.actionCommand else -1)
        print("hello")
    }

    fun handleCommand(e: ActionEvent?){

    }

    fun handleValue(e: ActionEvent?){
        print(e?.actionCommand)
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
}
