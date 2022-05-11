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
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceTask {

    public ArrayList<User> users;
    
    public static ServiceTask instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceTask() {
         req = new ConnectionRequest();
    }

    public static ServiceTask getInstance() {
        if (instance == null) {
            instance = new ServiceTask();
        }
        return instance;
    }
  
    
    public boolean SignIn(User t) {
        
        System.out.println(t);
        System.out.println("********");
       //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
       String url = Statics.BASE_URL + "/jsonSignin";
    
       req.setUrl(url);
       req.setPost(false);
       req.addArgument("U", t.getUsername());
        req.addArgument("P", t.getPassword());
       req.addResponseListener(netEvent-> {
String data="";
try{
    data=new String(req.getResponseData(),"utf-8");
}catch(UnsupportedEncodingException ex){
    System.out.println(ex.getMessage());
}
if (data.equals("passowrd not found")){
    Dialog.show("ERROR", "wrong password", new Command("OK"));
    resultOK=false;
}else if ( data.equals("user not found")){
     Dialog.show("ERROR", "Account doesn't exist", new Command("OK"));
    resultOK=false;
}else{
    resultOK=true;
    
}

        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
  public String role(User t){
      String role="";
      if (SignIn(t)){
            String url = Statics.BASE_URL + "/jsonSignin";
    
       req.setUrl(url);
       req.setPost(false);
       req.addArgument("U", t.getUsername());
        req.addArgument("P", t.getPassword());
        String data="";
try{
    data=new String(req.getResponseData(),"utf-8");
}catch(UnsupportedEncodingException ex){
    System.out.println(ex.getMessage());
}if (data.equals("client")){

    role="client";
}
else role="admin";
        
      }
      
      return role ;
    }
    public boolean addUser(User t) {
        resultOK=true;
        System.out.println(t);
        System.out.println("********");
       //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
       String url = Statics.BASE_URL + "/jsonregister";
    
       req.setUrl(url);
       req.setPost(false);
       req.addArgument("F", t.getFirstname());
       req.addArgument("L", t.getLastname());
       req.addArgument("U", t.getUsername());
       req.addArgument("E", t.getEmail());
        req.addArgument("P", t.getPassword());
       req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String data="";
try{
    data=new String(req.getResponseData(),"utf-8");
}catch(UnsupportedEncodingException ex){
    System.out.println(ex.getMessage());
}
if (data.equals("Account already exists!")){
    Dialog.show("ERROR", "Account already exists!", new Command("OK"));
    resultOK=false;

}
else if (req.getResponseCode()!= 200){//Code HTTP 200 OK
                resultOK = false; 
}
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<User> parseTasks(String jsonText){
        try {
            users=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                User t = new User();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
               
                if (obj.get("firstname")==null || obj.get("lastname").toString()==null|| obj.get("username").toString()==null ||obj.get("email").toString()==null){
                t.setFirstname("null");
                t.setLastname("null");
                t.setUsername("null");
                t.setEmail("null");
                }
                else{
                t.setFirstname(obj.get("firstname").toString());
                t.setLastname(obj.get("lastname").toString());
                t.setUsername(obj.get("username").toString());
                t.setEmail((obj.get("email").toString()));
                }
                users.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return users;
    }
    
    public ArrayList<User> getAllUsers(){
        req = new ConnectionRequest();
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"/users";
        System.out.println("===>"+url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                users = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return users;
    }
   public void delete(String id){
        req = new ConnectionRequest();
     
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"/userD/"+id;
        System.out.println("===>"+url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                users = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
       
   } 
   public boolean update(String id,String firstname,String username ){
        //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
        String url = Statics.BASE_URL+"/EditD/"+id;
        System.out.println("===>"+url);
        req.setUrl(url);
         req.setPost(false);
           req.addArgument("F",firstname);
       req.addArgument("U",username);
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
