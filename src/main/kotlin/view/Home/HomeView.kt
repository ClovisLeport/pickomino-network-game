package view.Home

import javafx.geometry.Pos
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import view.Home.Center.CreateServer
import view.Home.Center.HomeCenter
import view.Home.Center.Menu
import view.Home.Center.Setting
import view.View
import view.components.TransparentButton

class HomeView: View() {
    var backButton : TransparentButton = TransparentButton("back")
    var homcenter : HomeCenter

    init  {
        backButton.alignment = Pos.CENTER
        this.top = backButton

        homcenter = Menu()

        this.center = homcenter
    }


    fun update(newhomecenter : HomeCenter){
        this.homcenter = newhomecenter
        this.center = homcenter
    }
}