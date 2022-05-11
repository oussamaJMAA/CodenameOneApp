/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import Services.TournoisService;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Equipe;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author rouka
 */
public class DeleteTeam extends Form{
      String fileNameInServer;
    String ipath;
    String filePath = "";

   Form previous;

    public DeleteTeam(Resources res) {
        previous = new Menu(res);
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Delete Team", "Title")
                )
        );
        setLayout(BoxLayout.y());

        setLayout(BoxLayout.y());
TextField id = new TextField("","ID");
      
      
        Button btnValider = new Button("Delete");
        btnValider.setUIID("InboxNumber3");
   btnValider.addActionListener((ev) -> {
      try {
                                        if (id.getText().isEmpty()) {
                                            Dialog.show("Please fill all the fields", "", "Cancel", "OK");
                                        } else {
                                            InfiniteProgress ip = new InfiniteProgress();
                                            final Dialog iDialog = ip.showInfiniteBlocking();
                                          

                                            TournoisService.getInstance().delete(id.getText());

                                            iDialog.dispose();
                                            new Menu(res).show();
                                            refreshTheme();
                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
   });
      getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        addAll(id,btnValider);

    }

}
