package controleur.Game

import modele.Client
import modele.Dice
import view.game.GameView

class ActualiserGameView(vue: GameView, model : Client) {

    val vue = vue
    val model = model

    val id :Int = model.id!!
    val key :Int = model.key!!


    fun acctualiser(){
        var topPokomino = model.connect!!.gameState(id,key).pickosStackTops()
        var midelPokomino = model.connect!!.gameState(id,key).accessiblePickos()

        var isMyTurne = model.canPlay

        var dicerolls = model.connect!!.gameState(id,key).current.rolls
        var diceKept = model.connect!!.gameState(id,key).current.keptDices


        vue.
    }
}