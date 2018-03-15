package main.factories

import main.CalcState
import main.states.*
import java.io.File

class StateFactory {
    companion object {
        fun createCalcState(stateType: String): CalcState {
            val kClass = Class.forName("main.states.$stateType")

            return kClass.newInstance() as CalcState
        }
        fun listCalcStateNames(): ArrayList<String>?{
            var names: ArrayList<String> = ArrayList()
            for(name in File("../KotlinCalculator/src/main/states").list()){
                names.add(name.toString())
            }
            return names
        }
        fun getCalcStateList(): ArrayList<CalcState>?{
            var states: ArrayList<CalcState> = ArrayList()
            for (name in this.listCalcStateNames()!!){
                states.add(createCalcState(name.split(".")[0]))
            }
            return states
        }
    }
}