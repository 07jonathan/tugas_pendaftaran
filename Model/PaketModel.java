package Model;

import Entity.PaketEntity;
import java.sql.*;
import java.util.ArrayList;

public class PaketModel extends PaketModelAbstract{
    public ArrayList<PaketEntity> getAllPaketA() {
        ArrayList<PaketEntity> arrPaket = new ArrayList<>();
        try{
            String sql = "SELECT * from paketA";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                PaketEntity paket = new PaketEntity();
                paket.setPaket(rs.getString("paket"));
                paket.setJurusan(rs.getString("jurusan"));
                paket.setHarga(rs.getString("harga"));
                arrPaket.add(paket);
            }
        }catch(SQLException e){
            System.out.println(e);
        } return arrPaket;
    }
    
    public ArrayList<PaketEntity> getAllPaketB() {
        ArrayList<PaketEntity> arrPaket = new ArrayList<>();
        try{
            String sql = "SELECT * from paketB";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                PaketEntity paket = new PaketEntity();
                paket.setPaket(rs.getString("paket"));
                paket.setJurusan(rs.getString("jurusan"));
                paket.setHarga(rs.getString("harga"));
                arrPaket.add(paket);
            }
        }catch(SQLException e){
            System.out.println(e);
        } return arrPaket;
    }
}