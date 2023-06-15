package view.game

import javafx.geometry.Insets
import javafx.scene.layout.*
import javafx.scene.paint.Color
import view.View
import view.components.SmallTitle
import view.components.TransparentButton
import view.components.WhiteButton

class GameView : View() {
    // HEADER

    val header : VBox
    val pageTitle : SmallTitle
    val menuButton : TransparentButton
    val whitebutton : WhiteButton

    init {


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