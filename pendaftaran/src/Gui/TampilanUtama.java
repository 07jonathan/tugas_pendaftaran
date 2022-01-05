package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TampilanUtama extends ComponentGui{
    JLabel header = new JLabel("HOME");
    
    public TampilanUtama(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("HOME");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(135, 206, 250));
        setLayout(null);
        setVisible(true);
        
        header.setBounds(95, 5, 300, 30);
        header.setBackground(Color.black);
        header.setFont(new Font ("Georgia", 1, 30));
        add(header);    
    
        kotak.setBounds(0, 0, 300, 40);
        kotak.setBackground(new Color(0, 191, 255));
        add(kotak);
        
        menu.setText("menu");
        menubar.add(menu);
        menu.getAccessibleContext().setAccessibleDescription("");
        setJMenuBar(menubar);

        menu3.setText("Login Admin");
        menu.add(menu3);        
        menu1.setText("Informasi");
        menu.add(menu1);
        menu2.setText("Keluar");
        menu.add(menu2);
        
        btnnotreg.setBounds(95, 250, 100, 30);
        btnnotreg.setBackground(Color.black);
        btnnotreg.setForeground(Color.white);
        btnnotreg.setBorder(null);
        add(btnnotreg);   
        
        tbnlogin.setBounds(95, 300, 100, 30);
        tbnlogin.setBackground(Color.black);
        tbnlogin.setForeground(Color.white);
        tbnlogin.setBorder(null);
        add(tbnlogin);  
        
        bingkaigambar.setBounds(80, 65, 130, 160);
        add(bingkaigambar);
        
        pathicon = "./src/Images/R.png";
        
        try{
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(LoginGui.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        gambarresize = bufferedImage.getScaledInstance(130, 160, Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));
        
        btnnotreg.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                btnnotreg.setForeground(Color.black);
                btnnotreg.setBackground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                btnnotreg.setForeground(Color.white);
                btnnotreg.setBackground(Color.black);
            }
        });
        
        tbnlogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                tbnlogin.setForeground(Color.black);
                tbnlogin.setBackground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                tbnlogin.setForeground(Color.white);
                tbnlogin.setBackground(Color.black);
            }
        });
        
        btnnotreg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegisterGui().setVisible(true);
            }
        });
        
        tbnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginGui().setVisible(true);
            }
        });
        
        menu3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginAdminGui().setVisible(true);
            }
        });
        
        menu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InformasiGui();
            }
        });
        
        menu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}