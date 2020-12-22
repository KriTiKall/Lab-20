package controllors

import gui.MainForm
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import logic.markets.Market
import java.awt.event.ActionListener

class FormController(view: MainForm, model: Market) {

    private val view = view
    private val model = model

    private val order: MutableMap<String, Int> = mutableMapOf();

    init {
        initView()
    }

    private fun initView() {
        view.apply {
            model.showProviderProducts().forEach { choiceProduct.addItem(it) }
            bAdd.addActionListener(actionOfAdd())
            bSend.addActionListener(actionOfSend())
            createUI()
        }
    }

    private fun <K, V> mapToString(map: MutableMap<K, V>) =
            map.toString().substring(1, map.toString().length - 1).replace(", ", "\n")

    private fun actionOfSend() = ActionListener {
        GlobalScope.launch {
            model.orderedProducts(order)
            order.clear()
            view.apply {
                tpResult.text = model.toString()
                tpOrders.text = ""
            }
        }
    }

    private fun actionOfAdd() = ActionListener {
        GlobalScope.launch {
            view.apply {
                if(tCount.text.isEmpty())
                    return@launch

                val item = choiceProduct.selectedItem as String
                val count = tCount.text.toInt()

                if (order[item] != null)
                    order[item] = order[item]!! + count
                else
                    order[item] = count
                tpOrders.text = mapToString(order)
            }
        }
    }
}