/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
///package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entity.Equipe;
//import com.mycompany.myapp.entity.Participation;
import com.mycompany.myapp.entity.Tournoi;
import Utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author rouka
 */
public class TournoisService {
     public ArrayList<Equipe> equipes;
     public ArrayList<Tournoi> tournois;
   //  public ArrayList<Participation> participation;
    public static TournoisService instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public TournoisService() {
          req = new ConnectionRequest();
    }
  public static TournoisService getInstance() {
        if (instance == null) {
            instance = new TournoisService();
        }
        return instance;
    }
  
  
    public boolean addTeam(Equipe t) {
        System.out.println(t);
        System.out.println("********");
       //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
       String url = Statics.BASE_URL + "/equipe/newequipe/json";
    
       req.setUrl(url);
       req.setPost(false);
       req.addArgument("M", t.getMembre()+"");
       req.addArgument("N", t.getNom());
      
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
    
    
    
   
    
    
    
    
    

    public ArrayList<Equipe> parseTasks(String jsonText){
        try {
            equipes=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> equipeListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)equipeListJson.get("root");
            for(Map<String,Object> obj : list){
                Equipe t = new Equipe();
                float id = Float.parseFloat(obj.get("id").toString());
                  float membre = Float.parseFloat(obj.get("membres").toString());
                  t.setMembre((int)membre);
                t.setId((int)id);
               
              if (obj.get("nomEquipe")==null ){
                t.setNom("null");
            
                }
               else{
                t.setNom(obj.get("nomEquipe").toString());
               
                }
                equipes.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return equipes;
    }
    
    
    
    
    
    
    
    
    
    
    public ArrayList<Equipe> getAllteams(){
        req = new ConnectionRequest();
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"equipe/jsonequipe";
        System.out.println("===>"+url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                equipes = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return equipes;
    }
    
    
    
    
    
    
    
    /*
    
       public ArrayList<Participation> getAllPart(int id){
        req = new ConnectionRequest();
        //String url = Statics.BASE_URL+"/tasks/";
  String url = Statics.BASE_URL+"tournois/participants_json/"+id;
        System.out.println("===>"+url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                participation = parseParticipants(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return participation;
    }
     
   
     */

     public void delete(String id){
        req = new ConnectionRequest();
     
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"/equipe/equipedelete/"+id;
        System.out.println("===>"+url);
        req.setUrl(url);
        req.setPost(false);
           req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                equipes = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
       
   } 
     
     
     
     
     
     
     
     /*
    public ArrayList<Participation> parseParticipants(String jsonText){
        try {
            participation=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> equipeListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)equipeListJson.get("root");
            for(Map<String,Object> obj : list){
                Participation t = new Participation();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
              if (obj.get("tournoisNom")==null){
              
                t.setEquipe_nom("null");
            
                }
               else{
               
                  t.setEquipe_nom(obj.get("equipeNom").toString());
             
                }
                participation.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return participation;
    }
     
     */
     
     
     
     
     
     public boolean update(String id,String nom,String membre ){
          //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
         //String url = Statics.BASE_URL+"/equipe/EditE/"+id+"?"+"N="+nom+"&M="+membre;
           String url = Statics.BASE_URL+"/equipe/EditE/"+id;
        System.out.println("===>"+url);
        req.setUrl(url);
            req.setPost(false);
              req.addArgument("N",nom);
       req.addArgument("M",membre);
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
    
     
       public ArrayList<Tournoi> parseTournois(String jsonText){
        try {
            tournois=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tournoisListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tournoisListJson.get("root");
            for(Map<String,Object> obj : list){
                Tournoi t = new Tournoi();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
              //  t.setStatus(((int)Float.parseFloat(obj.get("status").toString())));
                if (obj.get("nomTournois")==null || obj.get("recompense")==null)
              t.setNom_tournois("null");
               
                else
                    t.setNom_tournois(obj.get("nomTournois").toString());
                t.setRecompense(obj.get("recompense").toString());
                t.setDate_tournois(obj.get("dateTournois").toString());
                tournois.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tournois;
    }
    
    public ArrayList<Tournoi> getAllTournois(){
        req = new ConnectionRequest();
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"/tournois/tournois";
        System.out.println("===>"+url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                tournois = parseTournois(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tournois;
    }

    
}
