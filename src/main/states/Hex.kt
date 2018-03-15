package main.states

import main.CalcState

class Hex: CalcState {
    override fun stringToNum(s: String): Int {
        return s.toInt(16)
    }

    override fun numToString(i: Int): String {
        return i.toString(16).toUpperCase()
    }

    override val title = "Hex"
    override val name = "Hex mode"

    override val values = "C D E F 8 9 A B 4 5 6 7 0 1 2 3 .".split(" ")

}