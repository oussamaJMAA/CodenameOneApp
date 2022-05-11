/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.ServiceTask;
import Services.TournoisService;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Tournoi;
import com.mycompany.myapp.entity.User;
import java.util.ArrayList;

/**
 *
 * @author oussa
 */
public class SearchTournois extends BaseForm{
     Form current;
    Form previous;

    public SearchTournois(Resources res) {
        setTitle("Liste des Torunois");
previous = new Menu(res);
        Container co;
        //search
        Toolbar.setGlobalToolbar(true);
        add(new InfiniteProgress());

        Display.getInstance().scheduleBackgroundTask(() -> {
            // this will take a while...
            Display.getInstance().callSerially(() -> {
                removeAll();
                ArrayList <Tournoi> produits = new ArrayList();
                TournoisService sa = new TournoisService();
                produits = sa.getAllTournois();
                for (Tournoi f : produits) {
                   MultiButton m = new MultiButton();
                  
                  m.setTextLine1("Nom : "+f.getNom());
                    m.setTextLine2("Recompense : " + f.getRecompense());

                    m.setTextLine3("Date : " + f.getDate_tournois());
                 

                    add(m);
                }
                revalidate();
            });
        });
        getToolbar().addSearchCommand(e -> {
            String text = (String) e.getSource();
            if (text == null || text.length() == 0) {
                // clear search
                for (Component cmp : getContentPane()) {
                    cmp.setHidden(false);
                    cmp.setVisible(true);
                }
                getContentPane().animateLayout(150);
            } else {
                text = text.toLowerCase();
                for (Component cmp : getContentPane()) {
                    MultiButton mb = (MultiButton) cmp;
                    String line1 = mb.getTextLine1();
                    String line2 = mb.getTextLine2();
                    boolean show = line1 != null && line1.toLowerCase().indexOf(text) > -1
                            || line2 != null && line2.toLowerCase().indexOf(text) > -1;
                    mb.setHidden(!show);
                    mb.setVisible(show);
                }
                getContentPane().animateLayout(150);
            }
        }, 4);
       
 getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }
    
    
}
