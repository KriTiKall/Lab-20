import gui.MainForm
import logic.factories.BakeryPlant
import logic.markets.Bakery
import logic.providers.BakeryProvider
import contrellors.FormController

fun main() {

    val model = Bakery(BakeryProvider(BakeryPlant()))

    val view = MainForm()

    val controller = FormController(view, model)
}
