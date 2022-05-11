/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entities.Publication;
import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author RYANG
 */
public class PublicationService {

    private boolean resultat;
    public static PublicationService instance = null;
    public ArrayList<Publication> Publications;
    private MultipartRequest req;

    public static PublicationService getInstance() {
        if (instance == null) {
            instance = new PublicationService();
        }
        return instance;
    }

    public PublicationService() {
        req = new MultipartRequest();
    }
    
    public ArrayList<Publication> parse(String jsonTxt) {
        try {
            Publications = new ArrayList<>();

            JSONParser parser = new JSONParser();

            System.out.println(jsonTxt);
            Map<String, Object> EvenementsJSON;
            EvenementsJSON = parser.parseJSON(new CharArrayReader(jsonTxt.toCharArray()));
            List<Map<String, Object>> listeRec;
            listeRec = (List<Map<String, Object>>) EvenementsJSON.get("root");

            for (Map<String, Object> item : listeRec) {

                Publication ev = new Publication();

                float id = Float.parseFloat(item.get("id").toString());

                ev.setId((int) id);
                ev.setTitre(item.get("titre").toString());
                ev.setContenu(item.get("contenu").toString());

                Publications.add(ev);
            }
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println("aaa");
        }
        return Publications;

    }
    
        public ArrayList<Publication> showPublications() {
        req = new MultipartRequest();
        ArrayList<Publication> result = new ArrayList<>();
        String url = Statics.BASE_URL + "/mobile/getAll";
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    Publications = parse(new String(req.getResponseData(), "utf-8"));
                    req.removeResponseListener(this);
                } catch (Exception ex) {

                }
            }

        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return Publications;
    }

}
