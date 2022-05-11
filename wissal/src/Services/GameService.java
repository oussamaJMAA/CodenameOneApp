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
import com.mycompany.myapp.entity.Game;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author louay
 */
public class GameService {

    private boolean resultat;
    public static GameService instance = null;
    public ArrayList<Game> Games;
    private MultipartRequest req;

    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    public GameService() {
        req = new MultipartRequest();
    }

    public boolean addGame(Game game) {
        String url = Statics.BASE_URL + "/game/mobile/add?idCategory=" + game.getIdCategory()
                + "&name=" + game.getGameName()
                + "&description=" + game.getGameDescription()
                + "&link=" + game.getGameLink()
                + "&image=" + game.getGameImg();
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

    public ArrayList<Game> parse(String jsonTxt) {
        try {
            Games = new ArrayList<>();

            JSONParser parser = new JSONParser();

            System.out.println(jsonTxt);
            Map<String, Object> EvenementsJSON;
            EvenementsJSON = parser.parseJSON(new CharArrayReader(jsonTxt.toCharArray()));
            List<Map<String, Object>> listeRec;
            listeRec = (List<Map<String, Object>>) EvenementsJSON.get("root");

            for (Map<String, Object> item : listeRec) {

                Game ev = new Game();

                float id = Float.parseFloat(item.get("id").toString());

                ev.setGameId((int) id);
                ev.setGameName(item.get("name").toString());
                ev.setGameDescription(item.get("description").toString());
                ev.setGameLink(item.get("link").toString());
                ev.setGameImg(item.get("image").toString());

                Games.add(ev);
            }
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println("aaa");
        }
        return Games;

    }

    public ArrayList<Game> showGames() {
        req = new MultipartRequest();
        ArrayList<Game> result = new ArrayList<>();
        String url = Statics.BASE_URL + "/game/mobile/getAll";
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    Games = parse(new String(req.getResponseData(), "utf-8"));
                    req.removeResponseListener(this);
                } catch (Exception ex) {

                }
            }

        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return Games;
    }

    public boolean editGame(Game game) {
        String url = Statics.BASE_URL + "/game/mobile/edit?id=" + game.getGameId()
                + "&name=" + game.getGameName()
                + "&description=" + game.getGameDescription()
                + "&link=" + game.getGameLink()
                + "&image=" + game.getGameImg();
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

    public boolean deleteGame(int id) {
        String url = Statics.BASE_URL + "/game/mobile/delete?id=" + id;

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
