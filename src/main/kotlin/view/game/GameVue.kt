package view.game

import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import view.components.SmallTitle
import view.components.TransparentButton
import java.awt.Label

class GameVue : GridPane() {
    // HEADER
    val header : VBox
    val pageTitle : SmallTitle
    val menuButton : TransparentButton

    init {
        // Background
        this.background = Background(BackgroundFill(Color.web("#3A83C2"), null, null))
        // HEADER Init
        this.header = VBox()
        this.pageTitle = SmallTitle("Pickomino")
        this.menuButton = TransparentButton("Menu")
        this.header.children.addAll(pageTitle,menuButton)

        // Add to page
        this.children.addAll(header)
    }
}