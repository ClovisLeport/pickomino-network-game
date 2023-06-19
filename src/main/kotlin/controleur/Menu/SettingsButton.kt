package controleur.Menu

import javafx.beans.property.SimpleIntegerProperty
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.util.converter.NumberStringConverter
import view.Home.Center.CreateOrJoin
import view.Home.Center.Setting
import view.Home.HomeView

class SettingsButton(vue: HomeView): EventHandler<ActionEvent> {
    var vue = vue
    val i = SimpleIntegerProperty()
    override fun handle(event: ActionEvent?) {
        i.set(99)

        val newPage = Setting()
        newPage.nombre.textProperty().bindBidirectional(i, NumberStringConverter())
        newPage.slide.valueProperty().bindBidirectional(i)
        vue.update(newPage)
    }

}