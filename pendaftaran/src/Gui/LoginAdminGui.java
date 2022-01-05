package Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginAdminGui extends ComponentGui {
    JLabel judul = new JLabel("LOGIN ADMIN");
    
    public LoginAdminGui(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("LOGIN ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(135, 206, 250));
        setLayout(null);
        setVisible(true);
 
        judul.setBounds(25, 5, 300, 30);
        judul.setBackground(Color.black);
        judul.setFont(new Font ("Georgia", 1, 30));
        add(judul);
        
        kotak.setBounds(0, 0, 300, 40);
        kotak.setBackground(new Color(0, 191, 255));
        add(kotak);
        
        labelnpm.setBounds(30, 290, 40, 25);
        add(labelnpm);
        fieldnpm.setBounds(125, 290, 130, 25);
        add(fieldnpm);
        
        labelpassword.setBounds(30, 325, 80, 25);
        add(labelpassword);
        fieldpassword.setBounds(125, 325, 130, 25);
        add(fieldpassword);
        
        btnlogin.setBounds(90, 370, 100, 25);
        btnlogin.setBackground(Color.black);
        btnlogin.setForeground(Color.white);
        btnlogin.setBorder(null);
        add(btnlogin);
        
        btnback.setBounds(0, 435, 100, 25);
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        add(btnback);
        
        bingkaigambar.setBounds(80, 70, 150, 150);
        add(bingkaigambar);
        
        pathicon = "./src/Images/a.png";
        
        try{
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(LoginGui.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        gambarresize = bufferedImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));
        
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
        
        btnlogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnlogin.setForeground(Color.black);
                btnlogin.setBackground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnlogin.setForeground(Color.white);
                btnlogin.setBackground(Color.black);
            }
        });
        
        btnlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String npm = fieldnpm.getText();
                String password = fieldpassword.getText();
                int cek = AllObjectController.admin.login(npm, password);
                if(cek > 0){
                    dispose();
                    AdminGui adminGui = new AdminGui(cek);
                    adminGui.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    kosong();
                }
            }
        });
    }
}