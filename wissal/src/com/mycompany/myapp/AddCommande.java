/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import Services.CommandeService;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Commande;
import com.mycompany.myapp.entity.Product;
import java.text.SimpleDateFormat;

/**
 *
 * @author User
 */
public class AddCommande extends Form {
Form previous;
    public AddCommande(Resources res, Product prod) {
      /*  getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Commande", "Title")
                )
        );*/   previous = new Menu(res);
           setTitle("Add command");
        setLayout(BoxLayout.y());

        setLayout(BoxLayout.y());
        Label prodName = new Label(prod.getNom());
        TextField nbr = new TextField("", "Nbr products...");
        ComboBox combo = new ComboBox();
        combo.addItem("Cheque");
        combo.addItem("Espece");

        Picker dateStart = new Picker();
        dateStart.setType(Display.PICKER_TYPE_DATE);

        Button btnValider = new Button("Order");
        btnValider.setUIID("InboxNumber3");
        btnValider.addActionListener((l) -> {
            if (prodName.getText().isEmpty() || nbr.getText().isEmpty()) {
                Dialog.show("Please fill all the fields", "", "Cancel", "OK");
            } else {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                InfiniteProgress ip = new InfiniteProgress();
                final Dialog iDialog = ip.showInfiniteBlocking();
                Commande cmd = new Commande(
                        Integer.parseInt(nbr.getText()),
                        format.format(dateStart.getDate()),
                        combo.getSelectedItem().toString()
                );

                CommandeService.getInstance().addCommande(prod.getId(), cmd);

                iDialog.dispose();
                new ShowProducts(res).show();
                refreshTheme();
            }
        });
 getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        addAll(prodName, nbr, combo, dateStart, btnValider);

    }
}
