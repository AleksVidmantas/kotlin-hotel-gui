import javafx.application.Application
import tornadofx.*

class MyApp: App(MyView::class)

class MyView : View() {

    val controller: MyController by inject()

    override val root = vbox {

        label("Input")

        val inputField = textfield()

        button("Commit") {
            action {
                controller.writeToDb(inputField.text)
                inputField.clear()
            }
        }
    }
}


class MyController: Controller() {
    fun writeToDb(inputValue: String) {
        println("Writing $inputValue to database!")
    }
}

fun main(args: Array<String>) {
    Application.launch(MyApp::class.java, *args)
}