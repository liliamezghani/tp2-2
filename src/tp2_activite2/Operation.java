package tp2_activite2;
import java.io.Serializable;

public class Operation implements Serializable {
    public double nombre1;
    public double nombre2;
    public String operateur;
    public double resultat;
    
    public Operation(double n1, double n2, String op) {
        this.nombre1 = n1;
        this.nombre2 = n2;
        this.operateur = op;
    }
    public String to string() {
        return nombre1 + "," + operateur + "," + nombre2 + "," + resultat;
    }
    public static Operation fromString(String data) {
        String[] parties = data.split(",");
        Operation op = new Operation(
            Double.parseDouble(parties[0]),
            Double.parseDouble(parties[2]),
            parties[1]
        );
        op.resultat = Double.parseDouble(parties[3]);
        return op;
    }
}