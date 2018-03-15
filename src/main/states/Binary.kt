package main.states

import main.CalcState

class Binary: CalcState {
    override val title: String = "Binary"
    override val name: String = "binary mode"
    override val values = ("7 8 9 4 5 6 1 2 3 0").split(" ")

}