package controleur.Menu

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.stage.Stage
import view.Home.Center.Setting
import view.Home.HomeView
import java.util.*

class QuitButton(vue: HomeView,primaryStage: Stage): EventHandler<ActionEvent> {
    var vue = vue
    var stage = primaryStage
    override fun handle(event: ActionEvent?) {
        stage.close()
    }
}