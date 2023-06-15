package view.game

import javafx.geometry.Insets
import javafx.scene.layout.*
import javafx.scene.paint.Color
import view.components.SmallTitle
import view.components.TransparentButton
import view.components.WhiteButton
import java.awt.Label

class GameVue : BorderPane() {
    // HEADER
    val header : VBox
    val pageTitle : SmallTitle
    val menuButton : TransparentButton
    val whitebutton : WhiteButton

    init {
        // Background
        this.background = Background(BackgroundFill(Color.web("#3A83C2"), null, null))
        // HEADER Init
        this.header = VBox()
        this.header.style = "-fx-alignment: center;"

        this.pageTitle = SmallTitle("Pickomino")

        this.menuButton = TransparentButton("Menu")
        this.whitebutton = WhiteButton("lol")
        val margin = Insets(8.0, 0.0, 0.0, 0.0)
        VBox.setMargin(menuButton, margin)

        this.header.children.addAll(pageTitle,menuButton,whitebutton)
        this.top = header
    }
}