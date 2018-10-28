import java.awt.FlowLayout
import java.text.NumberFormat

import javax.swing._

object PriceSelector extends JPanel {
  setLayout(new FlowLayout(FlowLayout.LEFT))

  val currencies = Array("USD", "Euros", "MTGO Tix")
  val codes = Array("usd", "eur", "tix")
  val choice = new JComboBox(currencies)
  choice.setSelectedIndex(0)

  add(choice)
  add(new JLabel("From:"))

  //val minField = new JFormattedTextField(NumberFormat.getNumberInstance())
  val minField = new JTextField()
  minField.setColumns(7)
  add(minField)

  add(new JLabel("To:"))

  //val maxField = new JFormattedTextField(NumberFormat.getNumberInstance())
  val maxField = new JTextField()
  maxField.setColumns(7)
  add(maxField)

  def createQuery(): String = {
    val minStr = if (minField.getText() != "")
      codes(choice.getSelectedIndex) + ">=" + minField.getText()
     else ""
    val maxStr = if (maxField.getText() != "")
      codes(choice.getSelectedIndex) + "<=" + maxField.getText()
     else ""
    if (minStr == "") maxStr else
      if (maxStr == "") minStr else minStr + " " + maxStr
  }
}
