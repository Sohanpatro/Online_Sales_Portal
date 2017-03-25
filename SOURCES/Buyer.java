

import java.awt.image.BufferedImage;
import java.util.Vector;

public class Buyer extends Customer {

    Buyer(int id, String n, String c, String t, String e, String p, BufferedImage im) {
        this.id = id;
        name = n;
        city = c;
        telephone = t;
        email = e;
        password = p;
        im_id = im;
    }

    Buyer() {
        ;
    }
}
