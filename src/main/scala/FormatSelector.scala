import java.awt.FlowLayout

import javax.swing._

object FormatSelector extends JPanel {
  setLayout(new FlowLayout(FlowLayout.LEFT))

  val legalities = Array("Legal", "Banned", "Restricted")
  val legalityBox = new JComboBox(legalities)
  add(legalityBox)

  val formats = Array("--", "Standard", "Modern", "Legacy", "Vintage",
    "Commander", "Pauper", "Frontier")
  val formatBox = new JComboBox(formats)
  add(formatBox)

  def createQuery(): String = {
    if (formatBox.getSelectedIndex == 0) {
      ""
    } else {
      val form = formatBox.getSelectedItem.toString.toLowerCase()
      legalityBox.getSelectedIndex match {
        case 0 => "f:" + form
        case 1 => "banned:" + form
        case _ => "restricted:" + form
      }
    }
  }
}
