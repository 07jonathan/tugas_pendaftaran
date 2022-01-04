package Controller;

import Entity.AdminEntity;

public class AdminController implements ControllerInterfaces {
    public void insertData(String nama, String npm, String password, String no_telp){
        AllObjectModel.adminModel.insertData(new AdminEntity(nama,npm,password,no_telp));
    }
    public void deleteData(int id){
        AllObjectModel.adminModel.deleteData(id);
    }
    public void verifMahasiswa(int id){
        AllObjectModel.adminModel.verifMahasiswa(id);
    }
    
    public void unverifMahasiswa(int id){
        AllObjectModel.adminModel.unverifMahasiswa(id);
    }
    
    @Override
    public int login(String npm, String password){
        int log = AllObjectModel.adminModel.cekLogin(npm, password);
        return log;
    }
}
