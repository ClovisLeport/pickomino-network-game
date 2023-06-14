package view.components

import javafx.scene.control.Label
import javafx.scene.paint.Color
import javafx.scene.text.Font

class SmallTitle(text: String) : Label() {
    init {
        this.text = text
        this.textFill = Color.web("#FBFBF2")

        // Add Font
        val teslaFont = Font.loadFont(
            "file:src/main/kotlin/view/fonts/TESLA.ttf",
            48.0)

        if (teslaFont == null) {
            println("La police de caractères n'a pas pu être chargée.")
        } else {
            this.font = teslaFont
        }
    }
}