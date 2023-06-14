import iut.info1.pickomino.Connector
import iut.info1.pickomino.data.DICE


fun main() {
    println("Hello students !!!")
    val connect = Connector.factory("172.26.82.76", "8080")
    println("Parties actives sur le serveur = ${connect.listOfGameIds()}")
    //val identification = connect.newGame(3)
    //val id = identification.first
    //val key = identification.second
    val id = 1592
    val key = 284
    var currentGame = connect.gameState(id, key)

    println("Nouvelle partie = $currentGame")
    println("pichomins en cour = ${currentGame.accessiblePickos()}")
    println("score en cour = ${currentGame.score()}")

    println("$id, $key")
    //println(connect.rollDices(id, key))
    println(connect.keepDices(id,key, DICE.d1))
    //println(connect.takePickomino(id,key, 21))

    currentGame = connect.gameState(id, key)
    println("Nouvelle partie = $currentGame")
    println("pichomins en cour = ${currentGame.accessiblePickos()}")
    println("score en cour = ${currentGame.score()}")


}