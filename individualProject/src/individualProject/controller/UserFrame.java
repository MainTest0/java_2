package individualProject.controller;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument.Content;

import individualProject.UserDTO;
import individualProject.parsing.Parsing;

public class UserFrame extends JFrame implements ActionListener {

	// 조회 버튼
	private JButton selectButton;
	private JButton insertButton;
	// 검색창
	private JTextField searchText;
	private String t;
	private JScrollPane pane;
	private JTextArea area;
	private UserController con;
	private Parsing parsing;

	public UserFrame() {
		initData();
		setInitLayout();
		addEventListner();
	}

	private void initData() {
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		selectButton = new JButton("조회");
		insertButton = new JButton("값넣기");
		searchText = new JTextField(30);
		con = new UserController();
		area = new JTextArea(42, 60);
		pane = new JScrollPane(area);
		parsing = new Parsing();
	}

	private void setInitLayout() {
		setLayout(new FlowLayout());
		add(searchText);
		add(selectButton);
		add(insertButton);
		add(pane);
		setVisible(true);
	}

	private void addEventListner() {
		selectButton.addActionListener(this);
		insertButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == selectButton) {
			System.out.println("조회");
			t = searchText.getText();
			UserDTO result = con.selectController(t);
			area.append(String.valueOf(result));
			System.out.println(result);
		}
		if (e.getSource() == insertButton) {
			// main에 들어갈 insert 넣기
		}
		repaint();
	}

} // end of class
