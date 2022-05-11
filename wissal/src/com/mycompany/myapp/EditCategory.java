/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

/**
 *
 * @author louay
 */
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
public class EditCategory extends Inbox1Form {

    String fileNameInServer;
    String ipath;
    String filePath = "";

    public EditCategory(Resources res, Category category) {
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Edit Category", "Title")
                )
        );
        setLayout(BoxLayout.y());

        setLayout(BoxLayout.y());

        TextField nom = new TextField(category.getCategoryName(), "Name");
        TextField description = new TextField(category.getDiscription(), "Description");

        // this(com.codename1.ui.util.Resources.getGlobalResources());
        Button btnValider = new Button("Edit");
        btnValider.setUIID("InboxNumber3");
        btnValider.addActionListener((e) -> {

            try {
                if (nom.getText().isEmpty() || description.getText().isEmpty()) {
                    Dialog.show("Verify your data", "", "cancel", "ok");
                } else {
                    InfiniteProgress ip = new InfiniteProgress();
                    final Dialog iDialog = ip.showInfiniteBlocking();
                    category.setCategoryName(nom.getText());
                    category.setDiscription(description.getText());

                    CategoryService.getInstance().editCategory(category.getCategoryId(), nom, description);

                    iDialog.dispose();
                    new ShowCategory(res).show();
                    refreshTheme();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        addAll(nom, description, btnValider);

    }
}
