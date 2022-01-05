package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.JTableHeader;

public class InformasiGui extends ComponentGui{
    JTableHeader kotak = new JTableHeader();
    
    public InformasiGui(){
        initComponent();
    }
    
    void initComponent(){
        JLabel text1 = new javax.swing.JLabel();
        JLabel text2 = new javax.swing.JLabel();
        JLabel text3 = new javax.swing.JLabel();
        JLabel text4 = new javax.swing.JLabel();
        JLabel text5 = new javax.swing.JLabel();
        
        setTitle("infromasi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(135, 206, 250));
        setLayout(null);
        setVisible(true);
        
        text1.setText("DIBUAT OLEH :");
        text1.setBounds(60,5, 300, 30);
        text1.setFont(new Font ("Georgia", 1, 20));
        add(text1);
        
        kotak.setBounds(0, 0, 300, 40);
        kotak.setBackground(new Color(0, 191, 255));
        add(kotak);
        
        text2.setText("- MUHAMMAD AMARYAN KAUTSAR");
        text2.setBackground(Color.black);
        text2.setBounds(30, 50, 300, 25);
        add(text2);
        
        text3.setText("- AHMAD LUTFI WAHYUDI");
        text3.setBackground(Color.black);
        text3.setBounds(30, 75, 300, 25);
        add(text3);
        
        text4.setText("- JONATHAN ANANDAR CAHYADI");
        text4.setBackground(Color.black);
        text4.setBounds(30, 100, 300, 25);
        add(text4);
 
        text5.setText("- MUHAMMAD WAKHID AL HAFID");
        text5.setBackground(Color.black);
        text5.setBounds(30, 125, 300, 25);
        add(text5);
        
        btnback.setBounds(0, 435, 100, 25);
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        add(btnback);
        
        
        btnback.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnback.setForeground(Color.black);
                btnback.setBackground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnback.setForeground(Color.white);
                btnback.setBackground(Color.black);
            }
        });
        
        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TampilanUtama().setVisible(true);
            }
        });
    }
}
