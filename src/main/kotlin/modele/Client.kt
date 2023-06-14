package modele

import iut.info1.pickomino.Connector
import java.security.cert.TrustAnchor

class Client(game: Game) {

    var id : Int? = null
    var key : Int? = null
    var connected : Boolean = false
    var connect : Connector? = null
    var game : Game = game


    fun CreateGame(){
        println("Hello students !!!")
        this.connect = Connector.factory("172.26.82.76", "8080")
        if (connect != null){
            println("Parties actives sur le serveur = ${connect!!.listOfGameIds()}")
            val identification = connect!!.newGame(3)
            this.id = identification.first
            this.key = identification.second

            game.addPlayer(Player(id!!,0,true))

            connected = true
        }
    }

    fun JoinGame(id:Int, key:Int){

        this.id = id
        this.key = key
        connected = true

    }

    fun StartGame(){
        if (connected && id != null && key != null && connect != null){

            game.addPlayer(Player(null,0,false))

            while (true){
                val currentGame = connect!!.gameState(this.id!!, this.key!!)




            }
        }
    }


}