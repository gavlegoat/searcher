import java.awt.FlowLayout

import javax.swing._

class ColorSelector extends JPanel {
  setLayout(new FlowLayout(FlowLayout.LEFT))

  val constraintTypes = Array("Exactly", "Including", "At Most")
  val typeBox = new JComboBox(constraintTypes)
  add(typeBox)

  val wBox = new JCheckBox("White")
  add(wBox)

  val uBox = new JCheckBox("Blue")
  add(uBox)

  val bBox = new JCheckBox("Black")
  add(bBox)

  val rBox = new JCheckBox("Red")
  add(rBox)

  val gBox = new JCheckBox("Green")
  add(gBox)

  val boxToCode: Seq[(JCheckBox, String)] =
    List(wBox, uBox, bBox, rBox, gBox) zip List("w", "u", "b", "r", "g")

  def createQuery(code: String): String = {
    val colStr = boxToCode.map(pair => {
      if (pair._1.isSelected) pair._2 else ""
    }).mkString("")
    if (colStr == "") {
      ""
    } else {
      typeBox.getSelectedIndex match {
        case 0 => code + "=" + colStr
        case 1 => code + ">=" + colStr
        case _ => code + "<=" + colStr
      }
    }
  }
}
