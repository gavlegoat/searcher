import java.awt.{Dimension, FlowLayout}

import javax.swing._

import scala.collection.mutable.ListBuffer

object CriteriaPanel extends JPanel {
  setPreferredSize(new Dimension(300, 800))
  setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS))

  val usernamePanel = new JPanel()
  usernamePanel.setLayout(new FlowLayout())
  usernamePanel.add(new JLabel("Deckbox Username:"))
  val usernameField = new JTextField()
  usernameField.setColumns(20)
  usernamePanel.add(usernameField)
  add(usernamePanel)
  add(new JSeparator(SwingConstants.HORIZONTAL))

  var search_strings: ListBuffer[String] = ListBuffer()

  def addRow(disp: String, search: String): Unit = {
    val newPanel = new JPanel()
    newPanel.setLayout(new FlowLayout(FlowLayout.LEFT))
    newPanel.add(new JLabel(disp))
    val removeButton = new JButton("Remove")
    removeButton.addActionListener(_ => {
      remove(newPanel)
      search_strings -= search
      validate()
      repaint()
    })
    newPanel.add(removeButton)
    add(newPanel)
    validate()
    repaint()
    search_strings += search
  }

  def createQuery(): String = {
    search_strings.mkString(" ")
  }
}
