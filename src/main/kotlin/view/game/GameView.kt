package view.game

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.*
import javafx.scene.paint.Color
import org.controlsfx.control.spreadsheet.Grid

import view.View
import view.components.*
import java.awt.Font

class GameView : View() {
    // HEADER
    val header : VBox
    val pageTitle : SmallTitle
    val menuButton : TransparentButton

    // LEFT : Players and Desk
    val playersList : VBox

    // RIGHT : Dices
    val diceSection : VBox

    val diceKeptSection : VBox
    val diceKeptTitle : Label
    val diceKept : GridPane

    val dicePlayedSection : VBox
    val dicePlayedTitle :Label
    val dicePlayed : GridPane

    init {
        // Padding page
        this.padding = Insets(19.0, 20.0, 10.0, 20.0)

        // HEADER Init
        this.header = VBox()
        this.header.style = "-fx-alignment: center;"

        this.pageTitle = SmallTitle("Pickomino")

        this.menuButton = TransparentButton("Menu")
        val margin = Insets(8.0, 0.0, 0.0, 0.0)
        VBox.setMargin(menuButton, margin)

        this.header.children.addAll(pageTitle,menuButton)
        this.top = header

        // LEFT : PlayerList
        playersList = VBox()
        playersList.alignment = Pos.TOP_CENTER

        // Loop into players
        val playersListName = arrayOf("Clément", "Martin", "Tom")
        for (playerFor in playersListName){
            // Player location
            val player = VBox()
            player.alignment = Pos.CENTER
            // PlayerName
            val playerName = Label(playerFor)
            playerName.textFill = Color.web("#FBFBF3")
            playerName.style = "-fx-font-size: 24;"
            playerName.padding = Insets(0.0, 0.0, 10.0, 0.0)

            // StackPane
            val pile = StackPane()

            // PlayerDotted
            val dotted = Dotted(86.0, 165.0)
            pile.children.add(dotted)

            player.children.addAll(playerName, pile)
            VBox.setVgrow(player, Priority.ALWAYS)
            playersList.children.add(player)
        }

        this.left = playersList

        // RIGHT : Dices
        diceSection = VBox()
        diceSection.spacing = 40.0
        // diceKeptSection
        diceKeptSection = VBox()
        diceKeptSection.alignment = Pos.TOP_RIGHT // Alignement à droite du VBox

        diceKeptTitle = Label("Dice kept")
        diceKeptTitle.style = "-fx-font-size: 24; -fx-font-weight: bold;"
        diceKeptTitle.textFill = Color.web("#FBFBF3")
        diceKeptTitle.padding = Insets(0.0, 0.0, 10.0, 0.0)

        diceKept = GridPane()
        diceKept.hgap = 8.0 // Espacement horizontal entre les colonnes
        diceKept.vgap = 8.0 // Espacement vertical entre les lignes
        diceKept.alignment = Pos.TOP_RIGHT
        // Création des carrés et ajout dans le GridPane
        for (row in 0 until 4) {
            for (col in 0 until 2) {
                // Stack pane (Dotted & dice)
                val stackPaneDice = StackPane()
                val dotted = Dotted(70.0, 70.0)

                stackPaneDice.children.add(dotted)
                diceKept.add(stackPaneDice, col, row)
            }
        }

        diceKeptSection.children.addAll(diceKeptTitle,diceKept)

        // dicePlayedSection
        dicePlayedSection = VBox()
        dicePlayedSection.alignment = Pos.TOP_RIGHT // Alignement à droite du VBox

        dicePlayedTitle = Label("Dice played")
        dicePlayedTitle.style = "-fx-font-size: 24; -fx-font-weight: bold;"
        dicePlayedTitle.textFill = Color.web("#FBFBF3")
        dicePlayedTitle.padding = Insets(0.0, 0.0, 10.0, 0.0)

        dicePlayed = GridPane()
        dicePlayed.hgap = 8.0 // Espacement horizontal entre les colonnes
        dicePlayed.vgap = 8.0 // Espacement vertical entre les lignes
        dicePlayed.alignment = Pos.TOP_RIGHT
        for (row in 0 until 2) {
            for (col in 0 until 4) {
                // Stack pane (Dotted & dice)
                val stackPaneDice = StackPane()
                val dotted = Dotted(70.0, 70.0)

                stackPaneDice.children.add(dotted)
                dicePlayed.add(stackPaneDice, col, row)
            }
        }

        dicePlayedSection.children.addAll(dicePlayedTitle, dicePlayed)

        diceSection.children.addAll(diceKeptSection, dicePlayedSection)
        this.right = diceSection
    }
}