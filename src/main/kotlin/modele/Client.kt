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



    fun CreateGame(nbJoueur : Int,numJoueur:Int){
        println("Hello students !!!")
        this.connect = Connector.factory("172.26.82.76", "8080")
        if (connect != null){
            println("Parties actives sur le serveur = ${connect!!.listOfGameIds()}")
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

            //while (true){
                var currentGame = connect!!.gameState(this.id!!, this.key!!)

                var ActualStatu =  currentGame.current.status

                if (currentGame.current.player+1 == game.numérojoueur &&( currentGame.current.status == STATUS.ROLL_DICE || currentGame.current.status == STATUS.ROLL_DICE_OR_TAKE_PICKOMINO)) {
                    canRoll = true
                }
                else{
                    game.setDice(currentGame.current.rolls,currentGame.current.keptDices)
                    game.setPickomino(currentGame.accessiblePickos())


                    var playerList = game.playerList()
                    var pickominoOfplayer = currentGame.pickosStackTops()
                    for ( numj in 0..playerList.size-1){
                        if (!playerList[numj].localPlayer && numj+1 != currentGame.current.player && pickominoOfplayer[numj] != 0)  playerList[numj].topPickominoIs(Pickomino(pickominoOfplayer[numj]))

                    }
                }
            //}
        }
    }

    /*
    fun updateLoop(){
        val timeline = Timeline(KeyFrame(Duration.seconds(1.0), { this.update() }))
        timeline.cycleCount = Animation.INDEFINITE
        timeline.play()
    }

*/
    fun keepDice(valeur : Int){
        val v = convertIntintoDice(valeur)
        if (v !in game.diceChosen){
            connect!!.keepDices(id!!,key!!,v)
        }

    }

    fun convertIntintoDice(valeur: Int) : DICE{
        when (valeur){
            1 -> return DICE.d1
            2 -> return DICE.d2
            3 -> return DICE.d3
            4 -> return DICE.d4
            5 -> return DICE.d5
            else -> return DICE.worm
        }
    }


}