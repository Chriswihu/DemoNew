public class Bruger
{
    private String navn;
    private String kode;


    public Bruger(String navn, String kode)
    {
        this.navn = navn;
        this.kode = kode;
    }


    public String getNavn()
    {
        return navn;
    }

    public String getKode()
    {
        return kode;
    }


    @Override
    public String toString()
    {
        return "Bruger{" + "navn='" + navn + '\'' + ", kode='" + kode + '\'' + '}';
    }
}
