/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;


import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextComponent;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;

import com.mycompany.myapp.entity.Promotion;

import Services.ServicePromotion;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author MSI GAMMING
 */
public class ModifierPromotion extends Form{
    
     String Imagecode;
    String filePath = "";
    
    public ModifierPromotion(Resources res,Promotion fa) {
     
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Modifier Promotion");
        getContentPane().setScrollVisible(false);

     

        tb.addSearchCommand(e -> {
        });
       
      TextComponent id = new TextComponent().label("id");
        id.text(Integer.toString(fa.getId()));
        add(id);
        
        TextComponent nom = new TextComponent().label("Nom");
        nom.text(fa.getNom());
        add(nom);
        
        TextComponent date = new TextComponent().label("date");
        date.text(fa.getDate());
        add(date);
        
        TextComponent datef = new TextComponent().label("datef");
        datef.text(fa.getDatef());
        add(datef);
        
        
       TextComponent prixPro = new TextComponent().label("prixPro");
       prixPro.text(String.valueOf(fa.getPrixPro()));
        add(prixPro);

        
        Button Modifier = new Button("Modifier");
        Button Screen = new Button("Screen");

        Modifier.addActionListener((evt) -> {
            if (nom.getText().equals("") || (date.getText().equals("")) || (datef.getText().equals("")) || (prixPro.getText().equals(""))) {
                Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
            } else {

                
 ServicePromotion sp = new ServicePromotion();
                Promotion fi = new Promotion();
            fi.setId(Integer.parseInt(id.getText()));
                fi.setNom(nom.getText());
                fi.setDate(date.getText());
                fi.setDatef(datef.getText());
                fi.setPrixPro(Integer.parseInt(prixPro.getText()));
               
                
                sp.EditPromotion(fi);
                Dialog.show("Success", "Promotiont modifiee avec success", new Command("OK"));
                new AllPromotion(res).show();

            }
        });

        addStringValue("", FlowLayout.encloseRightMiddle(Modifier));

     
       

    }

    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
     
    }

    
}
