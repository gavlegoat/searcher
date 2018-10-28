import java.awt.FlowLayout

import javax.swing._

object RaritySelector extends JPanel {
  setLayout(new FlowLayout(FlowLayout.LEFT))
  val mythicBox = new JCheckBox("Mythic")
  val rareBox = new JCheckBox("Rare")
  val uncommonBox = new JCheckBox("Uncommon")
  val commonBox = new JCheckBox("Common")

  add(mythicBox)
  add(rareBox)
  add(uncommonBox)
  add(commonBox)

  val boxes = List(mythicBox, rareBox, uncommonBox, commonBox)
  val strings = List("m", "r", "u", "c")

  def createQuery(): String = {
    (boxes zip strings).filter(pair => {
      pair._1.isSelected
    }).map(pair => {
      "r:" + pair._2
    }).mkString(" or ")
  }
}
