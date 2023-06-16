package view.Home.Center

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.Rectangle2D
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.scene.shape.Arc
import javafx.scene.shape.ArcType
import javafx.scene.text.Font
import javafx.scene.text.Text
import javafx.stage.Screen
import view.components.WhiteButton

class Menu() :HomeCenter(true ) {

    var vbox = VBox()
    var title = Text()
    val PlayButton = WhiteButton("Play")
    val RulesButton = WhiteButton("Rules")
    val SettingsButton = WhiteButton("Settings")
    val QuitButton = WhiteButton("Quit")
    init {
        this.background = Background(BackgroundFill(Color.web("#3A83C2"), null, null))//#3A83C2

        // ---------------- IMAGES MODALITES ----------------
        this.padding = Insets(10.0,10.0,10.0,0.0)
        val imagePlayer = Image("file:src/main/kotlin/view/set/player.png")
        val imageViewPlayer = ImageView(imagePlayer)
        imageViewPlayer.setFitHeight(50.0);
        imageViewPlayer.setFitWidth(50.0);


        val imageAge = Image("file:src/main/kotlin/view/set/age.png")
        val imageViewAge= ImageView(imageAge)
        imageViewAge.setFitHeight(50.0);
        imageViewAge.setFitWidth(50.0);
        this.spacing = 5.0

        // ---------------- PRAIRIE ----------------
        /*val screenBounds: Rectangle2D = Screen.getPrimary().bounds
        val screenWidth = screenBounds.width
        val pane = Pane()
        val radius = screenWidth / 2
        val arc = Arc(radius, 0.0, radius, 100.0, 0.0, 180.0)
        arc.type = ArcType.ROUND
        arc.fill = Color.web("#4DA35C")*/

        // ---------------- TITRE ----------------
        val labelTitle = Label("Pickomino")
        labelTitle.setTextFill(Color.web("#FFFFFF"))
        val TeslaFont = Font.loadFont("file:src/main/kotlin/view/fonts/TESLA.ttf", 80.0)
        labelTitle.font = TeslaFont

        val labelQuote = Label("Draw the worms from the dice !")
        labelQuote.setTextFill(Color.web("#FFFFFF"))
        val HelveFont = Font.loadFont("file:src/main/kotlin/view/fonts/helvetica/Helvetica.ttf", 20.0)
        labelQuote.font = HelveFont

          val bpTop = BorderPane()
//        bpTop.alignment = Pos.BASELINE_LEFT
//        bpTop.spacing = 500.0
        val vbox_choice = VBox()
        vbox_choice.children.addAll(labelTitle,labelQuote)
        vbox_choice.alignment = Pos.CENTER
        bpTop.setLeft(imageViewPlayer)
        bpTop.setCenter(vbox_choice)

        val bpButton = BorderPane()
        val vbButton = VBox()

        vbButton.children.addAll(PlayButton,RulesButton,SettingsButton,QuitButton)
        vbButton.alignment = Pos.CENTER
        vbButton.padding = Insets(40.0,20.0,20.0,20.0)
        vbButton.spacing = 10.0
        bpButton.setCenter(vbButton)
        //bpButton.setBottom(arc)

        this.children.addAll(imageViewAge,bpTop,bpButton)//imageViewAge

    }
}