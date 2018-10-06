package bananas20;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;



public class Bananas20 extends JFrame{
    
    JButton button1;
    JTextField textField1;
    JTextArea textArea1;
    int buttonClicked;
    
        
    
    public static void main(String[] args) {
        
        new Bananas20();       
    
    }
    
    public Bananas20(){                
        this.setSize(400,400);        
        this.setLocationRelativeTo(null);
        
        Toolkit tk = Toolkit.getDefaultToolkit();        
        Dimension dim = tk.getScreenSize();        
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight()/ 2);        
        this.setLocation(xPos, yPos);        
        this.setResizable(false);        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.setTitle("I hate you");
        
        JPanel thePanel = new JPanel();     
        
        button1 = new JButton("Click Me");        
        ListenForButton lforButton = new ListenForButton();      
        button1.addActionListener(lforButton);
        
        thePanel.add(button1);
        
        textField1 = new JTextField("", 15);
        ListenForKeys lForKeys = new ListenForKeys();
        textField1.addKeyListener(lForKeys);
                
        
        thePanel.add(textField1);
        
        JTextArea textArea1 = new JTextArea(15,20);
        textArea1.setText("Tracking Events\n");
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        int numOfLines = textArea1.getLineCount();
        textArea1.append(" number of lines: " + numOfLines);
        JScrollPane scrollbar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        thePanel.add(scrollbar1);
        
        this.add(thePanel);
        
        ListenForWindow lForWindow = new ListenForWindow();
        
        this.addWindowListener(lForWindow);
        
        this.setVisible(true);
        
        textField1.requestFocus();
    }   


    
    //Listener
    
    private class ListenForButton implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            
            if(e.getSource() == button1){
                
                buttonClicked++;
                
                textArea1.append("Button Clicked " + buttonClicked + " times\n");
                
                
            }
            
        }
        
    }
    
    private class ListenForKeys implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            
            textArea1.append("Key Hit: " + e.getKeyChar() + "\n");
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    private class ListenForWindow implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {
            textArea1.append("Window Created");
        }

        @Override
        public void windowClosing(WindowEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowClosed(WindowEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowIconified(WindowEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            textArea1.append("Window in normal state");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            textArea1.append("Window is active");
        
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            textArea1.append("Window is Not active");
        
        }
    
    
    
    }
            


}            