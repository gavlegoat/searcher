import javax.swing._

object Main {

  val frame = new JFrame("Search Your Collection")

  def main(args: Array[String]): Unit = {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setSize(MainPanel.getSize())
    frame.setResizable(false)
    frame.setLocationRelativeTo(null)
    frame.add(MainPanel)
    frame.setVisible(true)
  }
}
