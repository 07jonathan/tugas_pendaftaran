package Model;

import Entity.MahasiswaEntity;
import java.sql.*;
import java.util.ArrayList;

//manipulasi dta, menangani validas dari control tdk berhubungan dgn view
public class MahasiswaModel extends ModelAbstract {
    private String sql;
    
    public ArrayList<MahasiswaEntity> getMahasiswa(){ //getMhs->mengambil dta mhs dri database
        ArrayList<MahasiswaEntity> arraylistMahasiswa = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM mahasiswa";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                MahasiswaEntity mahasiswaEntity = new MahasiswaEntity();
                mahasiswaEntity.setId(rs.getInt("id"));
                mahasiswaEntity.setNama(rs.getString("nama"));
                mahasiswaEntity.setNpm(rs.getString("npm"));
                mahasiswaEntity.setPassword(rs.getString("password"));
                mahasiswaEntity.setnoTelp(rs.getString("noTelp"));
                mahasiswaEntity.setStatus(rs.getInt("status"));
                mahasiswaEntity.setPaket(rs.getString("paket"));
                arraylistMahasiswa.add(mahasiswaEntity);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistMahasiswa; //mengembalikan kumpulandata yg  didpt kedlm arraylistMhs
    }
    
    public ArrayList<MahasiswaEntity> getMahasiswa(int id){
        ArrayList<MahasiswaEntity> arrMahasiswa = new ArrayList<>();
        try {
            sql = "SELECT * FROM mahasiswa where id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                MahasiswaEntity mahasiswaEntity = new MahasiswaEntity();
                
                mahasiswaEntity.setId(rs.getInt("id"));
                mahasiswaEntity.setNama(rs.getString("nama"));
                mahasiswaEntity.setNpm(rs.getString("npm"));
                mahasiswaEntity.setPassword(rs.getString("password"));
                mahasiswaEntity.setnoTelp(rs.getString("noTelp"));
                mahasiswaEntity.setStatus(rs.getInt("status"));
                
                mahasiswaEntity.setPaket(rs.getString("paket"));
                arrMahasiswa.add(mahasiswaEntity);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }return arrMahasiswa;
    }
    
    public void insertData(MahasiswaEntity MahasiswaEntity) {
        try {
            sql = "INSERT INTO mahasiswa (nama, npm, password, noTelp, paket) Values(?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, MahasiswaEntity.getNama());
            stat.setString(2, MahasiswaEntity.getNpm());
            stat.setString(3, MahasiswaEntity.getPassword());
            stat.setString(4, MahasiswaEntity.getnoTelp());
            stat.setString(5, MahasiswaEntity.getPaket());
            
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("GAGAL INPUT DATA!!!");
            e.printStackTrace();
        }
    }
    
    public void updateNama(String nama, int id){
        try{
            sql = "update mahasiswa SET nama =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH NAMA!!!");
            e.printStackTrace();
        }
    }
    
    public void updateNpm(String npm, int id){
        try{
            sql = "update mahasiswa SET npm =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, npm);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH NPM!!!");
            e.printStackTrace();
        }
    }
    
    public void updateNoTelp(String noTelp, int id){
        try{
            sql = "update mahasiswa SET noTelp =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, noTelp);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH NOMOR!!!");
            e.printStackTrace();
        }
    }
    
    public void updatePassword(String password, int id){
        try{
            sql = "update mahasiswa SET password =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, password);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH PASSWORD!!!");
            e.printStackTrace();
        }
    }
    
    public void updatePaket(String paket, int id){
        try{
            sql = "update mahasiswa SET paket =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, paket);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH PAKET!!!");
            e.printStackTrace();
        }
    }
    
    public int cekLogin(String npm, String password){
        int cek = 0;
        try{
            sql = "SELECT * FROM mahasiswa where npm = ? and password = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, npm);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getInt("id");
                String nama = rs.getString("nama");
                System.out.println("Selamat Datang " + nama);
            } else {
                cek = 0;
            }
        } catch (SQLException e){
            e.printStackTrace();
        } return cek;
    }
    
    public int cekVerif(int id){
        int cek = 0;
        try {
            sql = "SELECT * FROM mahasiswa where id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getInt("status");
            } else {
                cek = 0;
            }
        } catch (Exception e){
            e.printStackTrace();
        } return cek;
    }
}