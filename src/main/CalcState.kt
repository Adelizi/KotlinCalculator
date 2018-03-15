package main

import javax.print.attribute.IntegerSyntax

interface CalcState{
    val name : String
    val title : String
    val values : List<String>
    fun stringToNum(s : String): Int
    fun numToString(i : Int): String
}