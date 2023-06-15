package view

import javafx.scene.layout.BorderPane
import view.Home.HomeView
import view.game.GameView
import view.Home.Center.HomeCenter
import view.Home.Center.Menu


class MainView(): BorderPane() {
    var view : View

    init {
        this.view = HomeView()
        this.center = view
    }

    fun updateView(newview :View){

        this.view = newview
        this.center = view
    }

}