package main

import java.io.File

interface SaveStrategy {
    val name: String
    fun save(filename: String, data: String)
}

