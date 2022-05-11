package com.mycompany.myapp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Services.GameService;
import com.codename1.components.ImageViewer;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Game;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ShowGame extends Inbox1Form {

    Container c = new Container(BoxLayout.x());
    Container cxx = new Container(BoxLayout.xCenter());

    public ShowGame(Resources res) {
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Games List", "Title")
                )
        );
        setLayout(BoxLayout.y());

        ArrayList<Game> List = GameService.getInstance().showGames();
        System.out.println("test2");

        for (Game cat : List) {

            addButton(cat, res);
        }

    }

    private void addButton(Game cat, Resources res) {

        Label name = new Label("Name : " + cat.getGameName(), "NewsTopLine1");
        Label description = new Label("Description : " + cat.getGameDescription(), "NewsTopLine1");
        Label link = new Label("Link : " + cat.getGameLink(), "NewsTopLine1");
        Label image = new Label("Image : " + cat.getGameImg(), "NewsTopLine1");
        Image logo;
        String file = "http://127.0.0.1:8000/uploads/games_pictures/" + cat.getGameImg();
        EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(this.getWidth() / 2, this.getHeight() / 5, 0xffff0000), true);
        Image im = URLImage.createToStorage(placeholder, file, file);
        ImageViewer imagea = new ImageViewer(im.scaled(120, 120));
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
                if (GameService.getInstance().deleteGame(cat.getGameId())) {
                    new ShowGame(res).show();
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
        lModifier.addPointerPressedListener(l -> {
            new EditGame(res, cat).show();
        });

        Container post = BoxLayout.encloseY(
                GridLayout.encloseIn(2, name, description), BorderLayout.centerAbsolute(GridLayout.encloseIn(1, link)), GridLayout.encloseIn(2, lModifier, lSupprimer));
        Container pub = BoxLayout.encloseY(
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                imagea
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
