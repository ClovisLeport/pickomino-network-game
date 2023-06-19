package controleur

import javafx.beans.property.SimpleIntegerProperty
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.util.converter.NumberStringConverter
import view.Home.Center.Setting
import view.Home.HomeView
import view.MainView

class ControleurSetting(vue : HomeView, Mainvue: MainView) : EventHandler<ActionEvent> {

    val vue = vue
    val Mainvue = Mainvue
    val i = SimpleIntegerProperty()
    override fun handle(event: ActionEvent?) {
        i.set(99)

        val NewPage = Setting()
        NewPage.nombre.textProperty().bindBidirectional(i, NumberStringConverter())
        NewPage.slide.valueProperty().bindBidirectional(i)
        vue.update(NewPage)
    }
}