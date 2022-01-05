package Controller;

import Entity.PaketEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class PaketController implements PaketConInterface{

    @Override
    public ArrayList<PaketEntity> showAllDataA() {
        return AllObjectModel.paket.getAllPaketA();
    }

    @Override
    public ArrayList<PaketEntity> showAllDataB() {
        return AllObjectModel.paket.getAllPaketB();
    }
    
    public DefaultTableModel daftarPaketA(){
        DefaultTableModel paket = new DefaultTableModel();
        Object[] kolom = {"PAKET","JURUSAN","HARGA"};
        paket.setColumnIdentifiers(kolom);
        int size = showAllDataA().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[3];
            data[0] = AllObjectModel.paket.getAllPaketA().get(i).getPaket();
            data[1] = AllObjectModel.paket.getAllPaketA().get(i).getJurusan();
            data[2] = AllObjectModel.paket.getAllPaketA().get(i).getHarga();
            paket.addRow(data);
        }
        return paket;
    }
    
    public DefaultTableModel daftarPaketB(){
        DefaultTableModel paket = new DefaultTableModel();
        Object[] kolom = {"Paket","JURUSAN","HARGA"};
        paket.setColumnIdentifiers(kolom);
        int size = showAllDataB().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[3];
            data[0] = AllObjectModel.paket.getAllPaketB().get(i).getPaket();
            data[1] = AllObjectModel.paket.getAllPaketB().get(i).getJurusan();
            data[2] = AllObjectModel.paket.getAllPaketB().get(i).getHarga();
            paket.addRow(data);
        }
        return paket;
    }
}
