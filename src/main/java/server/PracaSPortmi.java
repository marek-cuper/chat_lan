package server;

import java.util.ArrayList;
import java.util.List;

public class PracaSPortmi {


    public static boolean nachadzaSaPortVZozname(int port, List<Integer> zoznamPortov) {
        if (zoznamPortov.size() != 0) {
            for (int i = 0; i <= zoznamPortov.size(); i++) {
                if (port == zoznamPortov.get(i)) {
                    return true;
                }
            }
            return false;
        }
        else return false;
    }

}

