package main

import main.factories.CommandFactory
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

import main.factories.*

object CalcController : ActionListener {
    val model = CalcModel

    init {
        model.listOfAvailibleStates = StateFactory.getCalcStateList()!!
        model.listOfCommands = CommandFactory.getCommandList()!!
        model.listOfStrategies = StrategyFactory.getSaveStrategyList()!!
        model.listOfValues = StateFactory.createCalcState(model.curState).values as ArrayList<String>
    }
    val view = CalcView

    override fun actionPerformed(e: ActionEvent?) {
        //val comand = e.
        print(if (e != null) e.actionCommand else -1)
        print("hello")

    }
    fun handleCommand(e: ActionEvent?){
        //push command to the stack
        println(e!!.actionCommand)
        model.commandStack.add(CommandFactory.createCommand(e!!.actionCommand))
        for(c in model.commandStack){
            println(c.toString())
        }
    }
    fun handleValue(e: ActionEvent?){
        println(e!!.actionCommand)
//        model.commandStack.add(CommandFactory.createCommand(e!!.actionCommand))
//
//        for(c in model.commandStack){
//            println(c.toString())
//        }
        view.resultWindow.text = view.resultWindow.text.toString() + e?.actionCommand
        println(message = e?.actionCommand)

    }

    fun handleStateChange(e: ActionEvent?){

    }

    fun handleSaveStratagy(e: ActionEvent?){
        //save shtuff here
        //make strat pass it actioncommand.tostring (should be name of class)
        StrategyFactory.createSaveStrategy(e!!.actionCommand.toString()).save(
                "CalculatorLog",
                data = model.log.toString())

    }
}
