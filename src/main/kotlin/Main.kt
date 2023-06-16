import iut.info1.pickomino.data.Game
import controleur.Menu.PlayButton
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage
import view.Home.Center.*
import view.Home.HomeView
import view.MainView
import view.game.GameView

class Main : Application() {
    val vue = HomeView()
    override fun start(primaryStage: Stage) {

        val vue = HomeView()
        vue.update(Menu())

        // Initialisation de l'interface utilisateur et des composants JavaFX
        val scene = Scene(vue, 600.0, 400.0)

        primaryStage.minWidth = 1100.0 // Définir une largeur minimale de 600 pixels
        primaryStage.minHeight = 700.0 // Définir une hauteur minimale de 400 pixels

        var playbut = PlayButton(vue)

        vue.homcenter.fixeButton(arrayOf(playbut,playbut,playbut,playbut))


//        // FullScreen
//        primaryStage?.apply {
//            // Mettez la scène en plein écran
//            isFullScreen = true
//            this.scene = scene
//            show()
//        }

        //ajout de l'icone de page
        val iconPath = "file:src/main/kotlin/view/assets/Logo.png" // Spécifiez le chemin vers votre icône
        val icon = Image(iconPath)

        primaryStage.icons.add(icon)

        primaryStage.title = "Pikomino"
        primaryStage.scene = scene

        // Affichez la scène sur la fenêtre principale
        primaryStage?.show()
    }
}

fun main() {

    /*
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
    // println(connect.keepDices(id,key, DICE.d1))
    //println(connect.takePickomino(id,key, 21))

    currentGame = connect.gameState(id, key)
    println("Nouvelle partie = $currentGame")
    println("pichomins en cour = ${currentGame.accessiblePickos()}")
    println("score en cour = ${currentGame.score()}")
    */
    // Lancement de la vue
    Application.launch(Main::class.java)

}