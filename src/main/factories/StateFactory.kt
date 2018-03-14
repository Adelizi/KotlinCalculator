package main.factories


class StateFactory {
    companion object {
        fun createState(stateType: String): Any {
            return Class.forName("main.commands.$stateType").kotlin
        }
    }
}
