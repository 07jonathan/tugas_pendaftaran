package Controller;

import Entity.MahasiswaEntity;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class MahasiswaController implements ControllerInterfaces {
    public void insertData(String nama, String npm, String password, String notelp, String paket){
        MahasiswaEntity mahasiswaEntities = new MahasiswaEntity();
        mahasiswaEntities.setNama(nama);
        mahasiswaEntities.setNpm(npm);
        mahasiswaEntities.setPassword(password);
        mahasiswaEntities.setnoTelp(notelp);
        mahasiswaEntities.setPaket(paket);
        AllObjectModel.mahasiswaModel.insertData(mahasiswaEntities);
    }
    
    public void updateData(int urut, String data, int id){
        switch(urut){
            case 1:
                AllObjectModel.mahasiswaModel.updateNama(data, id);
                break;
            case 2:
                AllObjectModel.mahasiswaModel.updateNpm(data, id);
                break;
            case 3:
                AllObjectModel.mahasiswaModel.updatePassword(data, id);
                break;
            case 4:
                AllObjectModel.mahasiswaModel.updateNoTelp(data, id);
                break;
            case 5:
                AllObjectModel.mahasiswaModel.updatePaket(data, id);
                break;
        }
    }
    
    public ArrayList<MahasiswaEntity> getDataMahasiswa(){
        return AllObjectModel.mahasiswaModel.getMahasiswa();
    }
    
    public int login(String npm, String password){
        int cek = AllObjectModel.mahasiswaModel.cekLogin(npm, password);
        return cek;
    }
    
    public ArrayList<MahasiswaEntity> getById(int ceklogin){
        return AllObjectModel.mahasiswaModel.getMahasiswa(ceklogin);
    }
    
    public int verif(int id){
        int cek = AllObjectModel.mahasiswaModel.cekVerif(id);
        return cek;
    }
    
    public DefaultTableModel daftarMahasiswa(){
        DefaultTableModel dataDaftarMahasiswa = new DefaultTableModel();
        Object[] kolom = {"ID", "NPM", "NAMA", "NOTELP", "STATUS", "PAKET"};
        dataDaftarMahasiswa.setColumnIdentifiers(kolom);
        int size = getDataMahasiswa().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[6];
            data[0] = AllObjectModel.mahasiswaModel.getMahasiswa().get(i).getId();
            data[1] = AllObjectModel.mahasiswaModel.getMahasiswa().get(i).getNpm();
            data[2] = AllObjectModel.mahasiswaModel.getMahasiswa().get(i).getNama();
            data[3] = AllObjectModel.mahasiswaModel.getMahasiswa().get(i).getnoTelp();
            data[4] = AllObjectModel.mahasiswaModel.getMahasiswa().get(i).getStatus();
            data[5] = AllObjectModel.mahasiswaModel.getMahasiswa().get(i).getPaket();
            dataDaftarMahasiswa.addRow(data);
        }
        return dataDaftarMahasiswa;
    }

    
}
