package main.states

import main.CalcState

class Binary: CalcState {
    override val title = "Binary"

    override val name = "Binary mode"

    override val values = "1 0".split(" ")

}