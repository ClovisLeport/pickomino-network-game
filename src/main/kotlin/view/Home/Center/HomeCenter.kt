package view.Home.Center

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

abstract class HomeCenter(isMenu : Boolean): VBox() {

    val isMenu = isMenu
    abstract fun fixeButton(listControleur:Array<EventHandler<ActionEvent>>)
}