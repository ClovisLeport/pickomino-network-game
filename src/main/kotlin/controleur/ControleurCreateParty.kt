package controleur

import javafx.event.ActionEvent
import javafx.event.EventHandler
import view.Home.Center.CreateServer
import view.Home.HomeView

class ControleurCreateParty(vue : HomeView) : EventHandler<ActionEvent> {

    val vue = vue
    override fun handle(event: ActionEvent?) {
        val NewPage = CreateServer()
        NewPage.fixeButton(arrayOf())
        vue.update(NewPage)
    }
}