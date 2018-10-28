import java.awt.{BorderLayout, Component, FlowLayout, GridLayout}

import javax.swing._

object MainPanel extends JPanel {
  def addCode(c: String, inp: String): String = {
    inp.split("\\s+(?=(?:[^\"]*\"[\"]*\")*[^\"]*$)").filter(_ != "")
      .map(c + ":" + _).mkString(" ")
  }

  def createQuery(): String = {
    val strs = Array(
      scryfall.getText(),
      nameField.getText(),
      addCode("o", oracleField.getText()),
      TypeSelector.createQuery(),
      colors.createQuery("color"),
      colorID.createQuery("id"),
      if (manaField.getText() == "") "" else "mana:" + manaField.getText(),
      StatSelector.createQuery(),
      FormatSelector.createQuery(),
      if (set.getText() == "") "" else "e:" + set.getText(),
      if (block.getText() == "") "" else "b:" + block.getText(),
      RaritySelector.createQuery(),
      PriceSelector.createQuery(),
      addCode("a", artistField.getText()),
      addCode("ft", flavorField.getText()))
    strs.filter(_ != "").map("(" + _ + ")").mkString(" ")
  }

  setSize(900, 800)

  val scryfall = new JTextField()
  val nameField = new JTextField()
  val oracleField = new JTextField()
  // use TypeSelector
  val colors = new ColorSelector()
  val colorID = new ColorSelector()
  val manaField = new JTextField()
  // use StatSelector
  // use FormatSelector
  val set = new JTextField()
  val block = new JTextField()
  // use RaritySelector
  // use PriceSelector
  val artistField = new JTextField()
  val flavorField = new JTextField()

  val fields: Seq[Component] = List(scryfall, nameField, oracleField,
    TypeSelector, colors, colorID, manaField, StatSelector, FormatSelector, set,
    block, RaritySelector, PriceSelector, artistField, flavorField)

  val labels: Seq[String] = List("Formatted Search:", "Name:", "Oracle Text:",
    "Type Line:", "Colors:", "Color ID:", "Pips:", "Stats:",
    "Format Legality:", "Set:", "Block:", "Rarity:", "Price:", "Artist:",
    "Flavor Text:")

  //setLayout(new GridLayout(0, 2, 30, 20))

  val leftPanel = new JPanel(new GridLayout(0, 1, 30, 20))
  val rightPanel = new JPanel(new GridLayout(0, 1, 30, 20))

  (fields zip labels).foreach(pair => {
    leftPanel.add(new JLabel(pair._2, SwingConstants.RIGHT))
    rightPanel.add(pair._1)
  })

  val submit = new JButton("Submit")
  submit.addActionListener(_ => {
    System.out.println("<<< " + createQuery() + " >>>")
  })

  setLayout(new BorderLayout(30, 20))
  add(leftPanel, BorderLayout.WEST)
  add(rightPanel, BorderLayout.CENTER)
  add(CriteriaPanel, BorderLayout.EAST)
  add(submit, BorderLayout.SOUTH)
}
