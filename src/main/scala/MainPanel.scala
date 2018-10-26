import java.awt.Component
import java.awt.GridLayout
import javax.swing._

object MainPanel extends JPanel {
  val labelWidth = 100
  val inputWidth = 500
  val rowHeight = 30

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
    "Type Line:", "Colors:", "Color ID:", "Mana Cost:", "Stats:", "Format Legality:",
    "Set:", "Block:", "Rarity:", "Price:", "Artist:", "Flavor Text:")

  setLayout(new GridLayout(0, 2))

  (fields zip labels).foreach(pair => {
    add(new JLabel(pair._2))
    add(pair._1)
  })

  val submit = new JButton("Submit")
  // TODO: Add an ActionListener
  add(new JLabel(""))
  add(submit)

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
