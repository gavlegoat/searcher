import java.awt._
import javax.swing._

object Main {

  val frame = new JFrame()

  def main(args: Array[String]): Unit = {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setSize(MainPanel.getSize())
    frame.setLocationRelativeTo(null)
    frame.add(MainPanel)
    frame.setVisible(true)
  }
}
