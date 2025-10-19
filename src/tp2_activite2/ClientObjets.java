package tp2_activite2;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientObjets {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1235);
        System.out.println("Connecté au serveur d'objets !");
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le premier nombre: ");
        double nb1 = scanner.nextDouble();
        System.out.print("Entrez l'opérateur (+, -, *, /): ");
        String op = scanner.next();
        System.out.print("Entrez le deuxième nombre: ");
        double nb2 = scanner.nextDouble();
        String data = nb1 + "," + op + "," + nb2;
        out.write(data);
        out.newLine();
        out.flush();
        System.out.println("Données envoyées: " + data);
        String resultatData = in.readLine();
        Operation resultat = Operation.fromString(resultatData);
        System.out.println("Résultat reçu: " + resultat.nombre1 + " " + 
                          resultat.operateur + " " + resultat.nombre2 + " = " + resultat.resultat);
        scanner.close();
        in.close();
        out.close();
        socket.close();
    }
}