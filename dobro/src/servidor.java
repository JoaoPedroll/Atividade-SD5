import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor extends Thread{

    public static Socket cliente;

    public servidor(Socket cliente){
        this.cliente = cliente;
    }

    public static void main(String[] args) {

        try {
            ServerSocket servidor = new ServerSocket(1234);

            while (true){

                Socket cadaCliente = servidor.accept();
                new servidor(cadaCliente).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {


        InputStream input = null;
        try {
            input = cliente.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DataInputStream dataInput = new DataInputStream(input);

        int valor = 0;
        try {
            valor = dataInput.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Valor do dobrado: " + valor * 2);
    }
}
