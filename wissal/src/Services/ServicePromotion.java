/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;

import com.mycompany.myapp.entity.Promotion;
import Utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MSI GAMMING
 */
public class ServicePromotion {
    
     public static ServicePromotion instance = null;
    private ConnectionRequest req;

    public static ServicePromotion getInstance() {
        if (instance == null) {
            instance = new ServicePromotion();
        }
        return instance;
    }

    public ServicePromotion() {
        req = new ConnectionRequest();
    }
    
     public void ajoutPromotion(Promotion p) {
        String url = Statics.BASE_URL + "/promotionn/addPromotion?nom=" + p.getNom()
                + "&date=" + p.getDate() + "&datef=" + p.getDatef()
                + "&prixPro=" + p.getPrixPro() ;
        System.out.println(url);
        req.setUrl(url);
        req.addResponseListener((e) -> {

            String str = new String(req.getResponseData());
            //reponse json hedhi elli rynaha fil naviguateur 

            System.out.println("data == " + str);
        });

        NetworkManager.getInstance().addToQueueAndWait(req);//execution mtaie request sinon yitada chay dima nalkawha 

    }
     
     public void EditPromotion(Promotion p) {
        String url = Statics.BASE_URL + "/promotionn/updatePromotion";
        System.out.println(url);
        req.setUrl(url);
          req.setPost(false);
          req.addArgument("id",p.getId()+"");
       req.addArgument("nom",p.getNom());
       req.addArgument("date",p.getDate());
       req.addArgument("datef",p.getDatef());
        req.addArgument("prixPro",p.getPrixPro()+"");
        req.addResponseListener((e) -> {

            String str = new String(req.getResponseData());
            //reponse json hedhi elli rynaha fil naviguateur 

            System.out.println("data == " + str);
        });

        NetworkManager.getInstance().addToQueueAndWait(req);//execution mtaie request sinon yitada chay dima nalkawha 

    }
     
      //affichage 
    public ArrayList<Promotion> affichagePromotion() {

        ArrayList<Promotion> result = new ArrayList<>();
        String url = Statics.BASE_URL + "/promotionn/allPromotions";
        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp = new JSONParser();

                try {
                    Map<String, Object> mapPromotions = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));

                    List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) mapPromotions.get("root");

                    for (Map<String, Object> obj : listOfMaps) {

                        Promotion re = new Promotion();

                        //dima id fi codenameone float dima khir 
                        float id = Float.parseFloat(obj.get("id").toString());

                        String  nom = obj.get("nom").toString();

                        String date = obj.get("date").toString();

                       float prixPro = Float.parseFloat(obj.get("prixPro").toString());

                        String datef = obj.get("datef").toString();

                        re.setId((int) id);
                        re.setNom(nom);
                        re.setDate(date);
                        re.setPrixPro((int)prixPro);
                        re.setDatef(datef);
                      

                        //insert data into ArrayList result
                        result.add(re);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        );

        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;
    }
    
    
      public Promotion DetailPromotion(int id, Promotion p) {

        String url = Statics.BASE_URL + "/promotionn/detailPromotion?id" + id;
        req.setUrl(url);

        String str = new String(req.getResponseData());
        req.addResponseListener((evt) -> {
            JSONParser jsonp = new JSONParser();
           
            try {
                 Map<String, Object> obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                

                 p.setNom(obj.get("nom").toString());
                 p.setPrixPro((int)obj.get("prix"));
                 p.setDate( obj.get("date").toString());
                 p.setDatef( obj.get("datef").toString());
                 System.out.println(obj);
                 
           

            } catch (IOException ex) {
                System.out.println("error related to sql : ( " + ex.getMessage());
            }
            
            System.out.println("data ==="+str);

        });
                NetworkManager.getInstance().addToQueueAndWait(req);//execution mtaie request sinon yitada chay dima nalkawha 

                return p;
                
                
            }
     
      public boolean resultOK;

        public boolean deletePromotion(int id) {
        String url = Statics.BASE_URL + "/promotionn/delPromotion?id=" + id;
            System.out.println(url);
               req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
     
     
    
}
