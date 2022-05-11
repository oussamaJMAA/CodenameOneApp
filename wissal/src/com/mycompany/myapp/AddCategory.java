/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.CategoryService;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Category;

/**
 *
 * @author User
 */
public class AddCategory extends Inbox1Form {

    String fileNameInServer;
    String ipath;
    String filePath = "";

    public AddCategory(Resources res) {
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Add Category", "Title")
                )
        );
        setLayout(BoxLayout.y());

        setLayout(BoxLayout.y());

        TextField catTxt = new TextField("", "Name");
        TextField desc = new TextField("", "Description");

        Button btnValider = new Button("Add");
        btnValider.setUIID("InboxNumber3");
        btnValider.addActionListener((e) -> {

            try {
                if (catTxt.getText() == "" || desc.getText() == "") {
                    Dialog.show("Verify your data", "", "cancel", "ok");
                } else {
                    InfiniteProgress ip = new InfiniteProgress();
                    final Dialog iDialog = ip.showInfiniteBlocking();

                    Category cat = new Category(
                            String.valueOf(catTxt.getText()).toString(),
                            String.valueOf(desc.getText()).toString()
                    );
                    System.out.println("data categorie ==" + cat);

                    CategoryService.getInstance().addCategory(catTxt, desc);

                    iDialog.dispose();
                    new ShowCategory(res).show();
                    refreshTheme();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        addAll(catTxt, desc, btnValider);

    }
}
