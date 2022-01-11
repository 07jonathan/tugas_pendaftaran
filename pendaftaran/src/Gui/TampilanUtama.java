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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;

public class TampilanUtama extends ComponentGui{
    private JButton tbnlogin = new JButton("LOGIN");
    JButton btnloginadmin = new JButton("ADMIN");
    JButton keluar = new JButton("KELUAR");
    JTableHeader home = new JTableHeader();
    String pathicon;
    
    public TampilanUtama(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("HOME");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(135, 206, 250));
        setLayout(null);
        setVisible(true);
        
        menu.setText("Informasi");
        menubar.add(menu);
        menu.getAccessibleContext().setAccessibleDescription("");
        setJMenuBar(menubar);
        
        menu1.setText("Nama Kelompok");
        menu.add(menu1);
        
        
        header.setBounds(95, 5, 300, 30);
        header.setBackground(Color.black);
        header.setFont(new Font ("Georgia", 1, 30));
        add(header);    
    
        home.setBounds(0, 0, 300, 40);
        home.setBackground(new Color(0, 191, 255));
        add(home);
        
        labelnpm.setBounds(30, 250, 100, 25);
        add(labelnpm);
        fieldnpm.setBounds(110, 250, 140, 25);
        add(fieldnpm);
        
        labelpassword.setBounds(30, 300, 100, 25);
        add(labelpassword);
        
        fieldpassword.setBounds(110, 300, 140, 25);
        add(fieldpassword);
        
        
        tbnlogin.setBounds(95, 350, 100, 30);
        tbnlogin.setBackground(Color.black);
        tbnlogin.setForeground(Color.white);
        tbnlogin.setBorder(null);
        add(tbnlogin);  
        
        btnnotreg.setBounds(95, 400, 100, 30);
        btnnotreg.setBackground(Color.black);
        btnnotreg.setForeground(Color.white);
        btnnotreg.setBorder(null);
        add(btnnotreg);   
        
        //btnloginadmin.setBounds(95, 350, 100, 30);
        //btnloginadmin.setBackground(Color.black);
        //btnloginadmin.setForeground(Color.white);
        //btnloginadmin.setBorder(null);
        //add(btnloginadmin);  
        
        keluar.setBounds(95, 450, 100, 30);
        keluar.setBackground(Color.black);
        keluar.setForeground(Color.white);
        keluar.setBorder(null);
        add(keluar);  
        
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
        
        btnloginadmin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                btnloginadmin.setForeground(Color.black);
                btnloginadmin.setBackground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                btnloginadmin.setForeground(Color.white);
                btnloginadmin.setBackground(Color.black);
            }
        });
        
        keluar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                keluar.setForeground(Color.black);
                keluar.setBackground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                keluar.setForeground(Color.white);
                keluar.setBackground(Color.black);
            }
        });
        
        btnnotreg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegisterGui().setVisible(true);
            }
        });
        
        tbnlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String npm = fieldnpm.getText();
                String password = fieldpassword.getText();
                try{
                int cek = AllObjectController.mahasiswa.login(npm, password);
                if(cek > 0){
                    int cekverif = AllObjectController.mahasiswa.verif(cek);
                    if(cekverif != 0){
                        dispose();
                        MahasiswaGui mahasiswaGui = new MahasiswaGui(cek);
                        mahasiswaGui.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "AKUN BELUM DI VERIFIKASI ADMIN");
                        kosong();
                    }
                } else {
                    try{
                    int lihat = AllObjectController.admin.login(npm, password);
                    if(lihat > 0){
                        dispose();
                        AdminGui adminGui = new AdminGui(lihat);
                        adminGui.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                        kosong();
                        }
                    }
                    catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Cancelled");
                    }
                    kosong();
                }
              }
                
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Cancelled");
                
                }
            }
        });
        
        btnloginadmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginAdminGui().setVisible(true);
            }
        });
        
        keluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        menu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InformasiGui().setVisible(true);
            }
        });
    }

}