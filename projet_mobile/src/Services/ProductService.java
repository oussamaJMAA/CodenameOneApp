/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entity.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author louay
 */
public class ProductService {

    public static ProductService instance = null;
    String json;
    private boolean resultat;
    public ArrayList<Product> products;
    private MultipartRequest request;

    private final ConnectionRequest req;

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    public ProductService() {
        req = new ConnectionRequest();
        request = new MultipartRequest();
    }

    public ArrayList<Product> parse(String jsonTxt) {
        try {
            products = new ArrayList<>();

            JSONParser parser = new JSONParser();

            Map<String, Object> CategoriesJSON;
            CategoriesJSON = parser.parseJSON(new CharArrayReader(jsonTxt.toCharArray()));
            List<Map<String, Object>> listeRec;
            listeRec = (List<Map<String, Object>>) CategoriesJSON.get("root");

            for (Map<String, Object> item : listeRec) {
                Product prod = new Product();

                float id = Float.parseFloat(item.get("id").toString());
                float prix = Float.parseFloat(item.get("prix").toString());
                float quantite = Float.parseFloat(item.get("quantite").toString());

                prod.setId((int) id);
                prod.setImage(item.get("image").toString());
                prod.setNom(item.get("nom").toString());
                prod.setPrix((int) prix);
                prod.setQuantite((int) quantite);
                products.add(prod);
            }
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println("aaa");
        }
        return products;

    }

    public ArrayList<Product> affichageProduits() {
        request = new MultipartRequest();
        String url = Statics.BASE_URL + "/commande/mobile/getAllProducts";
        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    String dataaa = new String(request.getResponseData(), "utf-8");
                    products = parse(dataaa);
                    request.removeResponseListener(this);
                } catch (Exception ex) {
                }
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(request);
        return products;
    }
    
    

}
