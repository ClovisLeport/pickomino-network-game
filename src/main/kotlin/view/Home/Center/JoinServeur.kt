package view.Home.Center

import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.paint.Color
import view.components.SmallTitle
import view.components.SubTitle
import view.components.Title
import view.components.WhiteButton

class JoinServeur() : HomeCenter(false) {

    init {
        val title = Title()
        val subTitle = SubTitle("Draw the worms from the dice !")
        val textid = Label("What is the ID :")
        textid.textFill = Color.web("#FBFBF2")

        val textFilierid = TextField()

        val textkey = Label("What is the key :")
        textkey.textFill = Color.web("#FBFBF2")

        val textFilierkey = TextField()

        val button = WhiteButton("Validate")

        this.alignment = Pos.CENTER
        this.maxWidth = 800.0

        this.spacing = 20.0

        this.children.addAll(title,subTitle,textid,textFilierid,textkey,textFilierkey,button)

    }
}