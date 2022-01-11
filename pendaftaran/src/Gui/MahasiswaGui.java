package Gui;

import Entity.MahasiswaEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import Helper.KoneksiDb;

public class MahasiswaGui extends ComponentGui {
    JLabel judul = new JLabel("PROFIL");
    int id;
    int status;
    String nama, npm, password, notelp, gambar, path, paket;
    String filemove = "./src/Images/";
    KoneksiDb koneksi = new KoneksiDb();
    
    
    File file;
    public MahasiswaGui(int cek){
        initComponent(cek);
                        tampil_combo();

    }
    
    void initComponent(final int cek){
        for(MahasiswaEntity mahasiswaEntities : AllObjectController.mahasiswa.getById(cek)) {
            this.id       = mahasiswaEntities.getId();
            this.nama     = mahasiswaEntities.getNama();
            this.npm      = mahasiswaEntities.getNpm();
            this.password = mahasiswaEntities.getPassword();
            this.notelp   = mahasiswaEntities.getnoTelp();
            this.paket   = mahasiswaEntities.getPaket();
            this.status   = mahasiswaEntities.getStatus();
        }
        
        setTitle("PROFIL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(135, 206, 250));
        setLayout(null);
        setVisible(true);
        
        labelnama.setBounds(10, 170, 40, 25);
        add(labelnama);
        fieldnama.setBounds(90, 170, 100, 25);
        fieldnama.setText(nama);
        fieldnama.setEditable(false);
        add(fieldnama);
        
        labelnpm.setBounds(10, 220, 40, 25);
        add(labelnpm);
        fieldnpm.setBounds(90, 220, 100, 25);
        fieldnpm.setText(npm);
        fieldnpm.setEditable(false);
        add(fieldnpm);
        
        labelpassword.setBounds(10, 270, 80, 25);
        add(labelpassword);
        fieldpassword.setBounds(90, 270, 100, 25);
        fieldpassword.setText(password);
        fieldpassword.setEditable(false);
        add(fieldpassword);
        
        labelnotelp.setBounds(10, 320, 80, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(90, 320, 100, 25);
        fieldnotelp.setText(notelp);
        fieldnotelp.setEditable(false);
        add(fieldnotelp);
        
        labelpaket.setBounds(10, 370, 80, 25);
        add(labelpaket);
        fieldpaket.setBounds(90, 370, 80, 25);
        fieldpaket.setText(paket);
        fieldpaket.setEditable(false);
        jComboBoxPaket.setBounds(90, 370, 100, 25);
        add(fieldpaket);
        add(jComboBoxPaket);
        
        btnubahnama.setBounds(200, 170, 80, 25);
        add(btnubahnama);
        
        btnubahnpm.setBounds(200, 220, 80, 25);
        add(btnubahnpm);
        
        btnubahpassword.setBounds(200, 270, 80, 25);
        add(btnubahpassword);
        
        btnubahnotelp.setBounds(200, 320, 80, 25);
        add(btnubahnotelp);
        
        labelpaket.setBounds(10, 370, 80, 25);
        add(labelpaket);
        btnubahpaket.setBounds(200, 370, 80, 25);
        add(btnubahpaket);
        
        btnback.setBounds(0, 435, 100, 25);
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        add(btnback);
        
        
        jComboBoxPaket.addItem(tampil_combo()[0]);
        jComboBoxPaket.addItem(tampil_combo()[1]);
        jComboBoxPaket.addItem(tampil_combo()[2]);
        jComboBoxPaket.addItem(tampil_combo()[3]);
        
        judul.setBounds(90, 115, 150, 30);
        judul.setBackground(Color.black);
        judul.setFont(new Font ("Georgia", 1, 25));
        add(judul);
        
        bingkaigambar.setBounds(95,10,100,100);
        add(bingkaigambar);
        
        String pathicon = "./src/Images/p.png";
        
        try{
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(LoginGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        gambarresize = bufferedImage.getScaledInstance(100, 100,    Image.SCALE_SMOOTH);
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
        
        btnubahnama.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputnama = JOptionPane.showInputDialog("Massukkan Nama Baru");
                    if(inputnama.length() > 0){
                        AllObjectController.mahasiswa.updateData(1, inputnama, cek);
                        fieldnama.setText(inputnama);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahnpm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputnpm = JOptionPane.showInputDialog("Masukan NPM Baru");
                    if(inputnpm.length() > 0){
                        AllObjectController.mahasiswa.updateData(2, inputnpm, cek);
                        fieldnpm.setText(inputnpm);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahpassword.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputpass = JOptionPane.showInputDialog("Masukan Password Baru");
                    if(inputpass.length() > 0){
                        AllObjectController.mahasiswa.updateData(3, inputpass, cek);
                        fieldpassword.setText(inputpass);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahnotelp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputNoTelp = JOptionPane.showInputDialog("Masukan Nomor Telepon Baru");
                    if(inputNoTelp.length() > 0){
                        AllObjectController.mahasiswa.updateData(4, inputNoTelp, cek);
                        fieldnotelp.setText(inputNoTelp);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        
        btnubahpaket.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    
                String paket = (String)jComboBoxPaket.getSelectedItem();
                    if(paket.length() > 0){
                        AllObjectController.mahasiswa.updateData(5, paket, cek);
                        fieldpaket.setText(paket);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
    }
    
    public Object[] tampil_combo()
    {
        Object[] ob = new Object[5];
            
        int i=0;
        try {
        
        Connection con = koneksi.getconnection();
        Statement stt = con.createStatement();
        String sql = "SELECT jurusan from paketa order by jurusan asc";      
        ResultSet res = stt.executeQuery(sql);                                
        
        while(res.next()){
            ob[i] = res.getString(1);
            i++;
         }
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return ob;
    }
    
}
