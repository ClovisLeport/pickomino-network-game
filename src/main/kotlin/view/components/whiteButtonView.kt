package view.components

import javafx.scene.control.Button
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color

class whiteButtonView (txt :String){

    var  whiteButton : Button

    init {
        this.whiteButton = Button(txt)
        this.whiteButton.background = Background(BackgroundFill(Color.YELLOW, CornerRadii(10.0), null))


        this.whiteButton.prefWidth = 120.0
        this.whiteButton.prefHeight = 60.0
    }


}