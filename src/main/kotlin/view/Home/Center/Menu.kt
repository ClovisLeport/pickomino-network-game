package view.Home.Center

import javafx.scene.layout.VBox
import javafx.scene.text.Text

class Menu :HomeCenter() {

    var vbox = VBox()
    var title = Text()
    init {
        println("sasas")
        title.text = "Pickomino"
        vbox.getChildren().addAll(title)
    }
}