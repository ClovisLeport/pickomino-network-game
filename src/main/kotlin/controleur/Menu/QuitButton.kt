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
        val alert = Alert(Alert.AlertType.CONFIRMATION)
        alert.title = "Confirmation Dialog"
        alert.headerText = "Etes vous sur de quitter le jeu ?"
        val result: Optional<ButtonType> = alert.showAndWait()
        if (result.get() === ButtonType.OK) {
            stage.close()
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }
}