package Entity;

public class AdminEntity extends UserEntityAbstract {
    private String npm;
    public AdminEntity(String nama, String npm, String password, String noTelp){
        super(nama,password,noTelp);
        this.npm = npm;
    }
    
    public String getNpm(){ 
        return npm; 
    }
    public void setNpm(String npm){ 
        this.npm = npm; 
    }
}
