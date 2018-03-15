package main.states

import main.CalcState

class Hex: CalcState {
    override val title: String = "Hex"
    override val name: String = "hex mode"
    override val values = ("7 8 9 4 5 6 1 2 3 0").split(" ")
}