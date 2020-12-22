package gui

import javax.swing.*
import javax.swing.WindowConstants.EXIT_ON_CLOSE

class MainForm() {

    /*
        Change list:
        1. Sum a count of  equals items
        2. Fixed bug with a displaying counts
        3. Redesigned architecture(MVC)
        4. The application is divided into graphical thread and solution threads
        5. Fixed more a small bugs
     */

    companion object {
        const val SCREEN_HEIGHT = 1080
        const val SCREEN_WIDTH = 1920

        const val WINDOW_HEIGHT = 600
        const val WINDOW_WIDTH = 810
    }

    val frMain = JFrame()
    val tpResult = JTextPane()
    val lOrder = JLabel("Order:")
    val choiceProduct: JComboBox<String> = JComboBox()
    val tCount = JTextField()
    val bAdd = JButton("add")
    val tpOrders = JTextPane()
    val bSend = JButton("send")

    fun createUI() {
        frMain.apply {
            setLocation((SCREEN_WIDTH - WINDOW_WIDTH) / 2, (SCREEN_HEIGHT - WINDOW_HEIGHT) / 2)
            layout = null
            title = "Market"
            defaultCloseOperation = EXIT_ON_CLOSE
            isVisible = true
            isResizable = false
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT)
        }

        tpResult.apply {
            setSize(580, 545)
            setLocation(10, 10)
            isVisible = true
            isEditable = false
        }

        lOrder.apply {
            setSize(50, 20)
            setLocation(600, 10)
            isVisible = true
        }

        tCount.apply {
            setSize(40, 20)
            setLocation(760, 30)
            isVisible = true
        }

        choiceProduct.apply {
            setSize(150, 20)
            setLocation(600, 30)
            isVisible = true
        }

        bAdd.apply {
            setSize(80, 20)
            setLocation(720, 60)
            isVisible = true
        }

        tpOrders.apply {
            setSize(200, 150)
            setLocation(600, 90)
            isVisible = true
            isEditable = false
        }

        bSend.apply {
            setSize(100, 20)
            setLocation(700, 250)
            isVisible = true
        }

        frMain.apply {
            add(tpOrders)
            add(bSend)
            add(bAdd)
            add(choiceProduct)
            add(tpResult)
            add(tCount)
            add(lOrder)
        }
    }
}