package controleur

import controleur.Game.ActualiserGameView
import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Alert
import javafx.util.Duration
import modele.Client
import modele.Game
import view.Home.Center.SelecteNumberPlayer
import view.Home.HomeView
import view.MainView
import view.game.GameView
import java.lang.Exception

class ControleurLancerPartie(vue : HomeView, mainvue : MainView) : EventHandler<ActionEvent> {

    var mainvue = mainvue
    var vue = vue
    override fun handle(event: ActionEvent?) {

        val actualvue = vue.center as SelecteNumberPlayer
        val nbPlayer = actualvue.NumberPlayer

        val actual = actualvue.Combobox.value

        if (actual == null){
            val dialog = Alert(Alert.AlertType.INFORMATION)
            dialog.title="Error"
            dialog.headerText="Vous n'avez pas choisi votre numéro"
            dialog.showAndWait()
        }
        else{
            val actualPlayer = (actual.substring(actual.length-1)).toInt()
            val NewPage = GameView(nbPlayer,actualPlayer)
            mainvue.updateView(NewPage)


            var model = Client(Game(nbPlayer))

            if (actualvue.isHost) {
                model.CreateGame(nbPlayer,actualPlayer)
            }
            else{
                val id : Int = actualvue.id!!
                val key : Int= actualvue.key!!
                model.JoinGame(nbPlayer,id,key)
            }




            fun updateLoop(){
                val timeline = Timeline(KeyFrame(Duration.seconds(1.0), { ActualiserGameView(NewPage,model) }))
                timeline.cycleCount = Animation.INDEFINITE
                timeline.play()
            }

        }


    }
}