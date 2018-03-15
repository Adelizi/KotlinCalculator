package main.states

import main.CalcState

class Hex: CalcState {
    override val title = "Hex"
    override val name = "Hex mode"

    override val values = "C D E F 8 9 A B 4 5 6 7 0 1 2 3".split(" ")

}