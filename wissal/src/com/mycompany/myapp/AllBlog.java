/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.BlogService;
import Services.TournoisService;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Blog;
import com.mycompany.myapp.entity.Tournoi;
import java.util.ArrayList;

/**
 *
 * @author oussa
 */
public class AllBlog extends Form {
      Form current,previous;
    Resources r;
    
    Container c = new Container(BoxLayout.x());
    Container cxx = new Container(BoxLayout.xCenter());
  
    public AllBlog(Resources r){
        previous = new Menu(r);
         getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Blog List", "Title")
                )
        );
        setLayout(BoxLayout.y());
        

            ArrayList<Blog> test = BlogService.getInstance().getAllBlogs();
       
            
            
for (Blog cat : test) {

            addButton(cat, r);
        }
   getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }
    
    
    private void addButton(Blog cat, Resources res) {

        Label name = new Label(cat.getTitre(), "NewsTopLine1");
        Label description = new Label("Contenu : " + cat.getContenu(), "NewsTopLine1");
      Label name4 = new Label("IGAME");
    
      
      Container post = BoxLayout.encloseY(
                GridLayout.encloseIn(2, name, description), BorderLayout.centerAbsolute(GridLayout.encloseIn(1,name4)));
        Container pub = BoxLayout.encloseY(
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                //imagea
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
