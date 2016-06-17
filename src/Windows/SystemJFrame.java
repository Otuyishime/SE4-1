package Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class SystemJFrame extends JFrame {
	
	private JFrame currentFrame;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// 
					
					SystemJFrame frame = new SystemJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public SystemJFrame() {
		
		currentFrame = this;
		
		setTitle("Course Scheduling System");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 700, 650);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSystem = new JMenu("System");
		menuBar.add(mnSystem);
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mnSystem.add(mntmLogin);
		
		JMenu mnImport = new JMenu("Import");
		menuBar.add(mnImport);
		
		JMenuItem mntmStudentCourseData = new JMenuItem("Student Course Data");
		mnImport.add(mntmStudentCourseData);
		
		JMenuItem mntmStudentData = new JMenuItem("Student Data");
		mnImport.add(mntmStudentData);
		
		JMenu mnMaintain = new JMenu("Maintain");
		menuBar.add(mnMaintain);
		
		// create a Course menu item
		JMenuItem mntmCourse = new JMenuItem("Course");
		
		// event listener for a Course menu item
		mntmCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Switching to Courses list...");
				getContentPane().removeAll();
				getContentPane().add(new CourseListJPanel(currentFrame));
				getContentPane().revalidate();
			}
		});
		
		// create University menu and click event listener
		JMenuItem mntmUniversity = new JMenuItem("University");		
		mntmUniversity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Editing University info...");
				getContentPane().removeAll();
				getContentPane().add(new UniversityEditPanel(currentFrame));
				getContentPane().revalidate();
			}
		});
		
		mnMaintain.add(mntmUniversity);
		mnMaintain.add(mntmCourse);
		
		// create a Faculty menu and click event listener
		JMenuItem mntmFaculty = new JMenuItem("Faculty");
		mntmFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Editing Faculty info...");
				getContentPane().removeAll();
				getContentPane().add(new FacultyListJPanel(currentFrame));
				getContentPane().revalidate();
			}
		});
		mnMaintain.add(mntmFaculty);
		
		// create a Degree Plan menu and click event listener
		JMenuItem mntmDegreePlan = new JMenuItem("Degree Plan");
		mntmDegreePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Editing Degree Plan info...");
				getContentPane().removeAll();
				getContentPane().add(new DegreePlanListJPanel(currentFrame));
				getContentPane().revalidate();
			}
		});
		mnMaintain.add(mntmDegreePlan);
		
		// create a Room menu item and click event listener
		JMenuItem mntmRoom = new JMenuItem("Room");
		mntmRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Editing Room info...");
				getContentPane().removeAll();
				getContentPane().add(new RoomListJPanel(currentFrame));
				getContentPane().revalidate();
			}
		});
		mnMaintain.add(mntmRoom);
		
		JMenu mnSchedule = new JMenu("Schedule");
		menuBar.add(mnSchedule);
		
		JMenuItem mntmGenerate = new JMenuItem("Generate");
		mnSchedule.add(mntmGenerate);
		
		JMenuItem mntmTest = new JMenuItem("Test");
		mnSchedule.add(mntmTest);
		
		JMenu mnReport = new JMenu("Report");
		menuBar.add(mnReport);
		
		JMenuItem mntmScheduleOfCourses = new JMenuItem("Schedule of Courses");
		mnReport.add(mntmScheduleOfCourses);
		
		JMenuItem mntmFacultyLoad = new JMenuItem("Faculty Load");
		mnReport.add(mntmFacultyLoad);
		
		JMenuItem mntmDegreePlans = new JMenuItem("Degree Plans");
		mnReport.add(mntmDegreePlans);
		
		JMenuItem mntmStudentsCompletedCourses = new JMenuItem("Student's Completed Courses");
		mnReport.add(mntmStudentsCompletedCourses);
		
		getContentPane().removeAll();
		MainJPanel mainJPanel = new MainJPanel();
		getContentPane().add(mainJPanel);
		getContentPane().revalidate();
	}
}
