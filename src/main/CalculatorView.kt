package main

import java.awt.*
import javax.swing.*

class ClacView(): JFrame() {

        private val valuePanel = JPanel()
        private val commandPanel = JPanel()
        private val functionWindow = JLabel("0")
        private val resultWindow = JLabel("0")
        private val menuBar = JMenuBar()
        private val controller = CalcController()

    init {
        this.defaultCloseOperation = 3
        this.setSize(443, 700)
        initStateMenu()
        initDisplayWindows()
        initCommandPanel()
        initValuePanel()
    }

    fun initStateMenu(){
        menuBar.font = Font("Arial", 1, 18)
        this.contentPane.add(menuBar, "North")
        val menu = JMenu()
        menu.font = Font("Arial", 0, 18)
        menuBar.add(menu)
        menuBar.font = Font("Arial", 1, 18)
        this.contentPane.add(menuBar, "North")
        val mnFile = JMenu("File")
        mnFile.font = Font("Arial", 0, 18)
        menuBar.add(mnFile)
    }
    fun initDisplayWindows(){

    }

    fun initCommandPanel(){
        this.commandPanel.background = Color.WHITE
        this.commandPanel.font = Font("Arial", 0, 18)
        this.contentPane.add(this.commandPanel)
        this.commandPanel.layout = GridLayout(5, 5)
        var oneButton = JButton("1")
        oneButton.addActionListener(controller)
        oneButton.actionCommand = "this is the command"
        this.commandPanel.add(oneButton)
        oneButton = JButton("asdf")
        oneButton.addActionListener(controller)
        oneButton.actionCommand = "this is the command1"
        this.commandPanel.add(oneButton)
        oneButton = JButton("+")
        oneButton.addActionListener(controller)
        oneButton.actionCommand = "this is the command2"
        this.commandPanel.add(oneButton)
    }

    fun initValuePanel(){

    }

    fun createActions(){

    }
}