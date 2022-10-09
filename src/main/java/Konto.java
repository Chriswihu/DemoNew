import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Konto //lav commit og lav om til Konto
{
    private String navn;
    private String kode;
    private int saldo;

    private List<String> transaktioner = new ArrayList<>();

    public Konto(String navn, String kode)
    {
        this.navn = navn;
        this.kode = kode;
        this.saldo = 0;
    }

    public Konto(String navn, String kode, int saldo)
    {
        this.navn = navn;
        this.kode = kode;
        this.saldo = saldo;
    }

    public static void OpretKonto() throws SQLException{

        String sql = "INSERT INTO KontoData (KontoNavn, KontoKode, KontoSaldo) VALUES (?, ?, ?)";

        try (Connection con = ConnectionConfig.getConnection();

             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            ps.setString(1, TerminalInput.getString("Indtast navn: "));
            ps.setString(2, TerminalInput.getString("Indtast adresse: "));
            ps.setInt(3, TerminalInput.getInt("Indtast postnummer: "));

            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);

            System.out.println("Kunde med id nummer " + id + " er nu oprettet");

        }
    }

    public String getNavn()
    {
        return navn;
    }

    public String getKode()
    {
        return kode;
    }

    public int getSaldo() {
        return saldo;
    }

    public List<String> getTransaktioner() {
        return transaktioner;
    }

    @Override
    public String toString()
    {
        return "Bruger{" + "navn='" + navn + '\'' + ", kode='" + kode + '\'' + '}';
    }

    public int withdraw(int i) {

        if(i < 0){
            transaktioner.add(navn + " forsøger at hæve " + i + " ny Saldo " + saldo + transaktioner.size()+1);
            return saldo;
        }
        saldo = saldo - i;
        transaktioner.add(navn + " forsøger at hæve " + i + " ny Saldo " + saldo + transaktioner.size()+1);
        return saldo;
    }

    public int deposit(int i) {
        if(i < 0) {
            transaktioner.add(navn + " forsøger at indsætte " + i + " ny Saldo " + saldo + transaktioner.size()+1);
            return saldo;
        }
        saldo = saldo + i;
        transaktioner.add(navn + " forsøger at indsætte " + i + " ny Saldo " + saldo + transaktioner.size()+1);
        return saldo;
    }
}
