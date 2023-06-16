package controleur

import iut.info1.pickomino.Connector
import javafx.event.ActionEvent
import javafx.event.EventHandler
import view.Home.Center.JoinServeur
import view.Home.Center.SelecteNumberPlayer
import view.Home.HomeView
import view.MainView
import java.lang.Exception

class ControleurButtonAcceptInJoinPartyPage(vue : HomeView, Mainvue: MainView) : EventHandler<ActionEvent> {

    val vue = vue
    val Mainvue = Mainvue
    override fun handle(event: ActionEvent?) {
        val acctualPage = vue.homcenter as JoinServeur


        try{
            val id = acctualPage.textFilierid.text.toInt()
            val key = acctualPage.textFilierkey.text.toInt()

            val connect = Connector.factory("172.26.82.76", "8080")
            var currentGame = connect.gameState(id, key)

            val NewPage = SelecteNumberPlayer((currentGame.accessiblePickos().size))
            NewPage.fixeButton(arrayOf(ControleurLancerPartie(Mainvue)))
            vue.update(NewPage)
        } catch (e : Exception){
            //boite de dialogue
        }


    }
}