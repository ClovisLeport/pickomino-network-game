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
        var Intdicerolls = model.game.convertArrayDiceIntoInt(dicerolls.toTypedArray())

        var diceKept = model.connect!!.gameState(id,key).current.keptDices
        var IntdiceKept = model.game.convertArrayDiceIntoInt(diceKept.toTypedArray())


        vue.UpDatePickomino(midelPokomino.toTypedArray())
        vue.UpDatePickominoPlayer(topPokomino.toTypedArray())

        if (isMyTurne){
            vue.can_play()
        }else{
            vue.cant_play()
        }

        vue.UpDateDiceRoll(Intdicerolls,ControleurButtonKeepDice(vue,model),IntdiceKept)
        vue.UpDateDiceKeep(IntdiceKept)




        var ValueDice = model.game.AllDiceNumber()
        if (21 <= ValueDice && ValueDice <= 36 ){
            vue.UpDateSelectionPickomino(ValueDice,ControleurPickomino(vue,model))//todo
        }

    }


}