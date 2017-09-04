import java.util.ArrayList;

public class Product {
    private String naam;
    private String producent;
    private int prijs;
    public static ArrayList<Product> productList = new ArrayList<>();

    public Product(String naam, String producent, int prijs) {
        this.naam = naam;
        this.producent = producent;
        this.prijs = prijs;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    @Override
    public String toString() {
        return "Product{" +
                "naam='" + naam + '\'' +
                ", producent='" + producent + '\'' +
                ", prijs=" + prijs +
                '}';
    }

    public String toJson() {
        return "Registratie{" +
                "\"naam\" :'" + naam + '\'' +
                ", \"producent\" :'" + producent + '\'' +
                ", \"prijs\" :'" + prijs + '\'' +
                '}';
    }
}
