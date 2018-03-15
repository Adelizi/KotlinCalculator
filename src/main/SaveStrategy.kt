package main

import java.io.File
import java.util.*

interface SaveStrategy {
    val name: String
    val title: String
    fun save(filename: String, data: Stack<String>)
}

