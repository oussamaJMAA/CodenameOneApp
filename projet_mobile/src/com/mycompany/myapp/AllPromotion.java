/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.GameService;
import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;

import com.mycompany.myapp.entity.Promotion;
import Services.ServicePromotion;
import Services.ServiceTask;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.myapp.entity.Game;
import com.mycompany.myapp.entity.User;
import java.util.ArrayList;

/**
 *
 * @author MSI GAMMING
 */
public class AllPromotion  extends InboxForm{ 
  
    Container c = new Container(BoxLayout.x());
    Container cxx = new Container(BoxLayout.xCenter());

    public AllPromotion(Resources res) {
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Promotion List", "Title")
                )
        );
        setLayout(BoxLayout.y());

        ArrayList<Promotion> List = ServicePromotion.getInstance().affichagePromotion();
        System.out.println("test2");

        for (Promotion cat : List) {

            addButton(cat, res);
        }

    }

    private void addButton(Promotion cat, Resources res) {

        Label name = new Label("Name : " + cat.getNom(), "NewsTopLine1");
        Label description = new Label("Prix : " + cat.getPrixPro(), "NewsTopLine1");
        Label link = new Label("Date Debut : " + cat.getDate(), "NewsTopLine1");
        Label image = new Label("Date Fin : " + cat.getDatef(), "NewsTopLine1");
       
        Label lSupprimer = new Label(" ");
        lSupprimer.setUIID("NewsTopLine");
        Style supprimerStyle = new Style(lSupprimer.getUnselectedStyle());
        supprimerStyle.setFgColor(0xf21f1f);
        FontImage supprimerImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprimerStyle);
        lSupprimer.setIcon(supprimerImage);
        lSupprimer.setTextPosition(RIGHT);
        //click
        lSupprimer.addPointerPressedListener(l -> {
            Dialog dig = new Dialog("Deleting");
            if (dig.show("Deleting", "Are you sure you want to delete this ?", "Cancel", "Yes")) {
                dig.dispose();
            } else {
                dig.dispose();
                if (ServicePromotion.getInstance().deletePromotion(cat.getId())) {
                    new AllPromotion(res).show();
                    refreshTheme();
                }
            }
        });
        //Update button
        Label lModifier = new Label(" ");
        lModifier.setUIID("NewsTopLine");
        Style modifierStyle = new Style(lModifier.getUnselectedStyle());
        modifierStyle.setFgColor(0xf7ad02);
        FontImage mFontImage = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle);
        lModifier.setIcon(mFontImage);
        lModifier.setTextPosition(LEFT);
        Promotion p = new Promotion(cat.getId(),cat.getNom(),cat.getDate(),cat.getPrixPro(),cat.getDatef());
        lModifier.addPointerPressedListener(l -> {
           new ModifierPromotion(res,p).show();
        });

        Container post = BoxLayout.encloseY(
                GridLayout.encloseIn(2, name, description), BorderLayout.centerAbsolute(GridLayout.encloseIn(1, link)), GridLayout.encloseIn(2, lModifier, lSupprimer));
        Container pub = BoxLayout.encloseY(
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                              //  imagea
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
