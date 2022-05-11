/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;


import Services.GameService;
import Services.TournoisService;
import Utils.Helper;
import Utils.Statics;
import com.codename1.components.InfiniteProgress;
import com.codename1.ext.filechooser.FileChooser;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.CN;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Equipe;
import com.mycompany.myapp.entity.Game;
import com.mycompany.myapp.entity.Tournoi;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author rouka
 */
public class AddTeam extends Form {
      String fileNameInServer;
    String ipath;
    String filePath = "";
Form previous;
   

    public AddTeam(Resources res) {
        previous = new Menu(res);
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Add Team", "Title")
                )
        );
        setLayout(BoxLayout.y());

        setLayout(BoxLayout.y());

        TextField name = new TextField("", "Name...");
        TextField description = new TextField("", "Members");
    

      
        Button btnValider = new Button("Add");
        btnValider.setUIID("InboxNumber3");
   btnValider.addActionListener((ev) -> {
      try {
                                        if (name.getText().isEmpty() || description.getText().isEmpty()) {
                                            Dialog.show("Please fill all the fields", "", "Cancel", "OK");
                                        } else {
                                            InfiniteProgress ip = new InfiniteProgress();
                                            final Dialog iDialog = ip.showInfiniteBlocking();
                                            Equipe game = new Equipe(
                                                   Integer.valueOf(description.getText()),
                                                    String.valueOf(name.getText()).toString()
                                                   
                                                   
                                            );

                                            TournoisService.getInstance().addTeam(game);

                                            iDialog.dispose();
                                            new Menu(res).show();
                                            refreshTheme();
                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
   });
    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        addAll(name, description,btnValider);

    }

}
