package view.Home.Center

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.Slider
import javafx.scene.control.TextField
import view.components.SmallTitle
import view.components.WhiteButton

class CreateServer :HomeCenter(){

    init {
        val subTitle = SmallTitle("Draw the worms from the dice !")
        val text = Label("How many players at most")

        val input = Slider(2.0,4.0,2.0)

        val button = WhiteButton("Validate")


        this.children.add(subTitle)
        this.children.add(text)
        this.children.add(input)
        this.children.add(button)
    }
}