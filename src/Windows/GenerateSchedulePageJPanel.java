package Windows;

import java.awt.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import OcGraduateSystemClasses.Degree;
import OcGraduateSystemClasses.Schedule;
import OcGraduateSystemClasses.Section;
import OcGraduateSystemClasses.Semester;
import OcGraduateSystemClasses.University;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JLabel;

public class GenerateSchedulePageJPanel extends JPanel {

	
	JScrollPane scrollpane_semester;
	DefaultListModel <Semester> listModel_semester;
	JList jlist_semesters;
	
	
	JScrollPane scrollpane_degrees;
	DefaultListModel <Degree> listModel_degrees;
	JList jlist_degrees;
	
	JScrollPane scrollpane_sections;
	DefaultListModel <Section> listModel_sections;
	JList jlist_sections;
	
	JButton btn_generate;
	
	boolean sem_ok;
	boolean degree_ok;
	private JLabel lblChooseADegree;
	private JLabel lblSchedule;
	
	/**
	 * Create the panel.
	 */
	public GenerateSchedulePageJPanel(University university) {
		
		sem_ok = degree_ok = false;
		
		setBounds(new Rectangle(0, 0, 800, 750));
		setLayout(null);
		
		// populate the semester list
		listModel_semester = new DefaultListModel<>();
		for (Semester semester : university.getSemesters())
			listModel_semester.addElement(semester);
		jlist_semesters = new JList(listModel_semester);		
		jlist_semesters.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Semester current_semester = (Semester) jlist_semesters.getSelectedValue();
				System.out.println(current_semester);
				if (current_semester != null)
					sem_ok = true;
				else
					sem_ok = false;
				
				if (sem_ok & degree_ok)
					btn_generate.setEnabled(true);
				else
					btn_generate.setEnabled(false);
					
			}
		});
		scrollpane_semester = new JScrollPane(jlist_semesters);
		scrollpane_semester.setBounds(180, 15, 130, 100);
		add(scrollpane_semester);
		
		// populate the semester list
		listModel_degrees = new DefaultListModel<>();
		for (Degree degree : university.getDegrees())
			listModel_degrees.addElement(degree);
		jlist_degrees = new JList(listModel_degrees);		
		jlist_degrees.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Degree current_degree = (Degree) jlist_degrees.getSelectedValue();
				System.out.println(current_degree);
				if (current_degree != null)
					degree_ok = true;
				else
					degree_ok = false;
				
				if (sem_ok & degree_ok)
					btn_generate.setEnabled(true);
				else
					btn_generate.setEnabled(false);
			}
		});
		scrollpane_degrees = new JScrollPane(jlist_degrees);
		scrollpane_degrees.setBounds(450, 15, 130, 100);
		add(scrollpane_degrees);
		
		btn_generate = new JButton("Generate");
		btn_generate.setEnabled(false);
		btn_generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listModel_sections.clear();	// clear the schedule
				
				Semester current_semester = (Semester) jlist_semesters.getSelectedValue();
				Degree current_degree = (Degree) jlist_degrees.getSelectedValue();
				
				ArrayList<Schedule> schedules = university.generateScheduleForDegreesInSemester("Schedules", current_semester);
				//ArrayList<Section> sections = schedule.getSections();
				//System.out.println();
				
				for (Schedule schedule : schedules ){
					ArrayList<Section> sections = schedule.getSections();
					System.out.println();
					
					if ((schedule.getDegree().getDegreeCode()).compareTo(current_degree.getDegreeCode()) == 0)
					{
						System.out.println(" " +  schedule.getDegree().getDegreeCode() + " - " + schedule.getDegree().getDegreeName());
						System.out.println("----------------------------------------------------------------------------------------");
						for (Section section : sections)
						{
							listModel_sections.addElement(section);
							System.out.println(section);
						}
					}
				}
			
				
				jlist_semesters.clearSelection();
				jlist_degrees.clearSelection();
				btn_generate.setEnabled(false);
			}
		});
		btn_generate.setBounds(647, 15, 100, 30);
		add(btn_generate);
		
		JLabel lblChooseASemester = new JLabel("Choose a semester:");
		lblChooseASemester.setBounds(50, 10, 130, 25);
		add(lblChooseASemester);
		
		lblChooseADegree = new JLabel("Choose a degree:");
		lblChooseADegree.setBounds(322, 13, 120, 25);
		add(lblChooseADegree);
		
		listModel_sections = new DefaultListModel<>();
		//for (Section section : university.getSemesters())
			//listModel_sections.addElement(semester);
		jlist_sections = new JList(listModel_sections);		
		jlist_sections.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Section selected_section = (Section) jlist_sections.getSelectedValue();
				System.out.println(selected_section);
				
				/*
				if (selected_section != null)
					sem_ok = true;
				else
					sem_ok = false;
				
				if (sem_ok & degree_ok)
					btn_generate.setEnabled(true);
				else
					btn_generate.setEnabled(false);
				*/	
			}
		});
		scrollpane_sections = new JScrollPane(jlist_sections);
		scrollpane_sections.setBounds(50, 170, 800, 400);
		add(scrollpane_sections);
		
		lblSchedule = new JLabel("Schedule");
		lblSchedule.setBounds(50, 138, 100, 25);
		add(lblSchedule);
		
		JButton button = new JButton("< Back");
		button.setBounds(50, 601, 117, 30);
		add(button);
		
		JButton btnTestCurrentSchedule = new JButton("Test Current Schedule");
		btnTestCurrentSchedule.setBounds(180, 601, 180, 30);
		add(btnTestCurrentSchedule);
		
		JButton btnDeleteSection = new JButton("Delete Section");
		btnDeleteSection.setBounds(384, 601, 117, 30);
		add(btnDeleteSection);
		
		JButton btnAddSection = new JButton("Add Section");
		btnAddSection.setBounds(513, 602, 117, 29);
		add(btnAddSection);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(653, 602, 117, 29);
		add(btnClear);
	}
}
