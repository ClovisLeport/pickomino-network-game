package controleur.Game

import javafx.event.EventHandler
import javafx.scene.input.MouseEvent
import modele.Client
import view.components.Dice
import view.game.GameView


class ControleurButtonKeepDice(vue : GameView,model : Client) : EventHandler<MouseEvent> {

    val vue = vue
    val model = model

    override fun handle(event: MouseEvent) {
        val objet = event.source as Dice
        model.keepDice(objet.diceNumber)

    }
}