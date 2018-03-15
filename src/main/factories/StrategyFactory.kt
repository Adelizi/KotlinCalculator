package main.factories

import main.Strategy
import main.strategies.*
import java.io.File

class StrategyFactory {
    companion object {
        fun createStrategy(strategyType: String): Strategy {
            val kClass = Class.forName("main.strategies.$strategyType")

            return kClass.newInstance() as Strategy
        }
        fun listStrategyNames(): ArrayList<String>?{
            var names: ArrayList<String> = ArrayList()
            for(name in File("../KotlinCalculator/src/main/strategies").list()){
                names.add(name.toString())
            }
            return names
        }
        fun getStrategyList(): ArrayList<Strategy>?{
            var strategies: ArrayList<Strategy> = ArrayList()
            for (name in this.listStrategyNames()!!){
                strategies.add(createStrategy(name))
            }
            return strategies
        }
    }
}