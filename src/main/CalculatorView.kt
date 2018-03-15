package main

import java.awt.*
import javax.swing.*
import javax.swing.border.EmptyBorder
import kotlin.math.ceil
import kotlin.math.sqrt
import main.CalcController
import main.helpers.ImagePanelA
import java.awt.event.ActionEvent
import java.io.File
import java.net.URL
import javax.imageio.ImageIO

object CalcView : JFrame()  {

        private var valuePanel = JPanel()
        private val commandPanel = JPanel()
        private val functionWindow = JLabel("0")
    val resultWindow = JLabel("0")
        private val menuBar = JMenuBar()
        private val controller = CalcController
        private val model = CalcModel
        private val oneMore = ImagePanelA(ImageIO.read(File("src/main/images/ticalc.jpg")))

    init {
        defaultCloseOperation = 3
        minimumSize = Dimension(430, 975)
        initStateMenu()
        initDisplayWindows()
        initCommandPanel()
        initValuePanel()
        val mainPanel = JPanel()
//        contentPane.setLayout(BoxLayout(contentPane, BoxLayout.Y_AXIS))
        contentPane.add(oneMore)
        oneMore.add(mainPanel, "South")
        mainPanel.size = Dimension(365 , 600)
        oneMore.add(resultWindow)
//        oneMore.setLayout(BoxLayout(oneMore, BoxLayout.Y_AXIS))
        oneMore.layout = null
        mainPanel.setLocation(35,345)
        mainPanel.layout = null
        mainPanel.minimumSize = Dimension(395, 400)
        mainPanel.add(commandPanel, "North")
        commandPanel.size = Dimension(395, 350)
        mainPanel.add(valuePanel, "South")
        valuePanel.size = Dimension(395, 350)
        valuePanel.setLocation(0, 350)
        commandPanel.setLocation(0, 0)


    }

    fun renderValues(){
        valuePanel.removeAll()
        valuePanel.updateUI()
        initValuePanel()
    }

    fun initStateMenu(){
        menuBar.font = Font("Arial", 1, 18)
        menuBar.font = Font("Arial", 1, 18)
        contentPane.add(menuBar, "North")
        val mnFile = JMenu("Options")
        mnFile.font = Font("Arial", 0, 18)
//        contentPane.add(mnFile)
        menuBar.add(mnFile)

        for(i in model.listOfStrategies) {
            val saveAsMenuItem = JMenuItem(i.title)
            saveAsMenuItem.addActionListener { e : ActionEvent -> controller.handleSaveStratagy(e) }
            saveAsMenuItem.actionCommand = i.name
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
        resultWindow.setBounds(65, 73, 310, 100)

    }

    fun initCommandPanel(){
        commandPanel.background = Color.WHITE
        commandPanel.font = Font("Arial", 0, 18)
        val size = ceil(sqrt((model.listOfCommands.size + 2).toDouble())).toInt()
        commandPanel.layout = GridLayout(size, size)

        for ( i in model.listOfCommands){
            val button = JButton(i.value)
            button.addActionListener {e : ActionEvent -> controller.handleCommand(e)}
            button.actionCommand = i.commandType
            commandPanel.add(button)
        }

        var butt = JButton("Enter")
        butt.addActionListener {e : ActionEvent -> controller.handleEnter(e)}
        commandPanel.add(butt)
        butt = JButton("<-")
        butt.addActionListener {e : ActionEvent -> controller.handleBackSpace(e)}
        commandPanel.add(butt)
    }

    fun initValuePanel(){
        valuePanel.background = Color.WHITE
        valuePanel.font = Font("Arial", 0, 18)
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