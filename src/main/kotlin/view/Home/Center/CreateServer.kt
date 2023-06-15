package view.Home.Center

import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.Slider
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.paint.Color
import view.components.SmallTitle
import view.components.SubTitle
import view.components.Title
import view.components.WhiteButton

class CreateServer :HomeCenter(){

    init {
        val title = Title()
        val subTitle = SubTitle("Draw the worms from the dice !")
        val text = Label("How many players at most")

        text.textFill = Color.web("#FBFBF2")

        var hbox = HBox()
        val input = Slider(2.0,4.0,2.0)
        input.prefWidth = 400.0
        //input.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE)
        val nombre = Label("2")
        nombre.textFill = Color.web("#FBFBF2")
        hbox.children.add(input)
        hbox.children.add(nombre)
        hbox.alignment = Pos.CENTER

        val button = WhiteButton("Validate")

        this.alignment = Pos.CENTER
        this.maxWidth = 800.0

        this.spacing = 20.0

        this.children.add(title)
        this.children.add(subTitle)
        this.children.add(text)
        this.children.add(hbox)
        this.children.add(button)
    }
}