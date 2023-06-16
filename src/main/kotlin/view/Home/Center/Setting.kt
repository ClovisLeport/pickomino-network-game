package view.Home.Center

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import view.components.Title
import view.components.TransparentButton

class Setting :HomeCenter(false) {
    var vbox : VBox = VBox()
    var title = Text()

    init {
        var back = TransparentButton("Back")
        var titre = Title()
        this.children.addAll(back,titre)
    }
    override fun fixeButton(listControleur: Array<EventHandler<ActionEvent>>) {
        TODO("Not yet implemented")
    }
}