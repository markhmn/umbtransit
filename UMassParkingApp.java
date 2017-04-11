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



class UMassParkingApp extends JFrame
{   final int MAX_CAPACITY = 1000;
  
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
      
    
     // BoxLayout.Y_AXIS = 5;
       setContentPane(new JLabel(new ImageIcon("group.jpg")));
        setTitle("UMass Parking app");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        BoxLayout boxlayout = new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS);
        setLayout(boxlayout);
       setIconImage(new ImageIcon("unnamed.png").getImage());
       ImageIcon Bayside1 = new ImageIcon("doc2.png");
       
       
      
       Image image = Bayside1.getImage();
       Image newimg = image.getScaledInstance(100,60, java.awt.Image.SCALE_SMOOTH);
       Bayside1 = new ImageIcon(newimg);
       
       
       
  //for demonstration purposes     
   int i = 1000;
//int i = (int)parkingLot2(time());
   
   
   
        JButton button = new JButton(Integer.toString(i) + "/1000",Bayside1);
    button.setBackground(Color.GREEN);
      getContentPane().setBackground(Color.BLACK);
      if(i == MAX_CAPACITY){
        button.setText("FULL");
            button.setBackground(Color.RED);
      }
        add(button);
        pack();
        setSize(400,400);
        setVisible(true);
    }
   
    public static void main(String args[])
    {  
       // System.out.println((int)parkingLot2(time()));
         new UMassParkingApp();
    }
}