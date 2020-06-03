package com.example.android.navigationpatternlistdetail.provider;


import com.example.android.navigationpatternlistdetail.App;
import com.example.android.navigationpatternlistdetail.R;
import com.example.android.navigationpatternlistdetail.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanaskovic on 3/30/2018.
 */

public class ItemProvider {



    public  static Item getItemById(int id) {

        switch (id) {
            case 0:
                return new Item("Applepie", App.getContext().getString(R.string.description_applepie),"applepie.png");
            case 1:
                return new Item("Cheesecake", App.getContext().getString(R.string.description_cheesecake),"cheesecake.png");
            case 2:
                return new Item("Coffeecookies", App.getContext().getString(R.string.description_coffeecookies),"coffeecookies.png");
            case 3:
                return new Item("Donuts", App.getContext().getString(R.string.description_donuts),"donuts.png");
            case 4:
                return new Item("Fruitpie", App.getContext().getString(R.string.description_fruitpie),"fruitpie.png");
            case 5:
                return new Item("Lemonpie", App.getContext().getString(R.string.description_lemonpie),"lemonpie.png");
            case 6:
                return new Item("Macarons", App.getContext().getString(R.string.description_macarons),"macarons.png");
            case 7:
                return new Item("Moonpie", App.getContext().getString(R.string.description_moonpie),"moonpie.png");
            case 8:
                return new Item("Muffins", App.getContext().getString(R.string.description_muffins),"muffins.png");
            case 9:
                return new Item("Pancakes", App.getContext().getString(R.string.description_pancakes),"pancakes.png");
            case 10:
                return new Item("Pumpkinpie", App.getContext().getString(R.string.description_pumpkinpie),"pumpkinpie.png");
            default:
                return null;
        }
    }

}
