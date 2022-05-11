/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import com.mycompany.myapp.*;
import Entities.Publication;
import Services.PublicationService;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
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
import java.util.ArrayList;

/**
 *
 * @author RYANG
 */
public class Blogs extends Inbox1Form{
    Container c = new Container(BoxLayout.y());
    Form hi = new Form("pub List", new BorderLayout());
    
    public Blogs(Resources res) {
        c.setScrollableY(true);

        ArrayList<Publication> List = PublicationService.getInstance().showPublications();
        System.out.println("test2");

        for (Publication cat : List) {
            System.out.println("test 4");
            MultiButton mb = new MultiButton("Titre Pub : " + cat.getTitre());
            mb.setTextLine2("Further details...");
            c.add(mb);
            
        }
        hi.add(CENTER,c);
        hi.show();

    }
    
    
}
