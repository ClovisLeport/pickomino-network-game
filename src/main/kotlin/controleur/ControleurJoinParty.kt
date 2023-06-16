package controleur

import javafx.event.ActionEvent
import javafx.event.EventHandler
import view.Home.Center.CreateServer
import view.Home.Center.JoinServeur
import view.Home.HomeView
import view.MainView

class ControleurJoinParty(vue : HomeView, Mainvue: MainView) : EventHandler<ActionEvent> {

    val vue = vue
    val Mainvue = Mainvue
    override fun handle(event: ActionEvent?) {
        val NewPage = JoinServeur()
        NewPage.fixeButton(arrayOf(ControleurButtonAcceptInJoinPartyPage(vue,Mainvue)))
        vue.update(NewPage)
    }
}