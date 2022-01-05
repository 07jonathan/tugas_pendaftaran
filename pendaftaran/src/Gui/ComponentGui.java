package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ComponentGui extends JFrame {
    protected JButton btnregister = new JButton("DAFTAR");
    protected JButton btnnotreg = new JButton("DAFTAR");
    protected JButton btnlogin = new JButton("LOG IN");
    protected JButton btnback = new JButton("KEMBALI");
    protected JButton btndelete = new JButton("DELETE");
    protected JButton btnverif = new JButton("VERIFIKASI");
    protected JButton btnunverif = new JButton("UNVERIFIKASI");
    
    protected JLabel labelregister = new JLabel("REGISTER");
    protected JLabel labellogin = new JLabel("LOGIN");
    protected JLabel labelid = new JLabel("ID");
    protected JLabel labelnama = new JLabel("NAMA");
    protected JLabel labelnpm = new JLabel("NPM");
    protected JLabel labelpassword = new JLabel("PASSWORD");
    protected JLabel labelnotelp = new JLabel("NO TELP");
    protected JLabel labelpaket = new JLabel("PAKET");
    protected JLabel bingkaigambar = new JLabel();
    protected JLabel header = new JLabel("HOME");
    
    protected JTextField fieldnama = new JTextField();
    protected JTextField fieldnpm = new JTextField();
    protected JPasswordField fieldpassword = new JPasswordField();
    protected JTextField fieldnotelp = new JTextField();
    protected JTextField fieldpaket = new JTextField();
    
    protected JButton btnubahnama = new JButton("Ubah");
    protected JButton btnubahnpm = new JButton("Ubah");
    protected JButton btnubahpassword = new JButton("Ubah");
    protected JButton btnubahnotelp = new JButton("Ubah");
    protected JButton btnubahpaket = new JButton("Ubah");
    protected JComboBox jComboBoxPaket = new JComboBox(); 
    
    BufferedImage bufferedImage = null;
    Image gambarresize;
    
    void kosong(){
        fieldnama.setText(null);
        fieldnpm.setText(null);
        fieldpassword.setText(null);
        fieldnotelp.setText(null);
    }
}