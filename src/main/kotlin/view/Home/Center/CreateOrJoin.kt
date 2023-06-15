package view.Home.Center

import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.paint.Color
import view.components.SubTitle
import view.components.Title
import view.components.WhiteButton

class CreateOrJoin() : HomeCenter() {

    init {
        val title = Title()
        val subTitle = SubTitle("Draw the worms from the dice !")


        val buttonCreate = WhiteButton("Create a server")
        val ButtonJoin = WhiteButton("Join a server")

        this.alignment = Pos.CENTER
        this.maxWidth = 800.0

        this.spacing = 20.0

        this.children.addAll(title, subTitle, buttonCreate, ButtonJoin)
    }
}