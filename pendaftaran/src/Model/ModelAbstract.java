package Model;

import Helper.KoneksiDb;
import java.sql.Connection;

public abstract class ModelAbstract {
    Connection conn = KoneksiDb.getconnection();
    public abstract int cekLogin(String npm, String Password);
}
