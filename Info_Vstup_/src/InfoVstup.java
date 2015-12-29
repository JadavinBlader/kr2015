import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InfoVstup extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JFrame frame;
	protected static JTextArea dialogArea;
	protected static JTextField messageField;
	protected static JButton searchButton;
	protected static JButton addButton;
	protected static JButton univerButton;
	private VstupMap vstup = new VstupMap();
	private VstupMapFIO vstupfio = new VstupMapFIO();
	private String[] univerList = new String[100];
	private String[] departmentList = new String[100];
	private String[] directionList = new String[100];
	private int n = 0;

	public static void main(String[] args) throws FileNotFoundException {
		// פאיכ
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				frame = new InfoVstup();
				frame.setVisible(true);
			}
		});

	}

	public InfoVstup() {
		super();
		this.setLocationByPlatform(true);
		this.setMinimumSize(new Dimension(390, 210));
		this.setMaximumSize(new Dimension(700, 700));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("InfoVstup");
		this.setResizable(false);
		this.getContentPane().setLayout(null);

		JPanel topPanel = new JPanel();
		topPanel.setBounds(2, 0, 380, 200);
		this.getContentPane().add(topPanel);
		topPanel.setLayout(null);

		searchButton = new JButton("Search");
		searchButton.setRequestFocusEnabled(false);
		searchButton.setBackground(new Color(255, 215, 0));
		searchButton.setForeground(new Color(51, 204, 51));
		searchButton.setFont(new Font("Broadway", Font.PLAIN, 12));
		searchButton.setToolTipText("Click to see more search details");
		searchButton.setBounds(30, 10, 300, 40);
		topPanel.add(searchButton);

		addButton = new JButton("Add new student");
		addButton.setRequestFocusEnabled(false);
		addButton.setBackground(new Color(255, 215, 0));
		addButton.setForeground(new Color(51, 204, 51));
		addButton.setFont(new Font("Broadway", Font.PLAIN, 12));
		addButton.setToolTipText("Click to see the adding form");
		addButton.setBounds(30, 70, 300, 40);
		topPanel.add(addButton);

		univerButton = new JButton("Choose the university");
		univerButton.setRequestFocusEnabled(false);
		univerButton.setBackground(new Color(255, 215, 0));
		univerButton.setForeground(new Color(51, 204, 51));
		univerButton.setFont(new Font("Broadway", Font.PLAIN, 12));
		univerButton.setToolTipText("Click to see the university list");
		univerButton.setBounds(30, 130, 300, 40);
		topPanel.add(univerButton);

		searchButton.addActionListener(new java.awt.event.ActionListener() {
			private JFrame Nframe;
			private JTextField fioField;
			//private JTextField attField;

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Nframe = new JFrame();
				Nframe.setLocationByPlatform(true);
				Nframe.setMinimumSize(new Dimension(650, 300));
				Nframe.setMaximumSize(new Dimension(800, 500));
				Nframe.setVisible(true);
				Nframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Nframe.setTitle("Searching blank");
				Nframe.setResizable(false);
				Nframe.getContentPane().setLayout(null);

				JPanel blankPanel = new JPanel();
				blankPanel.setBounds(2, 0, 780, 480);
				Nframe.getContentPane().add(blankPanel);
				blankPanel.setLayout(null);

				fioField = new JTextField();
				fioField.setCaretColor(new Color(0, 0, 0));
				fioField.setBounds(220, 50, 390, 26);
				blankPanel.add(fioField);
				fioField.setColumns(10);

				JTextArea fioArea = new JTextArea();
				fioArea.setEnabled(false);
				fioArea.setBounds(10, 50, 200, 26);
				blankPanel.add(fioArea);
				fioArea.setBackground(java.awt.Color.lightGray);
				fioArea.setDisabledTextColor(java.awt.Color.RED);
				fioArea.setFont(new Font("Broadway", Font.PLAIN, 12));
				fioArea.setText("Surname, name, patronimic:");

				//attField = new JTextField();
				//attField.setCaretColor(new Color(0, 0, 0));
				//attField.setBounds(220, 100, 390, 26);
				//blankPanel.add(attField);
				//attField.setColumns(10);

				//JTextArea attArea = new JTextArea();
				//attArea.setEnabled(false);
				//attArea.setBounds(10, 100, 200, 26);
				//blankPanel.add(attArea);
				//attArea.setBackground(java.awt.Color.lightGray);
				//attArea.setDisabledTextColor(java.awt.Color.RED);
				//attArea.setFont(new Font("Broadway", Font.PLAIN, 16));
				//attArea.setText("           Total mark:");

				JButton confirmButton = new JButton("Confirm");
				confirmButton.setRequestFocusEnabled(false);
				confirmButton.setBackground(new Color(255, 215, 0));
				confirmButton.setForeground(new Color(51, 204, 51));
				confirmButton.setFont(new Font("Broadway", Font.PLAIN, 16));
				confirmButton.setToolTipText("Click to confirm searching");
				confirmButton.setBounds(200, 190, 150, 40);
				blankPanel.add(confirmButton);

				confirmButton
						.addActionListener(new java.awt.event.ActionListener() {

							private JFrame Sframe;

							@Override
							public void actionPerformed(ActionEvent e) {
								String fio = fioField.getText();
								//String att = attField.getText();
								Collection<LinkedList<InfoFIO>> infos = vstupfio.get(fio);

								Nframe.dispose();
								Sframe = new JFrame();
								Sframe.setLocationByPlatform(true);
								Sframe.setMinimumSize(new Dimension(650, 350));
								Sframe.setMaximumSize(new Dimension(800, 500));
								Sframe.setVisible(true);
								Sframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								Sframe.setTitle("Search list");
								Sframe.setResizable(false);
								Sframe.getContentPane().setLayout(null);

								JPanel searchPanel = new JPanel();
								searchPanel.setBounds(2, 0, 600, 300);
								Sframe.getContentPane().add(searchPanel);
								searchPanel.setLayout(null);

								JTextArea searchListArea = new JTextArea();
								searchListArea.setEnabled(false);
								searchListArea.setBounds(10, 10, 500, 280);
								searchPanel.add(searchListArea);
								searchListArea
										.setBackground(java.awt.Color.WHITE);
								searchListArea
										.setDisabledTextColor(java.awt.Color.black);
								searchListArea.setFont(new Font("Broadway",
										Font.PLAIN, 16));

								String str = "";
								for (LinkedList<InfoFIO> inf : infos) {
									str = str + inf;
								}
								searchListArea.setText(str);
							}

						});
			}

		});

		univerButton.addActionListener(new java.awt.event.ActionListener() {

			private JFrame Nframe;
			private JButton unilistButton;

			@Override
			public void actionPerformed(ActionEvent e) {
				Nframe = new JFrame();
				Nframe.setLocationByPlatform(true);
				Nframe.setMinimumSize(new Dimension(650, 350));
				Nframe.setMaximumSize(new Dimension(800, 500));
				Nframe.setVisible(true);
				Nframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Nframe.setTitle("University list");
				Nframe.setResizable(false);
				Nframe.getContentPane().setLayout(null);

				JPanel univerPanel = new JPanel();
				univerPanel.setBounds(2, 0, 600, 300);
				Nframe.getContentPane().add(univerPanel);
				univerPanel.setLayout(null);

				
				for (int i = 0; i < n; i++) {

					unilistButton = new JButton(univerList[i]);
					unilistButton.setRequestFocusEnabled(false);
					unilistButton.setBackground(new Color(255, 215, 0));
					unilistButton.setForeground(new Color(51, 204, 51));
					unilistButton.setFont(new Font("Broadway", Font.PLAIN, 16));
					unilistButton.setToolTipText("Click to confirm searching");
					unilistButton.setBounds(200, 50 * i, 150, 40);
					univerPanel.add(unilistButton);
					
					unilistButton.addActionListener(new java.awt.event.ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							
						}
						
					});
				}
			}
		});

		addButton.addActionListener(new java.awt.event.ActionListener() {
			private JFrame Nframe;
			private JTextField univerField;
			private JTextField departmentField;
			private JTextField directionField;
			private JTextField fioField;
			private JTextField attField;

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Nframe = new JFrame();
				Nframe.setLocationByPlatform(true);
				Nframe.setMinimumSize(new Dimension(650, 300));
				Nframe.setMaximumSize(new Dimension(800, 500));
				Nframe.setVisible(true);
				Nframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Nframe.setTitle("Adding blank");
				Nframe.setResizable(false);
				Nframe.getContentPane().setLayout(null);

				JPanel blankPanel = new JPanel();
				blankPanel.setBounds(2, 0, 780, 480);
				Nframe.getContentPane().add(blankPanel);
				blankPanel.setLayout(null);

				univerField = new JTextField();
				univerField.setCaretColor(new Color(0, 0, 0));
				univerField.setBounds(220, 10, 390, 26);
				blankPanel.add(univerField);
				univerField.setColumns(10);

				JTextArea univerArea = new JTextArea();
				univerArea.setEnabled(false);
				univerArea.setBounds(10, 10, 200, 26);
				blankPanel.add(univerArea);
				univerArea.setBackground(java.awt.Color.lightGray);
				univerArea.setDisabledTextColor(java.awt.Color.RED);
				univerArea.setFont(new Font("Broadway", Font.PLAIN, 16));
				univerArea.setText("           University:");

				departmentField = new JTextField();
				departmentField.setCaretColor(new Color(0, 0, 0));
				departmentField.setBounds(220, 46, 390, 26);
				blankPanel.add(departmentField);
				departmentField.setColumns(10);

				JTextArea departmentArea = new JTextArea();
				departmentArea.setEnabled(false);
				departmentArea.setBounds(10, 46, 200, 26);
				blankPanel.add(departmentArea);
				departmentArea.setBackground(java.awt.Color.lightGray);
				departmentArea.setDisabledTextColor(java.awt.Color.RED);
				departmentArea.setFont(new Font("Broadway", Font.PLAIN, 16));
				departmentArea.setText("           Department:");

				directionField = new JTextField();
				directionField.setCaretColor(new Color(0, 0, 0));
				directionField.setBounds(220, 82, 390, 26);
				blankPanel.add(directionField);
				directionField.setColumns(10);

				JTextArea directionArea = new JTextArea();
				directionArea.setEnabled(false);
				directionArea.setBounds(10, 82, 200, 26);
				blankPanel.add(directionArea);
				directionArea.setBackground(java.awt.Color.lightGray);
				directionArea.setDisabledTextColor(java.awt.Color.RED);
				directionArea.setFont(new Font("Broadway", Font.PLAIN, 16));
				directionArea.setText("           Direction:");

				fioField = new JTextField();
				fioField.setCaretColor(new Color(0, 0, 0));
				fioField.setBounds(220, 118, 390, 26);
				blankPanel.add(fioField);
				fioField.setColumns(10);

				JTextArea fioArea = new JTextArea();
				fioArea.setEnabled(false);
				fioArea.setBounds(10, 118, 200, 26);
				blankPanel.add(fioArea);
				fioArea.setBackground(java.awt.Color.lightGray);
				fioArea.setDisabledTextColor(java.awt.Color.RED);
				fioArea.setFont(new Font("Broadway", Font.PLAIN, 12));
				fioArea.setText("Surname, name, patronimic:");

				attField = new JTextField();
				attField.setCaretColor(new Color(0, 0, 0));
				attField.setBounds(220, 154, 390, 26);
				blankPanel.add(attField);
				attField.setColumns(10);

				JTextArea attArea = new JTextArea();
				attArea.setEnabled(false);
				attArea.setBounds(10, 154, 200, 26);
				blankPanel.add(attArea);
				attArea.setBackground(java.awt.Color.lightGray);
				attArea.setDisabledTextColor(java.awt.Color.RED);
				attArea.setFont(new Font("Broadway", Font.PLAIN, 16));
				attArea.setText("           Total mark:");

				JButton confirmButton = new JButton("Confirm");
				confirmButton.setRequestFocusEnabled(false);
				confirmButton.setBackground(new Color(255, 215, 0));
				confirmButton.setForeground(new Color(51, 204, 51));
				confirmButton.setFont(new Font("Broadway", Font.PLAIN, 16));
				confirmButton.setToolTipText("Click to confirm adding");
				confirmButton.setBounds(200, 190, 150, 40);
				blankPanel.add(confirmButton);

				confirmButton
						.addActionListener(new java.awt.event.ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								String univer = univerField.getText();
								String department = departmentField.getText();
								String direction = directionField.getText();
								String fio = fioField.getText();
								String att = attField.getText();
								Nframe.dispose();

								univerList[n] = univer;
								departmentList[n] = department;
								directionList[n] = direction;
								n = n + 1;

								vstup.add(univer, department, direction, fio,
										att);
								vstupfio.add(univer, department, direction,
										fio, att);
							}

						});
			}

		});
	}

}