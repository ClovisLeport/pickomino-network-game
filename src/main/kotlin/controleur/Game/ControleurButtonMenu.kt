package controleur.Game

import javafx.animation.Timeline
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent
import javafx.stage.Stage
import modele.Client
import view.Home.Center.JoinServeur
import view.Home.HomeView
import view.MainView
import view.components.Dice
import view.game.GameView

class ControleurButtonMenu(vue : MainView, stage: Stage,timeline : Timeline) : EventHandler<ActionEvent> {

    val vue = vue
    val stage = stage
    val timeline = timeline

    override fun handle(event: ActionEvent?){
        vue.updateView(HomeView(stage,vue))
        timeline.stop()
    }
}