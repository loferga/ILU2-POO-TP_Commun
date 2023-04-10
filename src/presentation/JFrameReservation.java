package presentation;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;

import dialog.DialogReservation;


public class JFrameReservation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelDateTime;
	private JLabel lblChooseDate;
	private JLabel lblChooseTime;
	private JComboBox<String> cbChooseTime;
	private JPanel panelNumofPersons;
	private JLabel lblNumofPersons;
	private JComboBox<Integer> cbNumofPersons;
	private DatePicker datePicker;
	private JPanel panelTable;
	private JLabel lblTable;
	private JLabel lblTableMap;
	private JList<String> lTable;
	private JButton btnValidate;
	private JPanel panelConfirmCancel;
	private JLayeredPane layeredPane;
	private JOptionPane opValidationMessage;
	private transient DialogReservation dialogueReservation;


	/**
	 * Create the frame.
	 */
	public JFrameReservation() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameReservation.class.getResource("/resources/Plan_tables.JPG")));
		setTitle("R\u00E9servez une table");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panelDateTime = new JPanel();
		
		panelNumofPersons = new JPanel();
		
		panelTable = new JPanel();
		
		panelConfirmCancel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelConfirmCancel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panelTable, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panelNumofPersons, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panelDateTime, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 459, Short.MAX_VALUE))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelDateTime, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelNumofPersons, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelTable, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panelConfirmCancel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		lblTableMap = new JLabel("");
		lblTableMap.setIcon(new ImageIcon(JFrameReservation.class.getResource("/resources/Plan_tables.JPG")));
		
		lTable = new JList<>();
		lTable.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				do_lTable_valueChanged(e);
			}
		});
		lTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lTable.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"Table 1", "Table 2", "Table 3", "Table 4", "Table 5", "Table 6"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		
		layeredPane = new JLayeredPane();
		
		lblTable = new JLabel("3. Indiquez la table \u00E0 r\u00E9server");
		lblTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panelTable = new GroupLayout(panelTable);
		gl_panelTable.setHorizontalGroup(
			gl_panelTable.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTable.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTable.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTable.createSequentialGroup()
							.addComponent(lblTableMap, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
							.addGap(30)
							.addComponent(lTable, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(22))
						.addGroup(gl_panelTable.createSequentialGroup()
							.addComponent(lblTable, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(369, Short.MAX_VALUE))))
		);
		gl_panelTable.setVerticalGroup(
			gl_panelTable.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTable.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTable.createParallelGroup(Alignment.LEADING)
						.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTable, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_panelTable.createParallelGroup(Alignment.LEADING)
						.addComponent(lTable, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTableMap, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelTable.setLayout(gl_panelTable);
		
		btnValidate = new JButton("Valider");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnValidate_actionPerformed(e);
			}
		});
		btnValidate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panelConfirmCancel = new GroupLayout(panelConfirmCancel);
		gl_panelConfirmCancel.setHorizontalGroup(
			gl_panelConfirmCancel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelConfirmCancel.createSequentialGroup()
					.addContainerGap(202, Short.MAX_VALUE)
					.addComponent(btnValidate)
					.addGap(182))
		);
		gl_panelConfirmCancel.setVerticalGroup(
			gl_panelConfirmCancel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelConfirmCancel.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addComponent(btnValidate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelConfirmCancel.setLayout(gl_panelConfirmCancel);
		
		lblNumofPersons = new JLabel("2. Indiquez le nombre de personnes");
		lblNumofPersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		cbNumofPersons = new JComboBox<>();
		cbNumofPersons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_cbNumofPersons_actionPerformed(e);
			}
		});
		cbNumofPersons.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {2, 3, 4, 5, 6, 7, 8}));
		cbNumofPersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panelNumofPersons = new GroupLayout(panelNumofPersons);
		gl_panelNumofPersons.setHorizontalGroup(
			gl_panelNumofPersons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNumofPersons.createSequentialGroup()
					.addGroup(gl_panelNumofPersons.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelNumofPersons.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNumofPersons, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelNumofPersons.createSequentialGroup()
							.addGap(199)
							.addComponent(cbNumofPersons, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		gl_panelNumofPersons.setVerticalGroup(
			gl_panelNumofPersons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNumofPersons.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNumofPersons, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cbNumofPersons, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		panelNumofPersons.setLayout(gl_panelNumofPersons);
		
		lblChooseDate = new JLabel("1. Choisissez la date");
		lblChooseDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblChooseTime = new JLabel("et l'heure");
		lblChooseTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		datePicker = new DatePicker();
		datePicker.addDateChangeListener(new DateChangeListener() {
			public void dateChanged(DateChangeEvent arg0) {
				do_datePicker_dateChanged(arg0);
			}
		});
		
		cbChooseTime = new JComboBox<>();
		cbChooseTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_cbChooseTime_actionPerformed(e);
			}
		});
		cbChooseTime.setModel(new DefaultComboBoxModel<String>(new String[] {"12h00", "12h30", "13h00", "19h00", "19h30", "20h00", "20h30"}));
		cbChooseTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panelDateTime = new GroupLayout(panelDateTime);
		gl_panelDateTime.setHorizontalGroup(
			gl_panelDateTime.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDateTime.createSequentialGroup()
					.addGroup(gl_panelDateTime.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelDateTime.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panelDateTime.createParallelGroup(Alignment.LEADING)
								.addComponent(lblChooseDate, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelDateTime.createSequentialGroup()
									.addGap(148)
									.addComponent(lblChooseTime, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panelDateTime.createSequentialGroup()
							.addGap(32)
							.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
							.addGap(52)
							.addComponent(cbChooseTime, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
					.addGap(45))
		);
		gl_panelDateTime.setVerticalGroup(
			gl_panelDateTime.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDateTime.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panelDateTime.createParallelGroup(Alignment.LEADING)
						.addComponent(lblChooseDate, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblChooseTime, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panelDateTime.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbChooseTime, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(3))
		);
		panelDateTime.setLayout(gl_panelDateTime);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	public void initPresentation() {
		lblChooseDate.setEnabled(true);
		datePicker.setEnabled(true);
		lblChooseTime.setEnabled(false);
		cbChooseTime.setEnabled(false);
		
		lblNumofPersons.setEnabled(false);
		cbNumofPersons.setEnabled(false);
		
		lblTable.setEnabled(false);
		lblTableMap.setEnabled(false);
		lTable.setEnabled(false);
		
		btnValidate.setEnabled(false);
		
		System.out.println("InitPresentation done");
	}
	
	public void enableTime() {
		
		lblChooseTime.setEnabled(true);
		cbChooseTime.setEnabled(true);
		
	}
	
	public void enableNumofPersons() {
		
		lblNumofPersons.setEnabled(true);
		cbNumofPersons.setEnabled(true);
		
	}
	
	public void initTableMap(int[] propositions) {
		int nbProposition = 0;
		int[] propositionRetenue = new int[propositions.length-1];
		for(int i = 1 ; i<propositions.length -1; i++) {
			if(propositions[i] != 0) {
				propositionRetenue[nbProposition] = propositions[i];
				nbProposition++;
			}
		}
		String[] propString = new String[nbProposition];
		for (int i = 0; i < nbProposition; i++) {
			propString[i] = "Table " + propositionRetenue[i];
		}
		lTable.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] values = propString;
			public int getSize() {
				return values.length;
			}
			
			public String getElementAt(int index) {
				return values[index];
			}
		
		});
	}
	
	public void enableTableMap() {
		
		lblTable.setEnabled(true);
		lblTableMap.setEnabled(true);
		lTable.setEnabled(true);
		
	}
	
	public void unableAll() {
		
		cbChooseTime.setSelectedIndex(0);
		lblChooseTime.setEnabled(false);
		cbChooseTime.setEnabled(false);
		
		cbNumofPersons.setSelectedIndex(0);
		lblNumofPersons.setEnabled(false);
		cbNumofPersons.setEnabled(false);
		
		lTable.setSelectedIndex(0);
		lblTable.setEnabled(false);
		lblTableMap.setEnabled(false);
		lTable.setEnabled(false);
		
		btnValidate.setEnabled(false);
		
		dialogueReservation.handleCancelEvent();
		
	}
	
	
	
	public void enableValidationInformation(String donnees) {
		
		btnValidate.setEnabled(true);
		
		opValidationMessage = new JOptionPane(donnees);
		
	}
	
	
//Record reference to Dialogue
	
	public void setDialogue(DialogReservation dialogReservation) {
		dialogueReservation = dialogReservation;
	}
	
	protected void do_datePicker_dateChanged(DateChangeEvent arg0) {
		if (arg0!=null && arg0.getNewDate()!=null) {
			LocalDate currentDate = LocalDate.now();
			if (arg0.getNewDate().compareTo(currentDate) > 0) {
				dialogueReservation.handleDateSelectedEvent(arg0.getNewDate().toString());
				enableTime();
				return;
			}
			System.err.println("[Warning] " + arg0.getNewDate().toString() + " is in the past!");
			datePicker.setDate(null);
		}
		unableAll();
	}
	

	protected void do_cbChooseTime_actionPerformed(ActionEvent e) {
		if (e.getSource().equals(cbChooseTime) && cbChooseTime.getSelectedIndex() >= 0) {
			dialogueReservation.handleTimeSelectedEvent(cbChooseTime.getSelectedItem().toString());
			enableNumofPersons();
		}
	}
	
	protected void do_cbNumofPersons_actionPerformed(ActionEvent e) {
		if (e.getSource().equals(cbNumofPersons) && cbNumofPersons.getSelectedIndex() >= 0) {
			dialogueReservation.handleNumofPersonsSelectedEvent(cbNumofPersons.getSelectedItem().toString());
			enableTableMap();
		}
	}
	
	// this method is called twice everytime an item is selected in the list, to prevent that:
	private boolean hasBeenTriggered = false;
	
	protected void do_lTable_valueChanged(ListSelectionEvent e) {
		if (e.getSource().equals(lTable) && lTable.getSelectedIndex() >= 0) {
			if (hasBeenTriggered) {
				hasBeenTriggered = false;
			} else {
				dialogueReservation.handleTableSelectedEvent(lTable.getSelectedIndex());
				btnValidate.setEnabled(true);
				hasBeenTriggered = true;
			}
		}
	}
	
	protected void do_btnValidate_actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnValidate)) {
			dialogueReservation.handleValidateEvent();
			JOptionPane.showMessageDialog(opValidationMessage, opValidationMessage.getMessage());
		}
	}
}
