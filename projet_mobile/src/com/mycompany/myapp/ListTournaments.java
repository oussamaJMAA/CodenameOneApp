/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;
//package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Insets;
import com.codename1.ui.util.Resources;

import com.mycompany.myapp.entity.Equipe;
//import com.mycompany.myapp.entity.Participation;
import com.mycompany.myapp.entity.Tournoi;

import Services.TournoisService;
import java.util.ArrayList;
import Services.GameService;
import com.codename1.components.ImageViewer;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Game;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rouka
 */
public class ListTournaments extends Form{
     Form current,previous;
    Resources r;
    
    Container c = new Container(BoxLayout.x());
    Container cxx = new Container(BoxLayout.xCenter());
  
    public ListTournaments(Resources r){
        
        previous = new Menu(r);
          Button Rech = new Button("Rechercher");
        Rech.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                   new SearchTournois(r).show();
            }
        });
        add(Rech);
         getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Tournament List", "Title")
                )
        );
        setLayout(BoxLayout.y());
        

            ArrayList<Tournoi> test = TournoisService.getInstance().getAllTournois();
       
            
            
for (Tournoi cat : test) {

            addButton(cat, r);
        }
   getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }
    
    
    private void addButton(Tournoi cat, Resources res) {

        Label name = new Label(cat.getNom(), "NewsTopLine1");
        Label description = new Label("Recompense : " + cat.getRecompense(), "NewsTopLine1");
        Label link = new Label("Date : " + cat.getDate_tournois().substring(0, 10), "NewsTopLine1");
      
    
      
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
