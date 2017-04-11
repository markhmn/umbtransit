import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RegisterPage extends JFrame {

public static void main(String[] args) {

	
RegisterPage frame = new RegisterPage();
}



//instantiation
JLabel userLabel = new JLabel("Username:");
JLabel passLabel = new JLabel("Password:");
JLabel firstLabel = new JLabel("First Name:");
JLabel lastLabel = new JLabel("Last Name:");

JTextField user = new JTextField(15);
JPasswordField pass = new JPasswordField(15); //password field creates asterisks
JTextField firstName = new JTextField(15);
JTextField lastName = new JTextField(15);

JButton submit = new JButton("Submit");
JPanel panel = new JPanel();

RegisterPage(){

//	
//Create the Frame	
//	
	
//Frame size and title	
super("Registration Page");
setSize(350,250);
setLocation(500,280);
panel.setLayout (null); 

//sets coordinate positions of text and text boxes

//text boxes
user.setBounds(110,10,150,20);
pass.setBounds(110,45,150,20);
firstName.setBounds(110,85,150,20);
lastName.setBounds(110,120,150,20);

//submit
submit.setBounds(130,170,80,20);

//text
userLabel.setBounds(30,10,80,20);
passLabel.setBounds(30,45,80,20);
firstLabel.setBounds(30,85,80,20);
lastLabel.setBounds(30,120,80,20);


//add "parts" to the window
panel.add(submit);   //add the "submit" button

//text boxes
panel.add(user);   //add the username text box
panel.add(pass);     //add password text box
panel.add(firstName); //add first name text box
panel.add(lastName);  //add last name text box

//labels
panel.add(userLabel);   //add "Username" label
panel.add(passLabel);   //add "Password" label
panel.add(firstLabel);   //add "First Name" label
panel.add(lastLabel);   //add "Last Name" label

//frame operations
getContentPane().add(panel);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
actionlogin();
}

public void actionlogin(){
submit.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
String userEntry = user.getText();
ArrayList<String> userNames = new ArrayList<String>();//test username database
String testName = "test"; //test case for user name already in database
userNames.add(testName);
//String pw = pass.getText(); //supposed to use getPassword()?
                                //not sure how to implement this
if(!(userNames.contains(userEntry))) { //if user is in database
NextFrame successWindow = new NextFrame();
successWindow.setVisible(true);  //go to next frame
dispose();
} 

else {  //else, username taken and reset the form

JOptionPane.showMessageDialog(null,"Username Taken");

//clear all text boxes (reset the form)
user.setText("");  
pass.setText("");
firstName.setText("");
lastName.setText("");
//set cursor at Username
user.requestFocus(); 
}

}
});
}
}