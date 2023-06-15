package view

import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color

abstract class View : BorderPane() {

    init {
        // Background
        this.background = Background(BackgroundFill(Color.web("#3A83C2"), null, null))
    }
}