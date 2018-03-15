package main

import java.awt.*
import javax.swing.*
import javax.swing.border.EmptyBorder
import kotlin.math.ceil
import kotlin.math.sqrt
import main.CalcController
import java.awt.event.ActionEvent

object CalcView : JFrame()  {

        private var valuePanel = JPanel()
        private val commandPanel = JPanel()
        private val functionWindow = JLabel("0")
        public val resultWindow = JLabel("0")
        private val resultPanel = JPanel()
        private val menuBar = JMenuBar()
        private val controller = CalcController
        private val model = CalcModel
        private val oneMore = JPanel()

    init {
        defaultCloseOperation = 3
        minimumSize = Dimension(500, 760)
        initStateMenu()
        initDisplayWindows()
        initCommandPanel()
        initValuePanel()
        val mainPanel = JPanel()
//        contentPane.setLayout(BoxLayout(contentPane, BoxLayout.Y_AXIS))
        contentPane.add(oneMore)
        oneMore.add(mainPanel, "South")
        mainPanel.size = Dimension(500 , 600)
        oneMore.add(resultWindow, "North")
//        oneMore.setLayout(BoxLayout(oneMore, BoxLayout.Y_AXIS))
        oneMore.layout = null
        resultPanel.minimumSize = Dimension(500, 100)
        resultPanel.layout = null
        resultPanel.setLocation(0, 0)
        mainPanel.setLocation(0,100)
        mainPanel.setLayout(BoxLayout(mainPanel, BoxLayout.Y_AXIS))
        mainPanel.minimumSize = Dimension(500, 400)
//        contentPane.add(resultPanel)
//        contentPane.add(resultWindow)
        mainPanel.add(commandPanel)
        commandPanel.size = Dimension(500, 350)
        mainPanel.add(valuePanel)
        valuePanel.size = Dimension(500, 350)
        commandPanel.setLocation(0, 0)
        commandPanel.setLocation(0, 350)


    }

    fun renderValues(){
        valuePanel.removeAll()
        valuePanel.updateUI()
        initValuePanel()
    }

    fun initStateMenu(){
        menuBar.font = Font("Arial", 1, 18)
        contentPane.add(menuBar, "North")
        val menu = JMenu()
        menu.font = Font("Arial", 0, 18)
        menuBar.add(menu)
        menuBar.font = Font("Arial", 1, 18)
        contentPane.add(menuBar, "North")
        val mnFile = JMenu("Options")
        mnFile.font = Font("Arial", 0, 18)
        menuBar.add(mnFile)

        for(i in model.listOfStrategies) {
            val saveAsMenuItem = JMenuItem(i.name)
            saveAsMenuItem.addActionListener { e : ActionEvent -> controller.handleSaveStratagy(e) }
            saveAsMenuItem.setMnemonic('x')
            saveAsMenuItem.font = Font("Arial", 0, 18)
            mnFile.add(saveAsMenuItem)
        }

        for(i in model.listOfAvailibleStates) {
            val stateMenuItem = JMenuItem(i.name)
            stateMenuItem.addActionListener {e : ActionEvent -> controller.handleStateChange(e)}
            stateMenuItem.actionCommand = i.title
            stateMenuItem.font = Font("Arial", 0 , 18)
            mnFile.add(stateMenuItem)
        }

    }

    fun initDisplayWindows(){
        resultWindow.border = EmptyBorder(3, 8, 0, 40)
        resultWindow.background = Color(51, 51, 51)
        resultWindow.isOpaque = true
        resultWindow.horizontalAlignment = 4
        resultWindow.foreground = Color(255, 255, 255)
        resultWindow.font = Font("Arial", 0, 18)
        resultWindow.setBounds(0, 0, 500, 100)
//        resultWindow.setSize(500, 100)
//        resultPanel.add(resultWindow)

    }

    fun initCommandPanel(){
        commandPanel.background = Color.WHITE
        commandPanel.font = Font("Arial", 0, 18)
//        contentPane.add(commandPanel)
        val size = ceil(sqrt(model.listOfCommands.size.toDouble())).toInt()
        commandPanel.layout = GridLayout(size, size)

        for ( i in model.listOfCommands){
            val button = JButton(i.value)
            button.addActionListener {e : ActionEvent -> controller.handleCommand(e)}
            button.actionCommand = i.commandType
            commandPanel.add(button)
        }
    }

    fun initValuePanel(){
        valuePanel.background = Color.WHITE
        valuePanel.font = Font("Arial", 0, 18)
//        contentPane.add(valuePanel)
        val size = ceil(sqrt(model.listOfValues.size.toDouble())).toInt()
        valuePanel.layout = GridLayout(size, size)

        for ( i in model.listOfValues){
            var button = JButton(i)
            button.addActionListener {e : ActionEvent -> controller.handleValue(e)}
            button.setSize(50, 50)
            button.actionCommand = i
            valuePanel.add(button)
        }
    }
}