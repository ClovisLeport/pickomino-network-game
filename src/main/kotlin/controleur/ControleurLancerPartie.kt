package controleur

import javafx.event.ActionEvent
import javafx.event.EventHandler
import view.Home.HomeView
import view.MainView
import view.game.GameView

class ControleurLancerPartie(vue : MainView) : EventHandler<ActionEvent> {

    var vue = vue
    override fun handle(event: ActionEvent?) {
        val NewPage = GameView()
        vue.updateView(NewPage)
    }
}