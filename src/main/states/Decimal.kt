package main.states

import main.CalcState

class Decimal : CalcState{
    override val title: String = "Decimal"
    override val name: String = "decimal mode"
    override val values = ("7 8 9 4 5 6 1 2 3 0").split(" ")
}