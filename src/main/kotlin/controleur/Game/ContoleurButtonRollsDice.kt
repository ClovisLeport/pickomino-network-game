package controleur.Game

import javafx.event.ActionEvent
import javafx.event.EventHandler
import kotlinx.serialization.descriptors.mapSerialDescriptor
import modele.Client
import view.game.GameView


class ContoleurButtonRollsDice(vue : GameView, model : Client) : EventHandler<ActionEvent> {

    val vue = vue
    val model = model

    override fun handle(event: ActionEvent?) {
        if (model.canRoll){
            model.game.setDice(model.game.diceKept, model.connect!!.rollDices(model.id!!,model.key!!))
        }
    }

}