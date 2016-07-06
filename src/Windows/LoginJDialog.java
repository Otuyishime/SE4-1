package Windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import OcGraduateSystemClasses.University;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class LoginJDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblImportStudentCourse;
	private JTextField textFieldUsername;
	private JTextField jPassword;
	static University university;
	static //static SystemJFrame frame = new SystemJFrame(university);
    private  boolean success = true;
	


//    public  boolean isSucceeded() {
//        return succeeded;
//    }



	public static boolean isSuccess() {
		return success;
	}
	public static void setSuccess(boolean success) {
		LoginJDialog.success = success;
	}
	/**
	 * Create the dialog.
	 * @param university 
	 * @param currentFrame 
	 */
	public LoginJDialog(JFrame currentFrame, University university) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		{
			lblImportStudentCourse = new JLabel("LOGIN");
		}
		
		JLabel lblUserName = new JLabel("User Name");
		
		JLabel lblNewLabel = new JLabel("Password");
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		
		jPassword = new JPasswordField();
		jPassword.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(85)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
							.addComponent(jPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(lblUserName)
							.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblImportStudentCourse)
								.addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(98))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(16)
					.addComponent(lblImportStudentCourse)
					.addGap(37)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUserName))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton logInButton = new JButton("Login");
				logInButton.setActionCommand("OK");
				buttonPane.add(logInButton);
				getRootPane().setDefaultButton(logInButton);
				
				logInButton.addActionListener(new ActionListener(){
					

					public void actionPerformed(ActionEvent e) {
		                if (LoginJDialog.authenticate(getUsername(), getPassword())) {

		                    JOptionPane.showMessageDialog(LoginJDialog.this,
		                            "Hi " + getUsername() + "! You have successfully logged in.",
		                            "Login",
		                            JOptionPane.INFORMATION_MESSAGE);
		                    System.out.println("The login is successfull");
		                	success = true;
		                    System.out.println(isSucceeded());

		                    dispose();
		                } else {
		                    JOptionPane.showMessageDialog(LoginJDialog.this,
		                            "Invalid username or password",
		                            "Login",
		                            JOptionPane.ERROR_MESSAGE);
		                    // reset username and password
		                    textFieldUsername.setText("");
		                    jPassword.setText("");
		                    success = false;


		                }
		            }

					
					
					
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
				cancelButton.addActionListener(new ActionListener()
				{
							
				            public void actionPerformed(ActionEvent e) {
				                dispose();
				                System.exit(0);	
				            }
				            }
						);
			}
		}
	}
	public static boolean authenticate(String username, String password) {
      // hard coded user name and password
        if (username.equals("Admin") && password.equals("Admin")) {
            return true;
        }
        return false;
    }
	public String getUsername() {
        return textFieldUsername.getText().trim();
    }
 
    public String getPassword() {
        return new String(((JPasswordField) jPassword).getPassword());
    }
	
  


	public boolean isSucceeded() {
		return success;
	}
	
}
