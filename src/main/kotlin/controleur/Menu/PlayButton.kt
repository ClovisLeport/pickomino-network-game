package controleur.Menu

import Main
import controleur.ControleurCreateParty
import javafx.event.ActionEvent
import javafx.event.EventHandler
import view.Home.Center.CreateOrJoin
import view.Home.Center.HomeCenter
import view.Home.Center.Menu
import view.Home.HomeView
import view.MainView

class PlayButton(vue: MainView,homview : HomeView): EventHandler<ActionEvent> {
    var vue = vue
    var homeview = homview
    override fun handle(event: ActionEvent?) {
        var newPage = CreateOrJoin()
        newPage.fixeButton(arrayOf(ControleurCreateParty(homeview,vue),ControleurCreateParty(homeview,vue)))
        homeview.update(newPage)
    }

}