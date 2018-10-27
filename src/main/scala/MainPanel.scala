import java.awt.{BorderLayout, Component, FlowLayout, GridLayout}

import javax.swing._

object MainPanel extends JPanel {
  setSize(1000, 800);

  val scryfall = new JTextField()
  val nameField = new JTextField()
  val oracleField = new JTextField()
  val typeField = new JTextField()
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

  val fields: Seq[Component] = List(scryfall, nameField, oracleField, typeField,
    colors, colorID, manaField, StatSelector, FormatSelector, set, block,
    RaritySelector, PriceSelector, artistField, flavorField)

  val labels: Seq[String] = List("Formatted Search:", "Name:", "Oracle Text:",
    "Type Line:", "Colors:", "Color ID:", "Mana Cost:", "Stats:",
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
  // TODO: Add an ActionListener

  setLayout(new BorderLayout(30, 20))
  add(leftPanel, BorderLayout.WEST)
  add(rightPanel, BorderLayout.CENTER)
  add(submit, BorderLayout.SOUTH)

  def createQuery(): String = {
    if (scryfall.getText().equals("")) {
      // Use the advanced search fields
      // TODO
      "not implemented"
    } else {
      // Use the given formatted query
      scryfall.getText()
    }
  }
}
