package view.game

import javafx.geometry.Insets
import javafx.scene.layout.*
import javafx.scene.paint.Color
import view.components.Pawn
import view.components.SmallTitle
import view.components.TransparentButton
import view.components.WhiteButton
import java.awt.Label

class GameVue : BorderPane() {
    // HEADER
    val header : VBox
    val pageTitle : SmallTitle
    val menuButton : TransparentButton
    val pawnTest : Pawn

    // Players and Desk

    init {
        // Background
        this.background = Background(BackgroundFill(Color.web("#3A83C2"), null, null))
        // HEADER Init
        this.header = VBox()
        this.header.style = "-fx-alignment: center;"

        this.pageTitle = SmallTitle("Pickomino")

        this.menuButton = TransparentButton("Menu")
        val margin = Insets(8.0, 0.0, 0.0, 0.0)
        VBox.setMargin(menuButton, margin)

        this.header.children.addAll(pageTitle,menuButton)
        this.top = header

        // TEST PAWN
        this.pawnTest = Pawn(22, 3)
        this.center = pawnTest
    }
}