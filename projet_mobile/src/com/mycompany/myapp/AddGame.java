/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.GameService;
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
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Game;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author User
 */
public class AddGame extends Inbox1Form {

    String fileNameInServer;
    String ipath;
    String filePath = "";

    protected String saveFileToDevice(String hi, String ext) throws IOException {
        URI uri;
        try {
            uri = new URI(hi);
            String path = uri.getPath();
            int index = hi.lastIndexOf("/");
            hi = hi.substring(index + 1);
            return hi;
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }
        return "error";
    }

    public AddGame(Resources res) {
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Add Game", "Title")
                )
        );
        setLayout(BoxLayout.y());

        setLayout(BoxLayout.y());

        TextField name = new TextField("", "Name...");
        TextField description = new TextField("", "Description...");
        TextField link = new TextField("", "Link...");

        Helper.myComboBox CategorieBox = Helper.createComboBox(Statics.BASE_URL + "/category/mobile/getAll", "id", "name", "id");
        addStringValue("Category", CategorieBox.Box);
        TextField categorie = new TextField("", "choose category!");
        categorie.setUIID("textFieldBlack");

        Button btnValider = new Button("Add");
        btnValider.setUIID("InboxNumber3");

        Button img1 = new Button("select an image");
        CheckBox multiSelect = new CheckBox("multi");
        img1.addActionListener((ActionEvent e) -> {
            if (FileChooser.isAvailable()) {
                FileChooser.setOpenFilesInPlace(true);
                FileChooser.showOpenDialog(multiSelect.isSelected(), ".jpg, .jpeg, .png", (ActionEvent e2) -> {
                    if (e2 == null || e2.getSource() == null) {
                        add("no file selected");
                        revalidate();
                        return;
                    }
                    if (multiSelect.isSelected()) {
                        String[] paths = (String[]) e2.getSource();
                        for (String path : paths) {
                            System.out.println(path);
                            CN.execute(path);
                        }
                        return;
                    }
                    String file = (String) e2.getSource();
                    System.out.println("here : " + file);
                    if (file == null) {
                        add("no file selected");
                        revalidate();
                    } else {
                        String extension = null;
                        if (file.lastIndexOf(".") > 0) {
                            try {
                                StringBuilder hi = new StringBuilder(file);
                                if (file.startsWith("file://")) {
                                    hi.delete(0, 7);
                                }
                                int lastIndexPeriod = hi.toString().lastIndexOf(".");
                                Log.p(hi.toString());
                                String ext = hi.toString().substring(lastIndexPeriod);
                                String hmore = hi.toString().substring(0, lastIndexPeriod - 1);

                                String namePic = saveFileToDevice(file, ext);
                                System.err.println(namePic);
                                btnValider.addActionListener((ev) -> {

                                    try {
                                        if (name.getText().isEmpty() || description.getText().isEmpty() || link.getText().isEmpty()) {
                                            Dialog.show("Please fill all the fields", "", "Cancel", "OK");
                                        } else {
                                            InfiniteProgress ip = new InfiniteProgress();
                                            final Dialog iDialog = ip.showInfiniteBlocking();
                                            Game game = new Game(
                                                    String.valueOf(name.getText()).toString(),
                                                    String.valueOf(description.getText()).toString(),
                                                    String.valueOf(link.getText()).toString(),
                                                    namePic,
                                                    String.valueOf(CategorieBox.getSelected().uniqueId)
                                            );

                                            GameService.getInstance().addGame(game);

                                            iDialog.dispose();
                                            new ShowGame(res).show();
                                            refreshTheme();
                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                });
                            } catch (IOException ex) {
                            }
                            revalidate();
                        }
                    }
                });
            }
        });

        addAll(name, description, link, img1, btnValider);

    }

    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel"))
                .add(BorderLayout.CENTER, v));
    }
}
