package view.Home

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import view.Home.Center.CreateServer
import view.Home.Center.HomeCenter
import view.Home.Center.Menu
import view.Home.Center.Setting
import view.View
import view.components.TransparentButton
import java.io.FileInputStream

class HomeView: View() {
    var backButton : TransparentButton = TransparentButton("back")
    var homcenter : HomeCenter

    init  {
        val vbox = VBox()
        vbox.alignment = Pos.CENTER
        vbox.padding = Insets(10.0,10.0,10.0,10.0)
        vbox.children.add(backButton)

        this.top = vbox

        homcenter = Menu()

        this.center = homcenter

        val vbox2 = VBox()
        val image = ImageView((Image(FileInputStream("/home/E226752U/reseau/Perso/Documents/Kotlin/GrandProjet/14-sae-201-2023/src/main/kotlin/view/assets/sol.png"))))

        //image.scaleX = (0.5)
        image.fitWidth = 1100.0
        image.fitHeight = 100.0

        vbox2.alignment = Pos.BOTTOM_LEFT
        vbox2.children.add(image)
        this.bottom = vbox2

    }


    fun update(newhomecenter : HomeCenter){
        this.homcenter = newhomecenter
        this.center = homcenter

        if (newhomecenter.isMenu){
            this.top = VBox()
        }
        else{
            val vbox = VBox()
            vbox.alignment = Pos.CENTER
            vbox.padding = Insets(10.0,10.0,10.0,10.0)
            vbox.children.add(backButton)

            this.top = vbox
        }
    }
}