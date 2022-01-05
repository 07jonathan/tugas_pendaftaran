package Model;

import Helper.KoneksiDb;
import java.sql.Connection;

public abstract class PaketModelAbstract {
    Connection conn = KoneksiDb.getconnection();
}
