package controleur

import javafx.event.ActionEvent
import javafx.event.EventHandler
import view.Home.Center.CreateServer
import view.Home.HomeView
import view.MainView

class ControleurCreateParty(vue : HomeView,Mainvue: MainView) : EventHandler<ActionEvent> {

    val vue = vue
    val Mainvue = Mainvue
    override fun handle(event: ActionEvent?) {
        val NewPage = CreateServer()
        NewPage.fixeButton(arrayOf(ControleurLancerPartie(Mainvue)))
        vue.update(NewPage)
    }
}