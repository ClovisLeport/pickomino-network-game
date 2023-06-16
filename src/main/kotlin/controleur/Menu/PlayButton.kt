package controleur.Menu

import controleur.ControleurCreateParty
import controleur.ControleurButtonAcceptInJoinPartyPage
import controleur.ControleurJoinParty
import javafx.event.ActionEvent
import javafx.event.EventHandler
import view.Home.Center.CreateOrJoin
import view.Home.HomeView
import view.MainView

class PlayButton(vue: MainView,homview : HomeView): EventHandler<ActionEvent> {
    var vue = vue
    var homeview = homview
    override fun handle(event: ActionEvent?) {
        var newPage = CreateOrJoin()
        newPage.fixeButton(arrayOf(ControleurCreateParty(homeview,vue),ControleurJoinParty(homeview,vue)))
        homeview.update(newPage)
    }

}