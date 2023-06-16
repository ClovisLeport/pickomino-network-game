package controleur.Menu

import Main
import javafx.event.ActionEvent
import javafx.event.EventHandler
import view.Home.Center.CreateOrJoin
import view.Home.Center.HomeCenter
import view.Home.Center.Menu
import view.Home.HomeView

class PlayButton(vue: HomeView): EventHandler<ActionEvent> {
    var vue = vue

    override fun handle(event: ActionEvent?) {
        var newPage = CreateOrJoin()
        //newPage.fixeButton()
        vue.update(newPage)
    }

}