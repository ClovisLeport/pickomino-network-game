package view.game

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import modele.Player
import org.controlsfx.control.spreadsheet.Grid

import view.View
import view.components.*
import java.util.Stack

class GameView(NombresJoueur : Int, actualNumberPlayer : Int) : View() {
    //paramettre

    val NombresJoueur = NombresJoueur
    val actualNumberPlayer = actualNumberPlayer


    // CenterPart (Header/Center/Footer)
    val centerPart : BorderPane
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

    // CENTER : Pickomino
    val pickominoSection : FlowPane

    // Bottom : PlayerSpace
    val playerSpace : HBox
    val rollDiceSection : VBox
    val rollDiceBtn : Button
    val rollDiceLabel : Label

    val playerPawnSection : VBox
    val playerPawnPile : StackPane
    val playerPawnDotted : Dotted
    val playerPawn : Pawn?
    val playerPawnLabel : Label

    val pickoSection : VBox
    val pickoMessage : Label
    val pickoImage : Image



    init {
        // Padding page
        this.padding = Insets(19.0, 20.0, 10.0, 20.0)

        // CenterPart
        centerPart = BorderPane()

        // HEADER Init
        this.header = VBox()
        this.header.style = "-fx-alignment: center;"

        this.pageTitle = SmallTitle("Pickomino")

        this.menuButton = TransparentButton("Menu")
        val margin = Insets(8.0, 0.0, 0.0, 0.0)
        VBox.setMargin(menuButton, margin)

        this.header.children.addAll(pageTitle,menuButton)
        centerPart.top = header

        // LEFT : PlayerList
        playersList = VBox()
        playersList.padding = Insets(0.0, 240.0, 0.0 , 0.0)

        playersList.alignment = Pos.TOP_CENTER

        // Loop into players
        val playersListName = mutableListOf<String>()
        for (numj in 1..NombresJoueur){

            if (numj != actualNumberPlayer){
                playersListName.add("Player N°$numj")
            }
        }

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
        diceSection.alignment = Pos.BOTTOM_RIGHT
        diceSection.padding = Insets(0.0,0.0,50.0,0.0)

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

        // CENTER : Pickomino
        pickominoSection = FlowPane()
        pickominoSection.hgap = 10.0
        pickominoSection.vgap = 10.0
        pickominoSection.maxWidth = 800.0

        for (pickomino in 21 until 37){
            val pickoPawn : Pawn
            if (pickomino < 25){
                pickoPawn = Pawn(pickomino, 1)
            } else if (pickomino < 29){
                pickoPawn = Pawn(pickomino, 2)
            } else if (pickomino < 33){
                pickoPawn = Pawn(pickomino, 3)
            } else {
                pickoPawn = Pawn(pickomino, 4)
            }
            pickominoSection.children.add(pickoPawn)
        }

        pickominoSection.alignment = Pos.CENTER
        centerPart.center = pickominoSection

        // BOTTOM : PlayerSpace
        playerSpace = HBox()
        playerSpace.alignment = Pos.CENTER
        playerSpace.spacing = 70.0

        // Roll Dice
        rollDiceSection = VBox()
        rollDiceSection.alignment = Pos.CENTER

        // RollDiceBTN
        rollDiceBtn = Button()
        val circleBtn = Circle(50.0)
        circleBtn.fill = Color.web("#FBFBF3")
        // AddImage into the button
        val rollDiceImage = Image("file:src/main/kotlin/view/assets/diceIcon.png")
        val rollDiceImageView = ImageView(rollDiceImage)
        rollDiceImageView.fitWidth = 80.0 // Largeur de l'image
        rollDiceImageView.fitHeight = 80.0 // Hauteur de l'image


        rollDiceBtn.graphic = StackPane(circleBtn, rollDiceImageView) // Add circle and image into BTN
        rollDiceBtn.style = "-fx-background-color: transparent;" // Remove default background

        rollDiceLabel = Label("Roll the dice")
        rollDiceLabel.textFill = Color.web("#FBFBF3")
        rollDiceLabel.style = "-fx-font-size: 20; -fx-font-weight: bold;"
        rollDiceLabel.padding = Insets(10.0 , 0.0 , 0.0,0.0)


        rollDiceSection.children.addAll(rollDiceBtn, rollDiceLabel)

        // playerPawnSection
        playerPawnSection = VBox() // Section
        playerPawnSection.alignment = Pos.CENTER
        playerPawnPile = StackPane() //Dotted and pawn
        playerPawnDotted = Dotted(84.0, 163.0) //Dotted

        playerPawnPile.children.add(playerPawnDotted)

        playerPawn = null// Pawn(28,4) //Correspond au Pikomino le plus récent (Ici c'est un test pour IHM)
        if (playerPawn != null){
            playerPawnPile.children.add(playerPawn)
        }
        playerPawnLabel = Label("Player N°$actualNumberPlayer")
        playerPawnLabel.textFill = Color.web("#FBFBF3")
        playerPawnLabel.style = "-fx-font-size: 24;"
        playerPawnLabel.padding = Insets(10.0, 0.0, 0.0, 0.0)

        playerPawnSection.children.addAll(playerPawnPile, playerPawnLabel)

        // Picko and message
        pickoSection = VBox()
        pickoSection.alignment = Pos.CENTER

        pickoMessage = Label("Tom is playing...")
        pickoMessage.textFill = Color.web("#FBFBF3")
        pickoMessage.style = "-fx-font-size: 20;"

        pickoImage = Image("file:src/main/kotlin/view/assets/worm-6 3.png")
        val pickoImageView = ImageView(pickoImage)

        pickoSection.children.addAll(pickoMessage,pickoImageView)


        playerSpace.children.addAll(rollDiceSection, playerPawnSection, pickoSection)

        centerPart.bottom = playerSpace


        this.center = centerPart
    }
}