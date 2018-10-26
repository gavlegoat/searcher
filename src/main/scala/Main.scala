import java.awt.event.ActionEvent

import javax.swing._

object Main {
  def main(args: Array[String]): Unit = {
    val frame = new JFrame()
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setSize(200, 200)
    frame.setLocationRelativeTo(null)
    val button = new JButton("Quit")
    button.addActionListener((e: ActionEvent) => System.exit(0))
    frame.add(button)
    frame.setVisible(true)
  }
}
