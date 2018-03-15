package main

import java.io.File
import java.util.*

interface SaveStrategy {
    val name: String
    fun save(filename: String, data: Stack<Any>)
}

