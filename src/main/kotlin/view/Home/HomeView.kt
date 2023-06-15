package view.Home

import javafx.scene.layout.VBox
import javafx.scene.text.Text
import view.Home.Center.HomeCenter
import view.Home.Center.Menu
import view.Home.Center.Setting
import view.View

class HomeView: View() {
    var homcenter : HomeCenter

    init  {
        homcenter = Setting()
        this.center = homcenter
    }


    fun update(newhomecenter : HomeCenter){
        this.homcenter = newhomecenter
        this.center = homcenter
    }
}