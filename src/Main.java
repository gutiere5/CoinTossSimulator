import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.border.EmptyBorder;


public class Main extends JFrame implements  ActionListener  {
	private int headsCount = 0;
	private int tailsCount = 0;
	private JLabel resultLabel;
	private JLabel statsLabel;
	private JLabel coinSetLabel;
	private JButton tossButton;
	private JButton resetButton;
    private JComboBox<String> coinSetComboBox;
	private ImageIcon headsIcon;
	private ImageIcon tailsIcon;
	

	public Main()  {
		// Set up the frame
		setTitle("Coin Toss Simulator");
		setSize(450, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// Set background color for the frame
		getContentPane().setBackground(new Color(60, 63, 65));

		// Set up the result label
		resultLabel = new JLabel("", SwingConstants.CENTER);
		resultLabel.setPreferredSize(new Dimension(200, 200));
		resultLabel.setOpaque(true);
        resultLabel.setBackground(new Color(43, 43, 43));

		// Set up the statistics label
		statsLabel = new JLabel("Heads: 0, Tails: 0", SwingConstants.CENTER);
		statsLabel.setForeground(Color.WHITE);
		
		// Setting up label for "Choose Coin Set" 
		coinSetLabel =  new JLabel("Choose Coin Set:");
		coinSetLabel.setForeground(Color.WHITE);
		
		// Set up the button to toss the coin
		tossButton = new JButton("Toss the Coin");
		tossButton.addActionListener(this);
		
		// Set up the reset button
		resetButton = new JButton("Reset Stats");
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetStatitics();
			}
		});
		
		styleButton(resetButton);
		
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
        
        styleComboBox(coinSetComboBox);


        // Add components to the frame
        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(new Color(60, 63, 65));
        controlPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        controlPanel.add(coinSetLabel);
        controlPanel.add(coinSetComboBox);
        controlPanel.add(tossButton);
        controlPanel.add(resetButton);

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
	 
	 private void resetStatitics() {
		 headsCount = 0;
		 tailsCount = 0;
		 statsLabel.setText("Heads: 0, Tails: 0");
		 resultLabel.setIcon(null);
	 }
	 
	 private void styleButton(JButton button) {
	        button.setBackground(new Color(75, 110, 175));
	        button.setForeground(Color.WHITE);
	        button.setFocusPainted(false);
	        button.setFont(new Font("Arial", Font.BOLD, 12));
	    }

	    private void styleComboBox(JComboBox<String> comboBox) {
	        comboBox.setBackground(new Color(75, 110, 175));
	        comboBox.setForeground(Color.WHITE);
	        comboBox.setFont(new Font("Arial", Font.BOLD, 12));
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

