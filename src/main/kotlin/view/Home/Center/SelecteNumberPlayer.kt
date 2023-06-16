package view.Home.Center

import javafx.geometry.Pos
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.paint.Color
import view.components.SmallTitle
import view.components.SubTitle
import view.components.Title
import view.components.WhiteButton
import javax.swing.ComboBoxEditor

class SelecteNumberPlayer(NumberPlayer : Int) : HomeCenter(false){

    val NumberPlayer = NumberPlayer

    init {
        val title = Title()
        val subTitle = SubTitle("Draw the worms from the dice !")
        val text = Label("with one play you want to be : ")
        text.textFill = Color.web("#FBFBF2")

        val Combobox = ComboBox<String>()

        for (i in 1..this.NumberPlayer){
            Combobox.items.add("Player N°$i")
        }

        val button = WhiteButton("Validate")

        this.alignment = Pos.CENTER
        this.maxWidth = 800.0

        this.spacing = 20.0

        this.children.addAll(title,subTitle,text,Combobox,button)

    }
}