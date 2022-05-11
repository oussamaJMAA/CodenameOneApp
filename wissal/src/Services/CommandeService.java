/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entity.Commande;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author louay
 */
public class CommandeService {

    private boolean resultat;
    public static CommandeService instance = null;
    public ArrayList<Commande> commandes;
    private MultipartRequest req;

    public static CommandeService getInstance() {
        if (instance == null) {
            instance = new CommandeService();
        }
        return instance;
    }

    public CommandeService() {
        req = new MultipartRequest();
    }

    public boolean addCommande(int id, Commande cmd) {
        String url = Statics.BASE_URL + "/commande/mobile/add?id=" + id
                + "&nbr=" + cmd.getNbProduct()
                + "&date=" + cmd.getDate()
                + "&method=" + cmd.getMethod();
        req.setPost(true);

        req.setUrl(url);
        req.setFailSilently(true);
        System.out.println(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println("action performed");

                resultat = req.getResponseCode() == 200;

                req.removeResponseListener(this);

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultat;

    }

    public ArrayList<Commande> parse(String jsonTxt) {
        try {
            commandes = new ArrayList<>();

            JSONParser parser = new JSONParser();

            System.out.println(jsonTxt);
            Map<String, Object> EvenementsJSON;
            EvenementsJSON = parser.parseJSON(new CharArrayReader(jsonTxt.toCharArray()));
            List<Map<String, Object>> listeRec;
            listeRec = (List<Map<String, Object>>) EvenementsJSON.get("root");

            for (Map<String, Object> item : listeRec) {

                Commande cmd = new Commande();

                float id = Float.parseFloat(item.get("id").toString());
                float nb = Float.parseFloat(item.get("nb").toString());

                cmd.setDate(item.get("date").toString());
                cmd.setEtat(item.get("etat").toString());
                cmd.setMethod(item.get("method").toString());
                cmd.setId((int) id);
                cmd.setNbProduct((int) nb);
                cmd.setTotal(item.get("total").toString());

                commandes.add(cmd);
            }
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
        }
        return commandes;

    }

    public ArrayList<Commande> showCommandes() {
        req = new MultipartRequest();
        ArrayList<Commande> result = new ArrayList<>();
        String url = Statics.BASE_URL + "/commande/mobile/showAll";
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    commandes = parse(new String(req.getResponseData(), "utf-8"));
                    req.removeResponseListener(this);
                } catch (Exception ex) {

                }
            }

        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return commandes;
    }

    public boolean editOrder(Commande order) {
        String url = Statics.BASE_URL + "/commande/mobile/edit?id=" + order.getId();
        req.setUrl(url);
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

    public boolean deleteOrder(int id) {
        String url = Statics.BASE_URL + "/commande/mobile/delete?id=" + id;

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

}
