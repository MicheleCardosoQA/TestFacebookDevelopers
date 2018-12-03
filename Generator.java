package suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {
    // Classe pars retornar data e hora
    public static String dataHoraParaArquivo() {
        Timestamp ts = new Timestamp((System.currentTimeMillis()));
        return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
    }
}
