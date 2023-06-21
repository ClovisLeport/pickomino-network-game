package modele

import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.DICE
import iut.info1.pickomino.data.STATUS
import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.util.Duration
import java.security.cert.TrustAnchor

class Client(game: Game) {

    var id : Int? = null
    var key : Int? = null
    var connected : Boolean = false
    var connect : Connector? = null
    var game : Game = game
    var nbJoueur : Int = 0

    var canRoll = false
    var cankeepDice = false
    var cankeepPICKO = false

    var gameFinish = false



    fun CreateGame(nbJoueur : Int,numJoueur:Int){
        println("Hello students !!!")
        this.connect = Connector.factory("172.26.82.76", "8080")
        if (connect != null){
            //println("Parties actives sur le serveur = ${connect!!.listOfGameIds()}")
            val identification = connect!!.newGame(nbJoueur)
            this.nbJoueur = nbJoueur
            this.id = identification.first
            this.key = identification.second

            for ( numJ in 1..nbJoueur){
                if (numJ == numJoueur){
                    game.addPlayer(Player(numJ,true))
                }
                else{
                    game.addPlayer(Player(numJ,false))
                }
            }

            connected = true
        }
    }

    fun JoinGame(id:Int, key:Int,NbJoueur :Int){
        this.connect = Connector.factory("172.26.82.76", "8080")
        this.id = id
        this.key = key
        this.nbJoueur = NbJoueur
        connected = true

    }

    fun update(){
        if (connected != null && id != null && key != null && connect != null){
            canRoll = false
            cankeepDice = false
            cankeepPICKO = false

                var currentGame = connect!!.gameState(this.id!!, this.key!!)

                var ActualStatu =  currentGame.current.status

                if (currentGame.current.player+1 == game.numérojoueur){
                    if (( ActualStatu == STATUS.ROLL_DICE || ActualStatu == STATUS.ROLL_DICE_OR_TAKE_PICKOMINO)) {
                        canRoll = true
                    }
                    if (ActualStatu == STATUS.KEEP_DICE){
                        cankeepDice = true
                    }
                    if (ActualStatu == STATUS.ROLL_DICE_OR_TAKE_PICKOMINO || ActualStatu == STATUS.TAKE_PICKOMINO){
                        cankeepPICKO = true
                    }

                }

                else{
                    game.setDice(currentGame.current.rolls,currentGame.current.keptDices)
                    game.setPickomino(currentGame.accessiblePickos())


                    var playerList = game.playerList()
                    var pickominoOfplayer = currentGame.pickosStackTops()
                    for ( numj in 0..playerList.size-1){

                        println("numj : ${numj+1}")
                        playerList[numj].topPickominoIs(Pickomino(pickominoOfplayer[numj]))
                    }
                }

                if(ActualStatu == STATUS.GAME_FINISHED){
                    gameFinish = true
                }


        }
    }

    fun keepDice(valeur : Int){
        val v = game.convertIntintoDice(valeur)
        if (v !in game.diceChosen){
            connect!!.keepDices(id!!,key!!,v)
        }
    }

    fun keepPickomino(valeur :Int){
        println("$valeur : ${game.getPickos()} : ${game.pickominoPlayer()}")
        println("${Pickomino(valeur) in game.getPickos()} :: ${Pickomino(valeur) in game.pickominoPlayer()}")
        if (Pickomino(valeur) in game.getPickos() || Pickomino(valeur) in game.pickominoPlayer()){
            connect!!.takePickomino(id!!,key!!,valeur)
        }

    }




}