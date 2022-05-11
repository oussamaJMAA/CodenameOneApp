/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.CommandeService;
import Services.ServiceTask;
import Services.TournoisService;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Commande;
import com.mycompany.myapp.entity.Tournoi;
import com.mycompany.myapp.entity.User;
import java.util.ArrayList;

/**
 *
 * @author oussa
 */
public class AllUsers  extends InboxForm{
      Form current,previous;
    Resources r;
    
    Container c = new Container(BoxLayout.x());
    Container cxx = new Container(BoxLayout.xCenter());
  
    public AllUsers(Resources r){
        
        Button Rech = new Button("Rechercher");
        Rech.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                   new SearchUsers(r).show();
            }
        });
        add(Rech);
    
        previous = new Menu(r);
         getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Users List", "Title")
                )
        );
        setLayout(BoxLayout.y());
        

            ArrayList<User> test = ServiceTask.getInstance().getAllUsers();
       
            
            
for (User cat : test) {

            addButton(cat, r);
        }
  
    }
      
    private void addButton(User cat, Resources res) {

        Label name = new Label("FistName : "+cat.getFirstname(), "NewsTopLine1");
        Label description = new Label("LastName : " + cat.getLastname(), "NewsTopLine1");
        Label link = new Label("Email : " + cat.getEmail(), "NewsTopLine1");
      
    
      
      Container post = BoxLayout.encloseY(
                GridLayout.encloseIn(2, name, description), BorderLayout.centerAbsolute(GridLayout.encloseIn(1, link)));
        Container pub = BoxLayout.encloseY(
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                //imagea
                        )
                ),//.add(BorderLayout.WEST, pubImage),
                BoxLayout.encloseY(post)
        );

      
      
        pub.getStyle().setFgColor(0xffffff);
        pub.getStyle().setBgColor(0xadd8e6);
        pub.getStyle().setBgTransparency(255);
        pub.getStyle().setPadding(7, 7, 7, 7);
        pub.getStyle().setMargin(20, 20, 30, 30);
        pub.getStyle().setBorder(Border.createRoundBorder(50, 50));

        add(pub);
    }

    
    
  
    
}
