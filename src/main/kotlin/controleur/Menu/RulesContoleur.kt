package controleur.Menu

import javafx.event.ActionEvent
import javafx.event.EventHandler
import view.Home.Center.CreateOrJoin
import view.Home.HomeView

class RulesContoleur(vue: HomeView): EventHandler<ActionEvent> {
    var vue = vue
    override fun handle(event: ActionEvent?) {
        var newPage = CreateOrJoin()
        //newPage.fixeButton()
        vue.update(newPage)
    }

}