public class Brugere
{
    private String navn;
    private String kode;

    public Brugere(String navn, String kode)
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
}
