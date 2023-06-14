package view

import javafx.scene.layout.BorderPane
import view.Home.HomeView

class MainView(): BorderPane() {
    var view : View

    init {
        view = HomeView()
        this.center = view
    }

}