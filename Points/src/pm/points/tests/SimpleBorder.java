package pm.points.tests;

import java.awt.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JPanel; 
import javax.swing.JFrame;
import javax.swing.JTextArea;



public class SimpleBorder {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       

        Border etched = (Border) BorderFactory.createEtchedBorder();


        String[] items = {"A", "B", "C", "D"};
        JList list = new JList(items);

        JTextArea text = new JTextArea(10, 40);

        JScrollPane scrol = new JScrollPane(text);
        JScrollPane scrol2 = new JScrollPane(list);

        JPanel panel= new JPanel();
        panel.add(scrol2,BorderLayout.WEST);
        panel.add(scrol, BorderLayout.EAST);    
        panel.setBorder(etched);

        frame.add(panel);
        frame.setVisible(true);
    }

}
