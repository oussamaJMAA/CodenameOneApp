/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;


import Services.CategoryService;
import com.codename1.components.ScaleImageLabel;
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
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;


import com.mycompany.myapp.entity.Promotion;
import Services.ServicePromotion;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.TextField;
import com.mycompany.myapp.entity.Category;

/**
 *
 * @author MSI GAMMING
 */
public class AddPromotion extends Form {

    String fileNameInServer;
    String ipath;
    String filePath = "";

    public AddPromotion(Resources res) {
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Add Promotion", "Title")
                )
        );
        setLayout(BoxLayout.y());

        setLayout(BoxLayout.y());

        TextField catTxt = new TextField("", "Name");
        TextField desc = new TextField("", "Prix Promotion");
          TextField dateD = new TextField("", "Date Debut");
            TextField dateF = new TextField("", "Date Fin");

        Button btnValider = new Button("Add");
        btnValider.setUIID("InboxNumber3");
        btnValider.addActionListener((e) -> {

            try {
                if (catTxt.getText() == "" || desc.getText() == "") {
                    Dialog.show("Verify your data", "", "cancel", "ok");
                } else {
                    InfiniteProgress ip = new InfiniteProgress();
                    final Dialog iDialog = ip.showInfiniteBlocking();
//String nom, String date, int prixPro, String datef
                    Promotion cat = new Promotion(
                            catTxt.getText(),
                            dateD.getText(),
                           Integer.parseInt(desc.getText()),
                            
                            dateF.getText()
                            
                            
                    );
                    System.out.println("data categorie ==" + cat);

                  ServicePromotion.getInstance().ajoutPromotion(cat);

                    iDialog.dispose();
                    new AllPromotion(res).show();
                    refreshTheme();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        addAll(catTxt, desc,dateD,dateF, btnValider);

    }
}
