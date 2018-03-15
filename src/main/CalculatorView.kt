import java.awt.*
import javax.swing.*
import javax.swing.border.EmptyBorder
import kotlin.math.ceil
import kotlin.math.sqrt

class ClacView(): JFrame() {

        private val valuePanel = JPanel()
        private val commandPanel = JPanel()
        private val functionWindow = JLabel("0")
        private val resultWindow = JLabel("0")
        private val menuBar = JMenuBar()
        private val controller = CalcController()
        private val model = CalcModel

    init {
        defaultCloseOperation = 3
        setSize(443, 700)
       // initStateMenu()
       // initDisplayWindows()
        //initCommandPanel()
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
            saveAsMenuItem.addActionListener { e -> controller.handleSaveStratagy(e) }
            saveAsMenuItem.setMnemonic('x')
            saveAsMenuItem.font = Font("Arial", 0, 18)
            mnFile.add(saveAsMenuItem)
        }

        for(i in model.listOfAvailibleStates) {
            val stateMenuItem = JMenuItem(i.title)
            stateMenuItem.addActionListener {e -> controller.handleStateChange(e)}
            stateMenuItem.actionCommand = i.name
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
        resultWindow.font = Font("Arial", 0, 72)
        resultWindow.setBounds(0, 0, 443, 96)
    }

    fun initCommandPanel(){
        commandPanel.background = Color.WHITE
        commandPanel.font = Font("Arial", 0, 18)
        contentPane.add(commandPanel)
        val size = ceil(sqrt(model.listOfCommands.size.toDouble())).toInt()
        commandPanel.layout = GridLayout(size, size)

        for ( i in model.listOfCommands){
            val button = JButton(i.value)
            button.addActionListener {e -> controller.handleCommand(e)}
            button.actionCommand = i.commandType
            commandPanel.add(button)
        }
    }

    fun initValuePanel(){
        valuePanel.background = Color.WHITE
        valuePanel.font = Font("Arial", 0, 18)
        contentPane.add(valuePanel)
        val size = ceil(sqrt(model.listOfValues.size.toDouble())).toInt()
        valuePanel.layout = GridLayout(size, size)

        for ( i in model.listOfValues){
            var button = JButton(i)
            button.addActionListener {e -> controller.handleValue(e)}
            button.setSize(50, 50)
            valuePanel.add(button)
        }
    }
}