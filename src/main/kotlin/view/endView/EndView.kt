package view.endView

import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import view.View
import view.components.Pawn

class EndView(listpickominoPlayer: MutableList<MutableList<Pawn>>) : View() {

    val listpickominoPlayer = listpickominoPlayer

    init {
        //top
        //this.top =





        //center
        val vbox = VBox()
        val sumworm = mutableListOf<Int>()

        var numj = 0
        for (pickominoPlayer in  listpickominoPlayer){
            numj++
            val vbocplayer = VBox()
            val nomjoueur = Label("Player N°$numj")
            nomjoueur.styleClass.add("txt")


            val hboxpicko = HBox()

            var sum = 0
            for (picko in pickominoPlayer) {
                hboxpicko.children.add(picko)
                sum += picko.thworm
            }

            vbocplayer.children.addAll(nomjoueur,hboxpicko)
            sumworm.add(sum)
        }

        var max = sumworm[0]
        for (i in 1..sumworm.size-1){
            if (max < sumworm[i]){
                max = sumworm[i]
            }
        }

        var joueurGanier :String = ""
        var nbGaninant = 0
        for (i in 0..sumworm.size-1){
            if (sumworm[i] == max){
                nbGaninant++
                joueurGanier += " Joueur N°${i+1},"
            }
        }
        joueurGanier.dropLast(1)

        val MessageVictoire : Label
        if (nbGaninant > 1){
            MessageVictoire = Label("Les ${joueurGanier} On Gagner")
        }
        else{
            MessageVictoire = Label("Le ${joueurGanier} a Gagner")
        }

        vbox.children.add(MessageVictoire)

        this.center = vbox


    }
}