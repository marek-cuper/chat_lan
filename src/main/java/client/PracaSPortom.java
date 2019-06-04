package client;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;

public class PracaSPortom {

    public static int nastavPortKlienta() {
        int skusanyPort = 6667;
        do {
            if (volnyPort(skusanyPort)) {
                return skusanyPort;
            } else {
                skusanyPort++;
            }
        } while (true);

    }


    public static boolean volnyPort(int port) {

        ServerSocket ss = null;
        DatagramSocket ds = null;
        try {
            ss = new ServerSocket(port);
            ss.setReuseAddress(true);
            ds = new DatagramSocket(port);
            ds.setReuseAddress(true);
            return true;
        } catch (IOException e) {
        } finally {
            if (ds != null) {
                ds.close();
            }

            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                }
            }
        }

        return false;
    }
}
