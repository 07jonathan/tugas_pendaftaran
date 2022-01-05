package Entity;

public class PaketEntity {
    private String paket;
    private String jurusan;
    private String harga;

    public PaketEntity(String paket, String jurusan, String harga) {
        this.paket = paket;
        this.jurusan = jurusan;
        this.harga = harga;
    }

    public PaketEntity() {
    }

    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
