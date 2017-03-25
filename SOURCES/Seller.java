

import java.awt.image.BufferedImage;

public class Seller extends Customer {

    Seller(int id, String n, String c, String t, String e, String p, BufferedImage im) {
        this.id = id;
        name = n;
        city = c;
        telephone = t;
        email = e;
        password = p;
        im_id = im;
    }

    Seller() {
    }
}
