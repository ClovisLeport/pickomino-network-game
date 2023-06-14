package view

import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.VBox
import javafx.scene.paint.Color

class View : VBox() {

    init {
        // Background
        this.background = Background(BackgroundFill(Color.web("#3A83C2"), null, null))
    }
}