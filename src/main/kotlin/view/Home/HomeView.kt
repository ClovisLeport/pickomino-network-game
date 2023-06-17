package view.Home

import controleur.ControleurButtonBackHomeView
import controleur.Menu.PlayButton
import controleur.Menu.QuitButton
import controleur.Menu.RulesContoleur
import controleur.Menu.SettingsButton
import controleur.BindingFloor
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.Rectangle2D
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.shape.Arc
import javafx.scene.shape.ArcType
import javafx.stage.Screen
import javafx.stage.Stage
import view.Home.Center.CreateServer
import view.Home.Center.HomeCenter
import view.Home.Center.Menu
import view.Home.Center.Setting
import view.MainView
import view.View
import view.components.TransparentButton
import java.io.FileInputStream

class HomeView(stage: Stage,mainview: MainView): View() {
    var backButton : TransparentButton = TransparentButton("back")

    var mainview = mainview


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


        var playbut = PlayButton(mainview,this)
        var rulesbutt = RulesContoleur(this)
        var settingbutt = SettingsButton(this)
        var Quitbutt = QuitButton(this,stage)
        this.homcenter.fixeButton(arrayOf(playbut,rulesbutt,settingbutt,Quitbutt))

        this.center = homcenter

        val vbox2 = VBox()
        // Floor
        val screenBounds: Rectangle2D = Screen.getPrimary().bounds
        val screenWidth = screenBounds.width

        val radius = screenWidth / 2
        val arc = Arc(radius, 0.0, radius, 100.0, 0.0, 180.0)
        arc.type = ArcType.ROUND
        arc.fill = Color.web("#4DA35C")


        vbox2.alignment = Pos.BOTTOM_LEFT
        vbox2.children.add(arc)
        this.bottom = vbox2
        // Bind for the floor
        val bindingFloor = BindingFloor(arc)
        bindingFloor.bindArcWidthToStageWidth(stage.widthProperty())

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