/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.util.Resources;

import com.mycompany.myapp.entity.Promotion;

import Services.ServicePromotion;
import java.util.ArrayList;

/**
 *
 * @author MSI GAMMING
 */
public class SearchPromotion  extends Form {
    Form current;

    public SearchPromotion (Resources res) {
        setTitle("Liste des Promotions");

        Container co;
        //search
        Toolbar.setGlobalToolbar(true);
        add(new InfiniteProgress());

        Display.getInstance().scheduleBackgroundTask(() -> {
            // this will take a while...
            Display.getInstance().callSerially(() -> {
                removeAll();
                ArrayList <Promotion> p= new ArrayList();
                ServicePromotion sa = new ServicePromotion();
                p = sa.affichagePromotion();
                for (Promotion f : p) {
                    MultiButton m = new MultiButton();
                    m.setTextLine1("Nom : " + f.getNom()+ " Prix : " + f.getPrixPro());
                   
                    m.setTextLine2("date: " + f.getDate());

                    m.setTextLine3("Datef : " + f.getDatef());

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
        //Tool Bar
     
                getToolbar().addCommandToSideMenu("Promotion", null, e -> new AllPromotion(res).show());


        getToolbar().addCommandToSideMenu("Logout", null, e -> new WalkthruForm(res).show());

    }
}
