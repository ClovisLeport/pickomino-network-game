package controleur

import iut.info1.pickomino.Connector
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Alert
import view.Home.Center.CreateServer
import view.Home.Center.JoinServeur
import view.Home.Center.SelecteNumberPlayer
import view.Home.HomeView
import view.MainView
import java.lang.Exception

class ControleurButtonAccept(vue : HomeView, Mainvue: MainView) : EventHandler<ActionEvent> {

    val vue = vue
    val Mainvue = Mainvue
    override fun handle(event: ActionEvent?) {
        try{
            val acctualPage = vue.homcenter as JoinServeur

            try{
                val id = acctualPage.textFilierid.text.toInt()
                val key = acctualPage.textFilierkey.text.toInt()

                val connect = Connector.factory("172.26.82.76", "8080")
                var currentGame = connect.gameState(id, key)

                val NewPage = SelecteNumberPlayer((currentGame.pickosStackTops().size),false,id, key)
                NewPage.fixeButton(arrayOf(ControleurLancerPartie(vue,Mainvue)))
                vue.update(NewPage)
            } catch (e : Exception){
                val dialog = Alert(Alert.AlertType.INFORMATION)
                dialog.title="Error"
                dialog.headerText="les clés choisies ne sont pas correcte"
                dialog.showAndWait()
            }
        }catch (e : Exception){
            val acctualPage = vue.homcenter as CreateServer

            val NewPage = SelecteNumberPlayer((acctualPage.nombre.text.toInt()),true,null,null)
            NewPage.fixeButton(arrayOf(ControleurLancerPartie(vue,Mainvue)))
            vue.update(NewPage)

        }



    }
}