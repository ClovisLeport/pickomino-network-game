package controleur.Menu

import javafx.event.ActionEvent
import javafx.event.EventHandler
import view.Home.Center.CreateOrJoin
import view.Home.Center.Setting
import view.Home.HomeView

class SettingsButton(vue: HomeView): EventHandler<ActionEvent> {
    var vue = vue
    override fun handle(event: ActionEvent?) {
        var newPage = Setting()
        //newPage.fixeButton()
        vue.update(newPage)
    }

}