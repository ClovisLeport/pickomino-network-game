package controleur

import javafx.beans.property.DoubleProperty
import javafx.beans.property.IntegerProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.util.converter.NumberStringConverter
import view.Home.Center.CreateServer
import view.Home.HomeView
import view.MainView

class ControleurCreateParty(vue : HomeView,Mainvue: MainView) : EventHandler<ActionEvent> {

    val vue = vue
    val Mainvue = Mainvue
    val i = SimpleIntegerProperty()
    override fun handle(event: ActionEvent?) {
        i.set(3)

        val NewPage = CreateServer()
        NewPage.nombre.textProperty().bindBidirectional(i,NumberStringConverter())
        NewPage.slider.valueProperty().bindBidirectional(i)
        NewPage.fixeButton(arrayOf(ControleurButtonAccept(vue,Mainvue)))
        vue.update(NewPage)
    }
}