package view.Home

import controleur.ControleurButtonBackHomeView
import controleur.Menu.PlayButton
import controleur.Menu.QuitButton
import controleur.Menu.RulesContoleur
import controleur.Menu.SettingsButton
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import javafx.stage.Stage
import view.Home.Center.CreateServer
import view.Home.Center.HomeCenter
import view.Home.Center.Menu
import view.Home.Center.Setting
import view.View
import view.components.TransparentButton
import java.io.FileInputStream

class HomeView(stage: Stage): View() {
    var backButton : TransparentButton = TransparentButton("back")
    var homcenter : HomeCenter
    var historyofHomeCenter = mutableListOf<HomeCenter>()
    var stage = stage
    private var vbox : VBox

    init  {
        this.vbox = VBox()
        vbox.alignment = Pos.CENTER
        vbox.padding = Insets(10.0,10.0,10.0,10.0)

        backButton.onAction = ControleurButtonBackHomeView(this)

        vbox.children.add(backButton)

        homcenter = Menu()


        var playbut = PlayButton(this)
        var rulesbutt = RulesContoleur(this)
        var settingbutt = SettingsButton(this)
        var Quitbutt = QuitButton(this,stage)
        this.homcenter.fixeButton(arrayOf(playbut,rulesbutt,settingbutt,Quitbutt))

        this.center = homcenter

        val vbox2 = VBox()
        val image = ImageView((Image(FileInputStream("src/main/kotlin/view/assets/sol.png"))))

        //image.scaleX = (0.5)
        image.fitWidth = 1100.0
        image.fitHeight = 100.0

        vbox2.alignment = Pos.BOTTOM_LEFT
        vbox2.children.add(image)
        this.bottom = vbox2


    }


    fun update(newhomecenter : HomeCenter){
        historyofHomeCenter.add(this.homcenter)
        this.homcenter = newhomecenter

        this.center = homcenter

        if (newhomecenter.isMenu){
            this.top = VBox()
        }
        else{


            this.top = vbox
        }
    }

    fun Goback(){
        if (historyofHomeCenter.size >= 1){
            update(historyofHomeCenter[historyofHomeCenter.size-1])
            historyofHomeCenter.removeAt(historyofHomeCenter.size-1)
            historyofHomeCenter.removeAt(historyofHomeCenter.size-1)
        }
    }
}