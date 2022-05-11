/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.CategoryService;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Category;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ShowCategory extends Inbox1Form {

    Container c = new Container(BoxLayout.x());
    Container cxx = new Container(BoxLayout.xCenter());

    public ShowCategory(Resources res) {
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Category List", "Title")
                )
        );
        setLayout(BoxLayout.y());

        ArrayList<Category> List = CategoryService.getInstance().showAll();

        for (Category cat : List) {

            addButton(cat, res);
        }

    }

    private void addButton(Category cat, Resources res) {

        Label nomTxt = new Label("Nom : " + cat.getCategoryName(), "NewsTopLine1");
        Label desc = new Label("Description : " + cat.getDiscription(), "NewsTopLine1");

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
                if (CategoryService.getInstance().deleteCategory(cat.getCategoryId())) {
                    new ShowCategory(res).show();
                    //refreshTheme();
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
        lModifier.addPointerPressedListener(l -> {
            new EditCategory(res, cat).show();
        });
        //Container cnt = new Container();
        Container cnt = new Container(new BorderLayout()).add(BorderLayout.CENTER, BoxLayout.encloseY(BoxLayout.encloseX(nomTxt, desc, lModifier, lSupprimer)));

        add(cnt);
    }

}
