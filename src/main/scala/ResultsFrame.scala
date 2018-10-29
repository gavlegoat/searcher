import javax.swing.JFrame

class ResultsFrame(query: String, username: String) extends JFrame {
  setTitle("Results for search: " + query)
  setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE)
  setSize(900, 800)
  setResizable(false)

  // TODO: Build results list

  // The top if this frame should have a panel with some display options. For
  // example you can choose to display card images or only names. The rest of
  // the frame should be devoted to the results.
  // TODO: Controls

  // TODO: Results
}
