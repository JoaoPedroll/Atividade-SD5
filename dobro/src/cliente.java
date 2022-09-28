import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class cliente extends Thread {
    static int valor = 10;

    public static void main(String[] args) {

        try {
            Socket cliente = new Socket("localhost", 1234);
            OutputStream output = cliente.getOutputStream();

            DataOutputStream dataOutput = new DataOutputStream(output);

            System.out.println("Valor mandado: " + valor);

            dataOutput.write(valor);
            dataOutput.flush();
            dataOutput.close();

            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}