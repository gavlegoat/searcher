import java.awt._
import javax.swing._

object Main {

  val frame = new JFrame()

  def main(args: Array[String]): Unit = {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    //frame.setExtendedState(JFrame.MAXIMIZED_BOTH)
    // For some reason it looks like MAXIMIZED_BOTH is not being recognized
    // as a member of JFrame
    frame.setSize(new Dimension(1000, 800));
    frame.setLocationRelativeTo(null)
    frame.add(MainPanel)
    frame.setVisible(true)
  }
}
