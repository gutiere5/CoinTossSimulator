import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Main extends JFrame implements  ActionListener  {
	private int headsCount = 0;
	private int tailsCount = 0;
	private JLabel resultLabel;
	private JLabel statsLabel;
	private JButton tossButton;
    private JComboBox<String> coinSetComboBox;
	private ImageIcon headsIcon;
	private ImageIcon tailsIcon;

	public Main()  {
		// Set up the frame
		setTitle("Coin Toss Simulator");
		setSize(400, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Set up the result label
		resultLabel = new JLabel("", SwingConstants.CENTER);
		resultLabel.setPreferredSize(new Dimension(200, 200));

		// Set up the statistics label
		statsLabel = new JLabel("Heads: 0, Tails: 0", SwingConstants.CENTER);

		// Set up the button
		tossButton = new JButton("Toss the Coin");
		tossButton.addActionListener(this);

        // Set up the coin set combo box
		String[] coinSets = { "default", "coin1", "coin2" }; 
        coinSetComboBox = new JComboBox<>(coinSets);
        coinSetComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCoinSet = (String) coinSetComboBox.getSelectedItem();
                loadCoinImages(selectedCoinSet);
            }
        });

        // Add components to the frame
        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Choose Coin Set:"));
        controlPanel.add(coinSetComboBox);
        controlPanel.add(tossButton);

        add(statsLabel, BorderLayout.NORTH);
        add(resultLabel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        // Load default coin images
        loadCoinImages("default");
	}
	
	 private void loadCoinImages(String coinSet) {
	        try {
	            headsIcon = new ImageIcon(coinSet + "/heads.png");
	            tailsIcon = new ImageIcon(coinSet + "/tails.png");
	            resultLabel.setIcon(null);  // Clear previous result image
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(this, "Error loading coin images. Please select a valid coin set.");
	        }
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Random random = new Random();
		int randomNumber = random.nextInt(2);
		if (randomNumber == 1) {
			resultLabel.setIcon(tailsIcon);
			tailsCount++;
		} else {
			resultLabel.setIcon(headsIcon);
			headsCount++;
		}
		statsLabel.setText("Heads: " + headsCount + ", Tails: " + tailsCount);

	}

	public static void main(String[] args) {
		Main mainGUI = new Main();
		mainGUI.setVisible(true);
	}
}

