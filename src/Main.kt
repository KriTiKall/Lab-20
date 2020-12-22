import controllors.FormController
import gui.MainForm
import logic.factories.BakeryPlant
import logic.markets.Bakery
import logic.providers.BakeryProvider


fun main() {

    val model = Bakery(BakeryProvider(BakeryPlant()))

    val view = MainForm()

    val controller = FormController(view, model)

}
