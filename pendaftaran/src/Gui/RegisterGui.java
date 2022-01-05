package Gui;

import java.sql.Connection;
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
import javax.imageio.ImageIO;
import Helper.KoneksiDb;
import java.sql.Statement;
import java.sql.ResultSet;

public class RegisterGui extends ComponentGui {
    KoneksiDb koneksi = new KoneksiDb();
    
    public RegisterGui(){
        initComponent();
        tampil_combo();
    }
    
    void initComponent(){
        setTitle("Register Akun");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(135, 206, 250));
        setLayout(null);
        setVisible(true);
        
        labelregister.setBounds(60, 5, 300, 30);
        labelregister.setBackground(Color.black);
        labelregister.setFont(new Font ("Georgia", 1, 30));
        add(labelregister);
        
        kotak.setBounds(0, 0, 300, 40);
        kotak.setBackground(new Color(0, 191, 255));
        add(kotak);
        
        labelnama.setBounds(30, 155, 40, 25);
        add(labelnama);
        fieldnama.setBounds(125, 155, 130, 25);
        add(fieldnama);
        
        labelnpm.setBounds(30, 200, 80, 25);
        add(labelnpm);
        fieldnpm.setBounds(125, 200, 130, 25);
        add(fieldnpm);
        
        labelpassword.setBounds(30, 245, 80, 25);
        add(labelpassword);
        fieldpassword.setBounds(125, 245, 130, 25);
        add(fieldpassword);
        
        labelnotelp.setBounds(30, 290, 80, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(125, 290, 130, 25);
        add(fieldnotelp);
        
        labelpaket.setBounds(30, 335, 80, 25);
        add(labelpaket);
        jComboBoxPaket.setBounds(125, 335, 130, 25);
        add(jComboBoxPaket);
        
        
        btnregister.setBounds(80, 380, 140, 25);
        btnregister.setBorder(null);
        btnregister.setBackground(Color.black);
        btnregister.setForeground(Color.white);
        btnregister.setFocusPainted(false);
        add(btnregister);
        
        btnback.setBounds(0, 435, 100, 25);
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        add(btnback);
        
        bingkaigambar.setBounds(45, 20, 200, 150);
        add(bingkaigambar);
        
        pathicon = "./src/Images/b.png";
        
        try{
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(LoginGui.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        gambarresize = bufferedImage.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));
        
        btnregister.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnregister.setForeground(Color.black);
                btnregister.setBackground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnregister.setForeground(Color.white);
                btnregister.setBackground(Color.black);
            }
        });
        
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
        
        btnregister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String nama = fieldnama.getText();
                String npm = fieldnpm.getText();
                String password = fieldpassword.getText();
                String notelp = fieldnotelp.getText();
                String paket = (String)jComboBoxPaket.getSelectedItem();
                if(nama.length() != 0 && npm.length() != 0 && password.length() != 0 && notelp.length() != 0){
                    AllObjectController.mahasiswa.insertData(nama, npm, password, notelp, paket);
                    JOptionPane.showMessageDialog(null, "Silahkan Login Kembali");
                    dispose();
                    new TampilanUtama().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
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
    
    public void tampil_combo()
    {
        try {
        Connection con = koneksi.getconnection();
        Statement stt = con.createStatement();
        String sql = "SELECT jurusan from paketa order by jurusan asc";      // disini saya menampilkan NIM, anda dapat menampilkan
        ResultSet res = stt.executeQuery(sql);                                // yang anda ingin kan
        
        while(res.next()){
            Object[] ob = new Object[3];
            ob[0] = res.getString(1);
            jComboBoxPaket.addItem(ob[0]);                                      // fungsi ini bertugas menampung isi dari database
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}