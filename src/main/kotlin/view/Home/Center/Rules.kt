package view.Home.Center

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.Text
import view.Home.HomeView
import view.components.WhiteButton

class Rules() :HomeCenter(false ) {

    var vbox = VBox()
    var title = Text()


    init {
        val title = Label("Rules")
        title.setTextFill(Color.web("#FBFBF3"))
        val TeslaFont = Font.loadFont("file:src/main/kotlin/view/fonts/TESLA.ttf", 40.0)
        title.font = TeslaFont
        this.alignment = Pos.CENTER
        var rulestext = Label(
            "Equipment: The base game includes 16 numbered pickomino dice ranging from 21 to 36, one \"21\" tile, eight \"X5\" tiles (with worms), and a game board.\n\n" +
                "Objective: The goal of the game is to score the most points by collecting pickominos with high values.\n\n" +
                "Setup: Place the 16 pickomino dice on the game board with their faces visible. Distribute 8 \"X5\" tiles (worms) to each player and place the \"21\" tile in the center of the board.\n\n" +
                "Gameplay:\n" +
                "Players take turns clockwise.\n" +
                "On each turn, the player rolls the 8 pickomino dice. Dice with values from 3 to 6 are placed face up in front of the player.\n" +
                "The player can choose to reroll some dice up to three times, keeping the dice they want between each reroll.\n" +
                "After each reroll, the player must choose a pickomino with the highest value among those visible in front of them. This pickomino is placed face up in front of the player.\n" +
                "If the player has collected at least one pickomino, they can choose to stop and score points equal to the sum of the values of the collected pickominos. Otherwise, they score no points for that turn.\n" +
                "If the player obtains a \"21\" pickomino, they must immediately place it face up in front of them and can continue rerolling the remaining dice.\n" +
                "End of the game:\n" +
                "The game continues until a player reaches or exceeds 35 points. That player is declared the winner.\n" +
                "In case of a tie, the player with the highest number of pickominos wins the game. If the tie persists, the players share the victory.\n\n" +
                "Extensions :\n" +
                "The base game can be expanded with extensions that include special pickominos and additional rules for more variety and strategy.")
        rulestext.setTextFill(Color.web("#FBFBF3"))
        val rulesFont = Font.loadFont("file:src/main/kotlin/view/fonts/helvetica/Helvetica.ttf", 14.0)
        rulestext.font = rulesFont
        this.children.addAll(title,rulestext)
        this.childrenUnmodifiable
    }

    override fun fixeButton(listControleur: Array<EventHandler<ActionEvent>>) {
        TODO("Not yet implemented")
    }

}