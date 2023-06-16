package controleur

import javafx.event.ActionEvent
import javafx.event.EventHandler
import view.Home.HomeView

class ControleurButtonBackHomeView(vue : HomeView) : EventHandler<ActionEvent> {

    val vue = vue
    override fun handle(event: ActionEvent?) {
        vue.Goback()
    }


}