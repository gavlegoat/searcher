import java.awt.{BorderLayout, Dimension, FlowLayout}

import javax.swing._

import scala.collection.mutable.ListBuffer


object CriteriaPanel extends JPanel {
  var pb = new JProgressBar(0, 100)
  pb.setValue(0)
  pb.setStringPainted(true)

  val usernamePanel = new JPanel()
  usernamePanel.setLayout(new FlowLayout())
  usernamePanel.add(new JLabel("Deckbox Username:"))
  val usernameField = new JTextField()
  usernameField.setColumns(20)
  usernamePanel.add(usernameField)
  add(usernamePanel)

  class Task(frame: JFrame) extends SwingWorker[Unit, Unit] {
    override def doInBackground(): Unit = {
      InventoryManager.loadCollection(usernameField.getText(), v => {
        setProgress(v)
      })
    }

    override def done(): Unit = {
      frame.dispose()
    }
  }

  setPreferredSize(new Dimension(300, 800))
  setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS))

  val usernameButton = new JButton("Load Collection")
  usernameButton.addActionListener(_ => {
    val pbFrame = new JFrame("Progress")
    pbFrame.setLayout(new BorderLayout())
    pbFrame.setLocationRelativeTo(null)
    pbFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE)
    pbFrame.add(pb, BorderLayout.CENTER)
    pbFrame.pack()
    pbFrame.setVisible(true)
    val task = new Task(pbFrame)
    task.addPropertyChangeListener(e => {
      if ("progress" == e.getPropertyName) {
        pb.setValue(e.getNewValue.asInstanceOf[Int])
      }
    })
    task.execute()
  })
  add(usernameButton)
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
