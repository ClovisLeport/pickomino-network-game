package view.Home.Center

import javafx.scene.layout.VBox
import javafx.scene.text.Text
import view.components.Title
import view.components.TransparentButton

class Setting :HomeCenter() {
    var vbox : VBox = VBox()
    var title = Text()

    init {
        var back = TransparentButton("Back")
        var titre = Title()
        this.children.addAll(back,titre)
    }
}