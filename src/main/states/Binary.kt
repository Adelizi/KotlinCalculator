package main.states

import main.CalcState

class Binary : CalcState {
    override fun numToString(i: Int): String {
        return i.toString(2)

    }

    override fun stringToNum(s: String): Int {
        return s.toInt(2)
    }

    override val title = "Binary"

    override val name = "Binary mode"

    override val values = "1 0 .".split(" ")

}