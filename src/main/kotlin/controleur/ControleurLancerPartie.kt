package controleur

import javafx.event.ActionEvent
import javafx.event.EventHandler
import view.Home.Center.SelecteNumberPlayer
import view.Home.HomeView
import view.MainView
import view.game.GameView
import java.lang.Exception

class ControleurLancerPartie(vue : HomeView, mainvue : MainView) : EventHandler<ActionEvent> {

    var mainvue = mainvue
    var vue = vue
    override fun handle(event: ActionEvent?) {

        val actualvue = vue.center as SelecteNumberPlayer
        val nbPlayer = actualvue.NumberPlayer

        val actual = actualvue.Combobox.value as String
        val actualPlayer = (actual.substring(actual.length-1)).toInt()



        val NewPage = GameView(nbPlayer,actualPlayer)
        mainvue.updateView(NewPage)
    }
}