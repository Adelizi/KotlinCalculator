import java.awt.event.ActionEvent
import java.awt.event.ActionListener

open class CalcController : ActionListener {
    override fun actionPerformed(e: ActionEvent?) {
        //val comand = e.
        print(if (e != null) e.actionCommand else -1)
        print("hello")
    }

}
