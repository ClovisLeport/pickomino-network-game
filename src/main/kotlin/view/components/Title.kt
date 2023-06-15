package view.components

import javafx.scene.control.Label
import javafx.scene.paint.Color
import javafx.scene.text.Font

class Title() {
    init {
        val labelTitle = Label("Pickomino")
        labelTitle.setTextFill(Color.web("#FFFFFF"))
        val TeslaFont = Font.loadFont("file:src/main/kotlin/view/fonts/TESLA.ttf", 80.0)
        labelTitle.font = TeslaFont
    }
}