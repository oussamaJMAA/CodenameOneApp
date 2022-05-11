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
import com.mycompany.myapp.entity.Cart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author louay
 */
public class CartService {

    public static CartService instance = null;
    String json;
    private boolean resultat;
    public ArrayList<Cart> cart;
    private MultipartRequest request;

    private final ConnectionRequest req;

    public static CartService getInstance() {
        if (instance == null) {
            instance = new CartService();
        }
        return instance;
    }

    public CartService() {
        req = new ConnectionRequest();
        request = new MultipartRequest();
    }

    public boolean deleteFromCart(int id) {
        String url = Statics.BASE_URL + "/panier/deleteMobile?id=" + id;

        req.setUrl(url);
        req.setPost(false);
        req.setFailSilently(true);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultat = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultat;
    }

    public void addProdToCart(int id) {
        try {
            String url = Statics.BASE_URL + "/panier/addMobile?id=" + id;

            System.out.println(url);
            req.setPost(true);

            req.setUrl(url);
            req.setFailSilently(true);

            req.addResponseListener(new ActionListener<NetworkEvent>() {
                @Override
                public void actionPerformed(NetworkEvent evt) {
                    System.out.println("action performed");

                    resultat = req.getResponseCode() == 200;
                    System.out.println(req.getResponseCode());
                    System.out.println(req.getRequestBody());
                    req.removeResponseListener(this);

                }
            });
            NetworkManager.getInstance().addToQueueAndWait(req);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Cart> parse(String jsonTxt) {
        try {
            cart = new ArrayList<>();

            JSONParser parser = new JSONParser();

            Map<String, Object> CategoriesJSON;
            CategoriesJSON = parser.parseJSON(new CharArrayReader(jsonTxt.toCharArray()));
            List<Map<String, Object>> listeRec;
            listeRec = (List<Map<String, Object>>) CategoriesJSON.get("root");

            for (Map<String, Object> item : listeRec) {
                Cart c = new Cart();

                float id = Float.parseFloat(item.get("id").toString());
                float prix = Float.parseFloat(item.get("produitPrix").toString());
                float quantity = Float.parseFloat(item.get("quantity").toString());
                float total = Float.parseFloat(item.get("total").toString());

                c.setId((int) id);
                c.setPrix((int) prix);
                c.setNom(item.get("produitName").toString());
                c.setImage(item.get("produitImage").toString());
                c.setQuantite((int) quantity);
                c.setTotal((int) total);
                cart.add(c);
            }
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println("aaa");
        }
        return cart;

    }

    public ArrayList<Cart> affichageCart() {
        request = new MultipartRequest();
        String url = Statics.BASE_URL + "/panier/showMobile";
        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    String dataaa = new String(request.getResponseData(), "utf-8");
                    cart = parse(dataaa);
                    request.removeResponseListener(this);
                } catch (Exception ex) {
                }
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(request);
        return cart;
    }
}
