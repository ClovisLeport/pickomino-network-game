package view.components

import javafx.scene.control.Button
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontWeight

class WhiteButton (txt :String) :Button(){



    init {
        this.text = txt
        var helvetica = Font.loadFont("file:src/main/kotlin/view/fonts/helvetica/Helvetica-Bold.ttf",32.0)
        if (helvetica == null) println("La police de caractères n'a pas pu être chargée.") else{
            this.font  =helvetica
        }

        this.background = Background(BackgroundFill(Color.WHITE, CornerRadii(50.0), null))
        this.prefWidth = 200.0
        this.prefHeight = 25.0
    }


}