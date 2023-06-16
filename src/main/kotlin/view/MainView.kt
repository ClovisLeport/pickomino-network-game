package view

import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import view.Home.HomeView
import view.game.GameView
import view.Home.Center.HomeCenter
import view.Home.Center.Menu


class MainView(stage: Stage): BorderPane() {
    var view : View
    var stage = stage
    init {
        this.view = HomeView(stage)
        this.center = view
    }

    fun updateView(newview :View){

        this.view = newview
        this.center = view
    }

}