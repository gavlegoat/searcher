import java.awt.FlowLayout
import java.awt.event.ActionEvent
import java.text.NumberFormat

import javax.swing._

object StatSelector extends JPanel {
  setLayout(new FlowLayout(FlowLayout.LEFT))

  val stats = Array("CMC", "Power", "Toughness", "Loyalty")
  val codes = Array("cmc", "pow", "tou", "loy")
  val typeBox = new JComboBox(stats)
  add(typeBox)

  val comparison = Array("<", ">", "<=", ">=", "=", "!=")
  val compBox = new JComboBox(comparison)
  add(compBox)

  //val numField = new JFormattedTextField(NumberFormat.getNumberInstance())
  val numField = new JTextField()
  numField.setColumns(7)
  add(numField)

  val addButton = new JButton("Add")
  addButton.addActionListener(_ => {
    val search = codes(typeBox.getSelectedIndex) + compBox.getSelectedItem +
      numField.getText()
    val disp = stats(typeBox.getSelectedIndex) + compBox.getSelectedItem +
      numField.getText()
    CriteriaPanel.addRow(disp, search)
  })
  add(addButton)

  def createQuery(): String = {
    val critStr = CriteriaPanel.createQuery()
    val thisStr = if (numField.getText() == "") ""
       else codes(typeBox.getSelectedIndex) + compBox.getSelectedItem +
        numField.getText()
    if (critStr == "") thisStr else critStr + " " + thisStr
  }
}
