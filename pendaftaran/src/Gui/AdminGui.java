package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.JTableHeader;

public class AdminGui extends ComponentGui {
    JTable tabelmahasiswa = new JTable();
    JScrollPane spmahasiswa = new JScrollPane(tabelmahasiswa);
    JTextField textpilih = new JTextField();
    JLabel judul = new JLabel("ADMIN");
    JTableHeader reg = new JTableHeader();
    int kode;
    
    public AdminGui(int cek){
        initComponent(cek);
    }
    
    void initComponent(final int cek){
        setTitle("ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(135, 206, 250));
        setLayout(null);
        setVisible(true);
        
        judul.setBounds(330, 5, 800, 30);
        judul.setBackground(Color.black);
        judul.setFont(new Font ("Georgia", 1, 30));
        add(judul);
        
        reg.setBounds(0, 0, 800, 40);
        reg.setBackground(new Color(0, 191, 255));
        add(reg);        
        
        spmahasiswa.setBounds(30, 65, 600, 350);
        tabelmahasiswa.setModel(AllObjectController.mahasiswa.daftarMahasiswa());
        add(spmahasiswa);
        
        btnverif.setBounds(650, 65, 110, 25);
        btnverif.setFocusPainted(false);
        btnverif.setBorder(null);
        btnverif.setBackground(Color.black);
        btnverif.setForeground(Color.white);
        add(btnverif);
        
        btnunverif.setBounds(650, 110, 110, 25);
        btnunverif.setFocusPainted(false);
        btnunverif.setBorder(null);
        btnunverif.setBackground(Color.black);
        btnunverif.setForeground(Color.white);
        add(btnunverif);
        
        btndelete.setBounds(650, 155, 110, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btnback.setBounds(0, 435, 80, 25);
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        btnback.setBorder(null);
        add(btnback);
        
        tabelmahasiswa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelmahasiswa.getSelectedRow();
                textpilih.setText(AllObjectController.mahasiswa.daftarMahasiswa().getValueAt(i, 0).toString());
            }
        });
        
        btnverif.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnverif.setForeground(Color.black);
                btnverif.setBackground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnverif.setForeground(Color.white);
                btnverif.setBackground(Color.black);
            }
        });
        
        btnverif.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.admin.verifMahasiswa(kode);
                JOptionPane.showMessageDialog(null, "Berhasil Verifikasi");
                tabelmahasiswa.setModel(AllObjectController.mahasiswa.daftarMahasiswa());
            }
        });
        
        btnunverif.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnunverif.setForeground(Color.black);
                btnunverif.setBackground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnunverif.setForeground(Color.white);
                btnunverif.setBackground(Color.black);
            }
        });
        
        btnunverif.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.admin.unverifMahasiswa(kode);
                JOptionPane.showMessageDialog(null, "Berhasil Unverifikasi");
                tabelmahasiswa.setModel(AllObjectController.mahasiswa.daftarMahasiswa());
            }
        });
        
        btndelete.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btndelete.setForeground(Color.black);
                btndelete.setBackground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btndelete.setForeground(Color.white);
                btndelete.setBackground(Color.black);
            }
        });
        
        btndelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.admin.deleteData(kode);
                tabelmahasiswa.setModel(AllObjectController.mahasiswa.daftarMahasiswa());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA");
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
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                LoginAdminGui loginAdminGui = new LoginAdminGui();
                loginAdminGui.setVisible(true);
                dispose();
            }
        });
    }
}
