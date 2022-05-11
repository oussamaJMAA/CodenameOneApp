package com.mycompany.myapp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Services.CartService;
import Services.PDF;
import Services.ProductService;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Product;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ShowProducts extends Form {

    Container c = new Container(BoxLayout.x());
    Container cxx = new Container(BoxLayout.xCenter());
Form previous;
    public ShowProducts(Resources res) {
      /*  getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Products List", "Title")
                )
        );
*/
       Button Rech = new Button("Rechercher");
        Rech.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                   new SearchProduit(res).show();
            }
        });
        add(Rech);
      Button pdf = new Button("PDF");
      previous = new Menu(res);
        setLayout(BoxLayout.y());
   setTitle("All Products");
        ArrayList<Product> List = ProductService.getInstance().affichageProduits();
        System.out.println("test2");

        for (Product cat : List) {

            addButton(cat, res);
        }
        
       
            pdf.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent evt) {
                                         
                                            if (Dialog.show("Confirmation", "Voulez vous imprimer cette produit en pdf ?", "Oui", "Annuler")) {
                                                
                                                                
                                                                      
                                                                      
                                                                        Dialog.show("Success","imprimer",new Command("OK"));
                                                                        new PDF(res).show();
                                                           //new AllReclamation(res).show();
                                                                      
                                                                  

                                            }
                                }
                            });
                       add(pdf);
                      

    }

    private void addButton(Product cat, Resources res) {

        Label name = new Label("Name : " + cat.getNom(), "NewsTopLine1");
        Label price = new Label("Price : " + cat.getPrix(), "NewsTopLine1");
        Label quantity = new Label("Quantity : " + cat.getQuantite(), "NewsTopLine1");
        String file = "http://127.0.0.1:8000/uploads/" + cat.getImage();
        //EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(this.getWidth() / 2, this.getWidth() / 5, 0xffff0000), true);
       // URLImage background = URLImage.createToStorage(placeholder, file, file);
       // background.fetch();
      // ImageViewer image = new ImageViewer(background);
        Label addToCart = new Label("Add to cart ");
        addToCart.setUIID("NewsTopLine");
        Style cartStyle = new Style(addToCart.getUnselectedStyle());
        cartStyle.setFgColor(0xf21f1f);
        FontImage cartImage = FontImage.createMaterial(FontImage.MATERIAL_SHOP, cartStyle);
        addToCart.setIcon(cartImage);
        addToCart.setTextPosition(RIGHT);
        //click
        addToCart.addPointerPressedListener(l -> {
            Dialog dig = new Dialog("Adding to cart");
            if (dig.show("Add", "Are you sure you want to Add this product to your cart?", "Cancel", "Yes")) {
                dig.dispose();
            } else {
                dig.dispose();
                System.out.println(cat.getId());
                CartService.getInstance().addProdToCart(cat.getId());
                new ShowCart(res).show();
               refreshTheme();

            }
        });

        Label order = new Label("Order ");
        order.setUIID("NewsTopLine");
        Style orderStyle = new Style(order.getUnselectedStyle());
        orderStyle.setFgColor(0xf21f1f);
        FontImage orderImage = FontImage.createMaterial(FontImage.MATERIAL_MONEY, cartStyle);
        order.setIcon(orderImage);
        order.setTextPosition(RIGHT);
        //click
        order.addPointerPressedListener(l -> {
            new AddCommande(res, cat).show();
           refreshTheme();

        });

        Container post = BoxLayout.encloseY(
                GridLayout.encloseIn(2, name, price), GridLayout.encloseIn(2, quantity, addToCart), GridLayout.encloseIn(1, order));
        Container pub = BoxLayout.encloseY(
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                             //  image
                        )
                ),
                BoxLayout.encloseY(post)
        );

        pub.getStyle().setFgColor(0xffffff);
        pub.getStyle().setBgColor(0xadd8e6);
        pub.getStyle().setBgTransparency(255);
        pub.getStyle().setPadding(7, 7, 7, 7);
        pub.getStyle().setMargin(20, 20, 30, 30);
        pub.getStyle().setBorder(Border.createRoundBorder(50, 50));
 getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        add(pub);
    }

}
