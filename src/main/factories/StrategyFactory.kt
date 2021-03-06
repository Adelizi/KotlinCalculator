package main.factories

import main.SaveStrategy
import main.strategies.*
import java.io.File

class StrategyFactory {
    companion object {
        fun createSaveStrategy(strategyType: String): SaveStrategy {
            val kClass = Class.forName("main.strategies.$strategyType")

            return kClass.newInstance() as SaveStrategy
        }
        fun listSaveStrategyNames(): ArrayList<String>?{
            var names: ArrayList<String> = ArrayList()
            for(name in File("../KotlinCalculator/src/main/strategies").list()) {
                names.add(name.toString().split('.')[0])
            }
            return names
        }
        fun getSaveStrategyList(): ArrayList<SaveStrategy>?{
            var strategies: ArrayList<SaveStrategy> = ArrayList()
            for (name in this.listSaveStrategyNames()!!){
                strategies.add(createSaveStrategy(name))
            }
            return strategies
        }
    }
}