import java.awt.{BorderLayout, FlowLayout}

import javax.swing.{JCheckBox, JPanel, JTextField}

object TypeSelector extends JPanel {
  setLayout(new BorderLayout())

  val textField = new JTextField()
  add(textField, BorderLayout.CENTER)

  val checkBoxPanel = new JPanel()
  checkBoxPanel.setLayout(new FlowLayout())

  val partialBox = new JCheckBox("Partial Match")
  checkBoxPanel.add(partialBox, BorderLayout.EAST)

  val commanderBox = new JCheckBox("Commander")
  checkBoxPanel.add(commanderBox, BorderLayout.EAST)

  add(checkBoxPanel, BorderLayout.EAST)

  def createQuery(): String = {
    (if (commanderBox.isSelected) "is:commander " else "") +
      (if (partialBox.isSelected) MainPanel.addCode("t", textField.getText)
        .split("\\s").mkString(" or ")
       else MainPanel.addCode("t", textField.getText))
  }
}
