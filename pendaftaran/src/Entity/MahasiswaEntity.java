package Entity;

public class MahasiswaEntity extends UserEntityAbstract {
    private String npm, paket; 
    private int status;
    
    public MahasiswaEntity(){};

    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }
    
    public String getNpm(){ 
        return npm; 
    }
    public int getStatus(){ 
        return status; 
    }
    
    public void setNpm(String npm) { 
        this.npm = npm; 
    }
    public void setStatus(int status) { 
        this.status = status; 
    }
}