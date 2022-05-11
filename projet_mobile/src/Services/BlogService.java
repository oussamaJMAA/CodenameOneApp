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
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;

import com.mycompany.myapp.entity.User;
import Utils.SessionManager;
import Utils.Statics;
import com.mycompany.myapp.entity.Blog;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author oussa
 */
public class BlogService {
    public ArrayList<Blog> blog;
    
    public static BlogService instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private BlogService() {
         req = new ConnectionRequest();
    }

    public static BlogService getInstance() {
        if (instance == null) {
            instance = new BlogService();
        }
        return instance;
    }
    
    
     public ArrayList<Blog> parseTasks(String jsonText){
        try {
            blog=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Blog t = new Blog();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
               
                if (obj.get("titre")==null || obj.get("contenu").toString()==null){
                t.setTitre("null");
                t.setContenu("null");
              
                }
                else{
                t.setTitre(obj.get("titre").toString());
                t.setContenu(obj.get("contenu").toString());
             
                }
                blog.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return blog;
    }
        public ArrayList<Blog> getAllBlogs(){
        req = new ConnectionRequest();
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"/jsonblog";
        System.out.println("===>"+url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                blog = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return blog;
    }
    
    
    
}
