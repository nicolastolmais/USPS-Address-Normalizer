package edu.truman.cs370.team5;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
/**
 * @author Stephanie Parkhurst and Alexis Carroll
 * Main program with the user interface.
 */
public class GUI 
{
	private static JFrame frame;
	private static JPanel singlePanel;
	private static JPanel singleInputPanel;
	private static JPanel singleOutputPanel; 
	private static JPanel batchPanel;
	private static JPanel radioPanel;
	
	private static JTextField streetInputField;
	private static JTextField cityInputField;
	private static JTextField stateInputField;
	private static JTextField zip5InputField;
	private static JTextField zip4InputField;
	
	private static JLabel streetInputLabel;
	private static JLabel cityInputLabel;
	private static JLabel stateInputLabel;
	private static JLabel zip5InputLabel;
	private static JLabel zip4InputLabel;
	
	private static JTextField streetOutputField;
	private static JTextField cityOutputField;
	private static JTextField stateOutputField;
	private static JTextField zip5OutputField;
	private static JTextField zip4OutputField;
	
	private static JLabel streetOutputLabel;
	private static JLabel cityOutputLabel;
	private static JLabel stateOutputLabel;
	private static JLabel zip5OutputLabel;
	private static JLabel zip4OutputLabel;
	
	private static JFileChooser browser;
	private static JLabel outputLabel;
	private static JButton submitButton;
	private static ArrayList<String[]> addresses;
	private static List<String> fileContents;
	private static List<String> normalizedAddressesList;
	private static List<String> unnormalizedAddressesList;

	/*
	 * Main method
	 */
	public static void main(String[] args) 
	{
		frame = new JFrame();

		setUIFont(new javax.swing.plaf.FontUIResource("Serif",Font.PLAIN,22));
		
		addPanels();
		hidePanels();
		setFrameOptions();
	}
	
	private static void setFrameOptions() {
		frame.setSize(1000,700); 
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private static void addPanels() {
		frame.add(getRadioPanel(), BorderLayout.NORTH);
		
		constructSingleAddressFieldPanel();
		constructBatchAddressFieldPanel();
		
		frame.add(singlePanel, BorderLayout.WEST);
		frame.add(batchPanel, BorderLayout.EAST);
	}
	
	private static JPanel getRadioPanel()
	{
		radioPanel = new JPanel();
		
		setRadioPanelOptions();
		
		JRadioButton singleRadio = getSingleRadio();
		JRadioButton batchRadio = getBatchRadio();
		
		groupRadioButtons(singleRadio, batchRadio);
		
		JLabel instructions = getInstructions();
		
		fillRadioPanel(singleRadio, batchRadio, instructions);

		return radioPanel;
	}
	
	private static void setRadioPanelOptions()
	{
		radioPanel.setLayout(new BorderLayout());
		radioPanel.setSize(400,200);
	}

	private static JRadioButton getSingleRadio()
	{
		final JRadioButton singleRadio = new JRadioButton("Single Address");	
		
		singleRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (singleRadio.isSelected()) {
					hideBatchPanel();
					showSinglePanel();
				}
			}
		});
		
		return singleRadio;
	}
	
	private static JRadioButton getBatchRadio()
	{
		final JRadioButton batchRadio = new JRadioButton("Batch Address");	
		
		batchRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (batchRadio.isSelected()) {
					showBatchPanel();
					hideSinglePanel();
				}
			}
		});
		
		return batchRadio;
	}
	
	private static JLabel getInstructions()
	{
		JLabel instructions = new JLabel("Please select which mode you would like to"
				+ " use this program in. Then, enter an address or select a file.");
		
		return instructions;
	}
	
	private static void groupRadioButtons(JRadioButton singleRadio, JRadioButton batchRadio)
	{
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(singleRadio);
		radioGroup.add(batchRadio);
	}
	
	private static void fillRadioPanel(JRadioButton singleRadio, JRadioButton batchRadio, JLabel instructions)
	{
		radioPanel.add(singleRadio, BorderLayout.WEST);
		radioPanel.add(batchRadio, BorderLayout.EAST);
		radioPanel.add(instructions, BorderLayout.NORTH);
	}
	
	private static void constructSingleAddressFieldPanel()
	{
		final int FIELD_WIDTH = 25;
		
		getInputPanel(FIELD_WIDTH);
		getOutputPanel(FIELD_WIDTH);
		
		constructSinglePanel();
	}
	
	private static void constructSinglePanel() {
		singlePanel = new JPanel();
		singlePanel.setLayout(new BoxLayout(singlePanel,BoxLayout.X_AXIS));
		
		singlePanel.add(singleInputPanel);
		singlePanel.add(singleOutputPanel);
	}
	
	private static void getInputPanel(int FIELD_WIDTH) {
		singleInputPanel = new JPanel();
		instantiateInputLabels();
		setUpInputFields(FIELD_WIDTH);
		
		singleInputPanel.setLayout(new BoxLayout(singleInputPanel, BoxLayout.Y_AXIS));
		
		JButton submitButton = getSubmitButton();
	
		fillInputPanel(submitButton);
	}
	
	private static void instantiateInputLabels() {
		streetInputLabel = new JLabel("Street");
		cityInputLabel = new JLabel("City");
	    stateInputLabel = new JLabel("State");
		zip5InputLabel = new JLabel("Zip 5");
		zip4InputLabel = new JLabel("Zip 4");
	}
	
	private static void setUpInputFields(int FIELD_WIDTH) {
		instantiateInputFields(FIELD_WIDTH);
		setInputFieldOptions();
	}
	
	private static void instantiateInputFields(int FIELD_WIDTH) {
	    streetInputField = new JTextField(FIELD_WIDTH);
		cityInputField = new JTextField(FIELD_WIDTH);
		stateInputField = new JTextField(FIELD_WIDTH);
		zip5InputField = new JTextField(FIELD_WIDTH);
		zip4InputField = new JTextField(FIELD_WIDTH);
	}
	
	private static void setInputFieldOptions() {
		streetInputField.setMaximumSize(streetInputField.getPreferredSize());
		cityInputField.setMaximumSize(cityInputField.getPreferredSize());
		stateInputField.setMaximumSize(stateInputField.getPreferredSize());
		zip5InputField.setMaximumSize(zip5InputField.getPreferredSize());
		zip4InputField.setMaximumSize(zip4InputField.getPreferredSize());
	}

	private static void fillInputPanel(JButton submitButton) {
		singleInputPanel.add(streetInputLabel);
		singleInputPanel.add(streetInputField);
		singleInputPanel.add(cityInputLabel);
		singleInputPanel.add(cityInputField);
		singleInputPanel.add(stateInputLabel);
		singleInputPanel.add(stateInputField);
		singleInputPanel.add(zip5InputLabel);
		singleInputPanel.add(zip5InputField);
		singleInputPanel.add(zip4InputLabel);
		singleInputPanel.add(zip4InputField);
		
		singleInputPanel.add(submitButton);
	}

	private static JButton getSubmitButton() {
		JButton submitButton = new JButton("Normalize");
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				handleSingleInputSubmit();
			}
		});
		
		return submitButton;
	}

	private static void handleSingleInputSubmit() {
		addresses = new ArrayList<String[]>();
		
		String[] address = getInput();
		
		addresses.add(address);
		
		process();
		
		address = addresses.get(0);
		addresses.remove(0);  //to do more than 1 address
		
		setOutputFields(address);
		
		showSingleOutputPanel();
	}

	private static void process() 
	{
		AddressProcessor processor = new AddressProcessor(addresses);
		processor.process();
		addresses = processor.getNewAddresses();
	}

	private static String[] getInput() {
		String address[] = new String[5];
		
		address[0] = streetInputField.getText();
		address[1] = cityInputField.getText();
		address[2] = stateInputField.getText();
		address[3] = zip5InputField.getText();
		address[4] = zip4InputField.getText();
		
		return address;
	}
	
	private static void setOutputFields(String[] address) {
		streetOutputField.setText(address[0]);
		cityOutputField.setText(address[1]);
		stateOutputField.setText(address[2]);
		zip5OutputField.setText(address[3]);
		zip4OutputField.setText(address[4]);	
	}

	private static void getOutputPanel(int FIELD_WIDTH) {
		singleOutputPanel = new JPanel();
		
		instantiateOutputLabels();
		
		setUpOutputFields(FIELD_WIDTH);
		
		singleOutputPanel.setLayout(new BoxLayout(singleOutputPanel,BoxLayout.Y_AXIS));
			
		fillOutputPanel();
		
		hideOutputPanel();
	}
	
	private static void instantiateOutputLabels() {
		streetOutputLabel = new JLabel("Street");
		cityOutputLabel = new JLabel("City");
		stateOutputLabel = new JLabel("State");
		zip5OutputLabel = new JLabel("Zip 5");
		zip4OutputLabel = new JLabel("Zip 4");
	}
	
	private static void setUpOutputFields(int FIELD_WIDTH) {
		instantiateOutputFields(FIELD_WIDTH);
		setOutputFieldOptions();
	}
	
	private static void instantiateOutputFields(int FIELD_WIDTH) {
		streetOutputField = new JTextField(FIELD_WIDTH);
		cityOutputField = new JTextField(FIELD_WIDTH);
		stateOutputField = new JTextField(FIELD_WIDTH);
		zip5OutputField = new JTextField(FIELD_WIDTH);
		zip4OutputField = new JTextField(FIELD_WIDTH);		
	}
	
	private static void setOutputFieldOptions() {
		streetOutputField.setMaximumSize(streetOutputField.getPreferredSize());
		cityOutputField.setMaximumSize(stateOutputField.getPreferredSize());
		stateOutputField.setMaximumSize(cityOutputField.getPreferredSize());
		zip5OutputField.setMaximumSize(zip5OutputField.getPreferredSize());
		zip4OutputField.setMaximumSize(zip4OutputField.getPreferredSize());	
	}

	private static void fillOutputPanel() {
		singleOutputPanel.add(streetOutputLabel);
		singleOutputPanel.add(streetOutputField);
		singleOutputPanel.add(cityOutputLabel);
		singleOutputPanel.add(cityOutputField);
		singleOutputPanel.add(stateOutputLabel);
		singleOutputPanel.add(stateOutputField);
		singleOutputPanel.add(zip5OutputLabel);
		singleOutputPanel.add(zip5OutputField);
		singleOutputPanel.add(zip4OutputLabel);
		singleOutputPanel.add(zip4OutputField);
	}

	private static void constructBatchAddressFieldPanel(){
		setUpBatchPanel();
		
		setUpBrowser();
		
		outputLabel = new JLabel();	
		
		setUpBatchSubmit();

		fillBatchPanel();
	}
	
	private static void setUpBatchPanel() {
		batchPanel = new JPanel();
		batchPanel.setLayout(new BoxLayout(batchPanel,BoxLayout.Y_AXIS));		
	}
	
	private static void setUpBrowser() {
		browser = new JFileChooser();
		browser.setFileSelectionMode(JFileChooser.FILES_ONLY);		
	}

	private static void setUpBatchSubmit() {
		submitButton = new JButton("Normalize");
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				handleBatchSubmit();
			}
		});		
	}

	private static void fillBatchPanel() {
		batchPanel.add(browser);
		batchPanel.add(submitButton);
		batchPanel.add(outputLabel);		
	}

	private static void handleBatchSubmit() {

		addresses = new ArrayList<String[]>();
		
		try {
			getFileContents();
			
		} catch (IOException e) {
			outputLabel.setText("Input file could not be opened. Try checking read/write permissions.");
		}
		
		putInputFileContentsIntoDataStructure();
		
		process();

		getOutputFileContentsFromDataStructure();

		writeToBatchOutput();
	}

	private static void getFileContents() throws IOException {
		File inputFile = browser.getSelectedFile();
		fileContents = Files.readAllLines(inputFile.toPath());		
	}

	private static void putInputFileContentsIntoDataStructure() {
		fileContents.forEach(new Consumer<String>() {
			public void accept(String i) {
				String[] address = new String[5];
				address = i.split("\t",5);
				addresses.add(address);
			}
		});	
	}
	
	private static void getOutputFileContentsFromDataStructure() {
		normalizedAddressesList = new ArrayList<String>();
		unnormalizedAddressesList = new ArrayList<String>();
	
		addresses.forEach(new Consumer<String[]>() {
			public void accept(String[] i) {
				
				String addressString = String.join("\t", Arrays.copyOfRange(i, 0, 5));
				if (i[5].equals("true")) {
					normalizedAddressesList.add(addressString);
				} else {
					unnormalizedAddressesList.add(addressString);
				}
			}
		});	
	}
	
	private static void writeToBatchOutput() {
		File normalizedOutputPath = browser.getCurrentDirectory();
		File unnormalizedOutputPath = browser.getCurrentDirectory();
		
		Path normalizedOutputFile = Paths.get(normalizedOutputPath.getPath()+"\\normalizedOutput.txt");
		Path unnormalizedOutputFile = Paths.get(unnormalizedOutputPath.getPath()+"\\unnormalizedOutput.txt");
		try {
			Files.write(normalizedOutputFile, normalizedAddressesList, Charset.forName("UTF-8"));
			Files.write(unnormalizedOutputFile, unnormalizedAddressesList, Charset.forName("UTF-8"));
			
			outputLabel.setText("Output was successful. Please look at the directory of the input file for output.txt.");
			
		} catch (IOException e) {
			outputLabel.setText("We're sorry, batch output failed. Please try again.");
		}	
	}

	private static void hidePanels() {
		hideSinglePanel();
		hideBatchPanel();
	}
	
	private static void showSingleOutputPanel() {
		singleOutputPanel.setVisible(true);
	}
	
	private static void showSinglePanel(){
		singlePanel.setVisible(true);
	}
	
	private static void showBatchPanel(){
		batchPanel.setVisible(true);
	}
	
	private static void hideSinglePanel(){
		singlePanel.setVisible(false);
	}
	
	private static void hideBatchPanel(){
		batchPanel.setVisible(false);
	}
	
	private static void hideOutputPanel() {
		singleOutputPanel.setVisible(false);		
	}
	
	//changes default font
	private static void setUIFont (javax.swing.plaf.FontUIResource fontUIResource)
	{
	    Enumeration<Object> keys = UIManager.getDefaults().keys();
	    while (keys.hasMoreElements()) {
	      Object key = keys.nextElement();
	      Object value = UIManager.get (key);
	      if (value != null && value instanceof javax.swing.plaf.FontUIResource)
	        UIManager.put (key, fontUIResource);
	      }
	}
}