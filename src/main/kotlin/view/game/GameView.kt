package view.game

import javafx.geometry.Insets
import javafx.scene.layout.*
import javafx.scene.paint.Color

import view.View

import view.components.Pawn

import view.components.SmallTitle
import view.components.TransparentButton
import view.components.WhiteButton

class GameView : View() {
    // HEADER

    val header : VBox
    val pageTitle : SmallTitle
    val menuButton : TransparentButton
    val pawnTest : Pawn

    // Players and Desk

    init {


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