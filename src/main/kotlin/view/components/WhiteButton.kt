package view.components

import javafx.beans.property.SimpleDoubleProperty
import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontWeight

class WhiteButton (txt :String) :Button(){

    var policeheight = SimpleDoubleProperty( 20.0)
    var TopPadding = SimpleDoubleProperty( 20.0)
    var BottomPadding = SimpleDoubleProperty( 20.0)
    var LeftPadding = SimpleDoubleProperty( 20.0)
    var Rightpadding = SimpleDoubleProperty( 20.0)


    init {
        this.text = txt

        var helvetica = Font.loadFont("file:src/main/kotlin/view/fonts/helvetica/Helvetica-Bold.ttf",policeheight.value)
        if (helvetica == null) println("La police de caractères n'a pas pu être chargée.") else{
            this.font  =helvetica
        }

        this.background = Background(BackgroundFill(Color.WHITE, CornerRadii(50.0), null))
        this.padding = Insets(12.0,10.0,10.0,12.0)
        this.prefWidth = 200.0
        this.prefHeight = 25.0
    }


}