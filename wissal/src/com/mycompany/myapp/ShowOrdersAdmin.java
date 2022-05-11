package com.mycompany.myapp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Services.CommandeService;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Commande;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ShowOrdersAdmin extends Inbox1Form {

    Container c = new Container(BoxLayout.x());
    Container cxx = new Container(BoxLayout.xCenter());

    public ShowOrdersAdmin(Resources res) {
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Orders", "Title")
                )
        );
        setLayout(BoxLayout.y());

        ArrayList<Commande> List = CommandeService.getInstance().showCommandes();
        System.out.println("test2");

        for (Commande cat : List) {

            addButton(cat, res);
        }

    }

    private void addButton(Commande cat, Resources res) {

        Label nb = new Label("Number of Profucts : " + cat.getNbProduct(), "NewsTopLine1");
        Label date = new Label("Date : " + cat.getDate(), "NewsTopLine1");
        Label method = new Label("Method of payment : " + cat.getMethod(), "NewsTopLine1");
        Label etat = new Label("Status : " + cat.getEtat(), "NewsTopLine1");
        Label total = new Label("Total Price : " + cat.getTotal(), "NewsTopLine1");
        Label lSupprimer = new Label("Delete Order");
        lSupprimer.setUIID("NewsTopLine");
        Style supprimerStyle = new Style(lSupprimer.getUnselectedStyle());
        supprimerStyle.setFgColor(0xf21f1f);
        FontImage supprimerImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprimerStyle);
        lSupprimer.setIcon(supprimerImage);
        lSupprimer.setTextPosition(RIGHT);
        //click
        lSupprimer.addPointerPressedListener(l -> {
            Dialog dig = new Dialog("Deleting");
            if (dig.show("Deleting", "Are you sure you want to delete this Order?", "Cancel", "Yes")) {
                dig.dispose();
            } else {
                dig.dispose();
                if (CommandeService.getInstance().deleteOrder(cat.getId())) {
                    new ShowOrdersAdmin(res).show();
                    refreshTheme();
                }
            }
        });
        //Update button
        Label edit = new Label("Update status");
        edit.setUIID("NewsTopLine");
        Style editStyle = new Style(edit.getUnselectedStyle());
        editStyle.setFgColor(0xf21f1f);
        FontImage editImage = FontImage.createMaterial(FontImage.MATERIAL_EDIT, supprimerStyle);
        edit.setIcon(editImage);
        edit.setTextPosition(RIGHT);
        //click
        edit.addPointerPressedListener(l -> {
            Dialog dig = new Dialog("Updating");
            if (dig.show("Updating", "Are you sure you want to set this Order as Done?", "Cancel", "Yes")) {
                dig.dispose();
            } else {
                dig.dispose();
                if (CommandeService.getInstance().editOrder(cat)) {
                    new ShowOrdersAdmin(res).show();
                    refreshTheme();
                }
            }
        });

        Container post = BoxLayout.encloseY(
                GridLayout.encloseIn(2, date, etat),
                GridLayout.encloseIn(2, method, total),
                GridLayout.encloseIn(2, edit, lSupprimer));
        Container pub = BoxLayout.encloseY(
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                nb
                        )
                ),//.add(BorderLayout.WEST, pubImage),
                BoxLayout.encloseY(post)
        );

        pub.getStyle().setFgColor(0xffffff);
        pub.getStyle().setBgColor(0xadd8e6);
        pub.getStyle().setBgTransparency(255);
        pub.getStyle().setPadding(7, 7, 7, 7);
        pub.getStyle().setMargin(20, 20, 30, 30);
        pub.getStyle().setBorder(Border.createRoundBorder(50, 50));

        add(pub);
    }

}
