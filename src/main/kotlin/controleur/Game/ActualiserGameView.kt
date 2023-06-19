package controleur.Game

import iut.info1.pickomino.data.DICE
import modele.Client
import modele.Dice
import view.game.GameView

class ActualiserGameView(vue: GameView, model : Client) {

    val vue = vue
    val model = model

    val id :Int = model.id!!
    val key :Int = model.key!!


    fun acctualiser(){
        model.update()

        var topPokomino = model.connect!!.gameState(id,key).pickosStackTops()
        var midelPokomino = model.connect!!.gameState(id,key).accessiblePickos()

        var isMyTurne = model.canRoll

        var dicerolls = model.connect!!.gameState(id,key).current.rolls
        var Intdicerolls = this.convertDiceIntoInt(dicerolls.toTypedArray())

        var diceKept = model.connect!!.gameState(id,key).current.keptDices
        var IntdiceKept = this.convertDiceIntoInt(diceKept.toTypedArray())


        vue.UpDatePickomino(midelPokomino.toTypedArray())
        vue.UpDatePickominoPlayer(topPokomino.toTypedArray())

        if (isMyTurne){
            vue.can_play()
        }else{
            vue.cant_play()
        }

        vue.UpDateDiceRoll(Intdicerolls,ControleurButtonKeepDice(vue,model),IntdiceKept)
        vue.UpDateDiceKeep(IntdiceKept)
    }

    fun convertDiceIntoInt(array : Array<DICE>) : Array<Int>{
        val listeInt = mutableListOf<Int>()

        for (Dice in array){
            when (Dice){
                DICE.d1 -> listeInt.add(1)
                DICE.d2 -> listeInt.add(2)
                DICE.d3 -> listeInt.add(3)
                DICE.d4 -> listeInt.add(4)
                DICE.d5 -> listeInt.add(5)
                DICE.worm -> listeInt.add(6)
            }
        }

        return listeInt.toTypedArray()
    }
}