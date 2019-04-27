package bo.nuevo.lifeissweet.utils;

import java.util.ArrayList;
import java.util.List;

import bo.nuevo.lifeissweet.R;
import bo.nuevo.lifeissweet.model.Bakery;

import bo.nuevo.lifeissweet.model.Bakery;

public class BakeryUtils {
    /**
     * Get list of pokemons
     *
     * @return List of bakerys in the pokedexCartilla
     */
    public static List<Bakery> getBakerys() {
        List<Bakery> bakerys = new ArrayList<>();
        bakerys.add(new Bakery(1, "Bomba_de_fruta", R.drawable.bomba_de_fruta, "Electric"));
        bakerys.add(new Bakery(2, "Hojaldre_de_Azucar", R.drawable.hojaldre_de_azucar, "Grass"));
        bakerys.add(new Bakery(3, "Hojaldre_de_Yema", R.drawable.hojaldre_de_yema, "Fire"));
        bakerys.add(new Bakery(4, "Hojaldre_de_frutas_del_bosque", R.drawable.hojaldre_de_frutas_del_bosque, "Water"));
        bakerys.add(new Bakery(5, "Pastel_De_Avellana", R.drawable.pastel_de_avellana, "Normal"));
        bakerys.add(new Bakery(6, "Pastel_De_Moka", R.drawable.pastel_de_moka, "Bug"));
        bakerys.add(new Bakery(7, "Pastel_De_frutos_rojos", R.drawable.pastel_de_frutos_rojos,"Poison"));
        bakerys.add(new Bakery(8, "Pastel_Reina", R.drawable.pastel_reina, "Normal"));
        bakerys.add(new Bakery(9, "Pastel_Song", R.drawable.pastel_song, "Normal"));
        bakerys.add(new Bakery(10, "Pastel_de_Almendra", R.drawable.patel_de_almendra, "Ground"));
        bakerys.add(new Bakery(11, "Piramide_de_3_Chocolates", R.drawable.piramide_de_3_chocolates, "Bug"));
        return bakerys;
    }

}
