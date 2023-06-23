package view.endView

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.FlowPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import view.View
import view.components.Dotted
import view.components.Pawn
import view.components.SmallTitle
import view.components.TransparentButton

class EndView(listpickominoPlayer: MutableList<MutableList<Pawn>>) : View() {

    val listpickominoPlayer = listpickominoPlayer
    val menuButton : TransparentButton

    init {
        //top
        val headerCenter = VBox()
        headerCenter.alignment = Pos.CENTER

        headerCenter.style = "-fx-alignment: center;"

        val pageTitle = SmallTitle("Pickomino")

        menuButton = TransparentButton("Menu")
        val margin = Insets(8.0, 0.0, 0.0, 0.0)
        VBox.setMargin(menuButton, margin)

        headerCenter.children.addAll(pageTitle,menuButton)

        this.top = headerCenter



        //center
        val vbox = VBox()
        val sumworm = mutableListOf<Int>()
        val rulesFont = Font.loadFont("file:src/main/kotlin/view/fonts/helvetica/Helvetica.ttf", 19.0)

        var numj = 0
        for (pickominoPlayer in  listpickominoPlayer){

            numj++
            val vboxplayer = VBox()
            val nomjoueur = Label("Player N°$numj")
            nomjoueur.styleClass.add("txt")

            nomjoueur.font = rulesFont
            val flowpain = FlowPane()

            var sum = 0
            for (picko in pickominoPlayer) {
                flowpain.children.add(picko)
                sum += picko.thworm
            }
            if (sum == 0){
                flowpain.children.add(Dotted(84.0, 163.0))
            }

            flowpain.alignment = Pos.CENTER
            vboxplayer.children.addAll(nomjoueur,flowpain)
            vboxplayer.spacing = 5.0
            sumworm.add(sum)
            vboxplayer.alignment = Pos.CENTER
            vbox.children.add(vboxplayer)
        }

        vbox.spacing = 10.0


        var max = sumworm[0]
        for (i in 1..sumworm.size-1){
            if (max < sumworm[i]){
                max = sumworm[i]
            }
        }
        var joueurGagner :String = ""
        var nbGagnant = 0
        for (i in 0..sumworm.size-1){
            if (sumworm[i] == max){
                nbGagnant++
                joueurGagner += " Joueur N°${i+1},"
            }
        }

        joueurGagner.dropLast(1)

        val MessageVictoire : Label
        if (nbGagnant > 1){
            MessageVictoire = Label("Les ${joueurGagner} On Gagnés")
        }
        else{
            MessageVictoire = Label("Le ${joueurGagner} a Gagné")
        }
        MessageVictoire.font = rulesFont
        MessageVictoire.styleClass.add("txt")
        vbox.children.add(MessageVictoire)
        vbox.alignment = Pos.CENTER

        this.center = vbox


    }


    fun fixButtonMenu(controleur : EventHandler<ActionEvent>){
        menuButton.onAction = controleur
        //menuButton.onMousePressed
    }
}