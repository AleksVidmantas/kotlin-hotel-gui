
import javafx.application.Application
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import tornadofx.App


import tornadofx.View

class MyApp: App(MyView::class)

class MyView: View() {

    val topView: TopView by inject()
    val bottomView: BottomView by inject()

    override val root = BorderPane()

    init {
        with(root){
            top = topView.root
            bottom = bottomView.root
        }

    }

}

fun main(args: Array<String>) {
    Application.launch(MyApp::class.java, *args)
}

class TopView: View(){
    override val root = Label("Top View")
}
class BottomView: View(){
    override val root = Label("Bottom View")
}