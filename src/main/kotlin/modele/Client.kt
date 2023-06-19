package modele

import iut.info1.pickomino.Connector
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

    var canPlay = false



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

    fun StartGame(){
        if (connected != null && id != null && key != null && connect != null){
            canPlay = false

            //while (true){
                var currentGame = connect!!.gameState(this.id!!, this.key!!)

                var ActualStatu =  currentGame.current.status

                if (currentGame.current.player == game.numérojoueur){
                    canPlay = true
                    //game.taketurns(ActualStatu)
                }
                else{
                    game.setDice(currentGame.current.rolls,currentGame.current.keptDices)
                    game.setPickomino(currentGame.accessiblePickos())


                    var playerList = game.playerList()
                    var pickominoOfplayer = currentGame.pickosStackTops()
                    for ( numj in 0..playerList.size-1){
                        if (!playerList[numj].localPlayer && numj+1 != currentGame.current.player)  playerList[numj].topPickominoIs(Pickomino(pickominoOfplayer[numj]))

                    }
                }
            //}
        }
    }

    fun updateLoop(){
        val timeline = Timeline(KeyFrame(Duration.seconds(1.0), { this.StartGame() }))
        timeline.cycleCount = Animation.INDEFINITE
        timeline.play()
    }



}