package tp2_activite2;
import java.io.*;
import java.net.*;

public class ServeurObjets {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1235);
        System.out.println("Serveur d'objets en attente sur le port 1235...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connecté !");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String data = in.readLine();
        System.out.println("Données reçues: " + data);
        String[] parties = data.split(",");
        double nb1 = Double.parseDouble(parties[0]);
        String op = parties[1];
        double nb2 = Double.parseDouble(parties[2]);
        Operation operation = new Operation(nb1, nb2, op);
        switch (operation.operateur) {
            case "+": operation.resultat = operation.nombre1 + operation.nombre2; break;
            case "-": operation.resultat = operation.nombre1 - operation.nombre2; break;
            case "*": operation.resultat = operation.nombre1 * operation.nombre2; break;
            case "/": operation.resultat = operation.nombre1 / operation.nombre2; break;
        }
        System.out.println("Résultat calculé: " + operation.resultat);
        out.write(operation.toString());
        out.newLine();
        out.flush();
        System.out.println("Résultat envoyé au client");
        in.close();
        out.close();
        socket.close();
        serverSocket.close();
    }
}