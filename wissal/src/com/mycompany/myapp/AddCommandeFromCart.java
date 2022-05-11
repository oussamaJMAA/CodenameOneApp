/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Commande;
import java.text.SimpleDateFormat;

/**
 *
 * @author louay
 */
public class AddCommandeFromCart extends Form {
Form previous ;
    public AddCommandeFromCart(Resources res) {
        /*getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Order", "Title")
                )
        );*/
        setTitle("Add command from cart");
        previous = new Menu(res);
        setLayout(BoxLayout.y());

        setLayout(BoxLayout.y());

        ComboBox combo = new ComboBox();
        combo.addItem("Cheque");
        combo.addItem("Espece");

        Picker dateStart = new Picker();
        dateStart.setType(Display.PICKER_TYPE_DATE);

        Button btnValider = new Button("Order");
        btnValider.setUIID("InboxNumber3");
        btnValider.addActionListener((l) -> {
            if (combo.getSelectedItem() == null) {
                Dialog.show("Please fill all the fields", "", "Cancel", "OK");
            } else {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                InfiniteProgress ip = new InfiniteProgress();
                final Dialog iDialog = ip.showInfiniteBlocking();
                Commande cmd = new Commande(
                        format.format(dateStart.getDate()),
                        combo.getSelectedItem().toString()
                );

                CommandeService.getInstance().addCommande(0, cmd);

                iDialog.dispose();
                new ShowProducts(res).show();
                refreshTheme();
            }
        });
getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        addAll(combo, dateStart, btnValider);

    }
}
