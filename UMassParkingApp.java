import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.Box;
import java.time.*;
import java.time.temporal.*;
import java.time.*;
import java.time.temporal.*;
import java.lang.Math;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;
import java.awt.Dimension;
import java.net.URL;
import java.awt.Dimension;
import java.awt.event.*;


class UMassParkingApp extends JFrame 
  {
 
  final int MAX_CAPACITY = 1000;
  
    static double time(){
          LocalDateTime now = LocalDateTime.now();
          double hour = now.get(ChronoField.HOUR_OF_DAY);
          double minute = now.get(ChronoField.MINUTE_OF_DAY);
   
          return (hour +  (minute - hour*60)/60 ) ;}
      
  
  static double parkingLot2(double x){
  
  double a = 100*Math.pow(x-8, 2)/Math.pow(1 + Math.pow(.25*(x-8),3),2);
  double b = 70*Math.pow(x-16, 2)/Math.pow(1 + Math.pow(.29*(x-16),3),2);
             
   if(x<=17 && x>=8)
               return a;
   if(x > 17 && x < 22 )
             return b;
   if(x < 8 || x>22)
         return 35;
  return 0;
  }
   

        
        
    public UMassParkingApp()
    {
        createAndShowGUI();
    }
   
    public  void createAndShowGUI()
    {
      
        setContentPane(new JLabel(new ImageIcon("group.jpg")));
        setTitle("UMass Parking app");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
     
        BoxLayout boxlayout = new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS);
        setLayout(boxlayout);
        setIconImage(new ImageIcon("unnamed.png").getImage());
        ImageIcon Bayside1 = new ImageIcon("doc2.png");
        setBounds(300, 150, 450, 750);
          
        Image image = Bayside1.getImage();
        Image newimg = image.getScaledInstance(100,60, java.awt.Image.SCALE_SMOOTH);
        Bayside1 = new ImageIcon(newimg);
       
       //for demonstration purposes     
       //int i = 1000;
       int i = (int)parkingLot2(time());
       Container pane = new Container();
       getContentPane().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
       pane.setLayout(new GridBagLayout());
       GridBagConstraints c = new GridBagConstraints();
       c.fill = GridBagConstraints.HORIZONTAL;
       c.gridx = 1;
       c.gridy = 0;
       c.weightx = 0.5;
   
       JButton button1 = new JButton(Integer.toString(i) + "/1000",Bayside1);
       button1.setBackground(Color.GREEN);
       getContentPane().setBackground(Color.BLACK);
    
       if(i == MAX_CAPACITY){
            button1.setText("FULL");
            button1.setBackground(Color.RED);         
       }
      
      button1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
           button1ActionPerformed(evt);
      }}
      );
      
      add(button1, c);
      pack();
      //setSize(400,400);
      setVisible(true);
    }
    
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO: Add your handling code here:
        System.exit(0);
}
  
    public static void main(String args[])
    {  
         new UMassParkingApp();
    }
}