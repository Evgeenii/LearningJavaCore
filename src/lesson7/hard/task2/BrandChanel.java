package lesson7.hard.task2;

import java.util.ArrayList;
import java.util.Collections;

public class BrandChanel {
    ArrayList<Shop> shops = new ArrayList<>();

    public BrandChanel(Shop... shops) {
        for (Shop shop : shops) {
            Collections.addAll(this.shops, shops);
        }

    }



    public ArrayList<Shop> getShops() {
        return shops;
    }

    public void setShops(ArrayList<Shop> shops) {
        this.shops = shops;
    }
}
