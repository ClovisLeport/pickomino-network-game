package controleur.Game

import javafx.event.EventHandler
import javafx.scene.input.MouseEvent
import modele.Client
import view.components.Dice
import view.components.Pawn
import view.game.GameView

class ControleurPickomino(vue : GameView, model : Client) : EventHandler<MouseEvent> {

    val vue = vue
    val model = model

    override fun handle(event: MouseEvent) {
        if (model.cankeepPICKO){
            val objet = event.source as Pawn
            model.keepPickomino(objet.value)
        }

    }
}