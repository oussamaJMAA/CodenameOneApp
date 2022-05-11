package com.mycompany.myapp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Services.CartService;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
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
import com.mycompany.myapp.entity.Cart;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ShowCart extends Form {

    Container c = new Container(BoxLayout.x());
    Container cxx = new Container(BoxLayout.xCenter());
Form previous;
    public ShowCart(Resources res) {
       /* getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("My cart", "Title")
                )
        ); */
       setTitle("Cart");
               previous = new Menu(res);
        setLayout(BoxLayout.y());

        ArrayList<Cart> List = CartService.getInstance().affichageCart();
        System.out.println("test2");

        for (Cart cat : List) {
            addButton(cat, res);
        }

        Button order = new Button("Order");
        add(order);

        order.addActionListener((l) -> {
            new AddCommandeFromCart(res).show();
        });

    }

    private void addButton(Cart cat, Resources res) {

        Label name = new Label("Name : " + cat.getNom(), "NewsTopLine1");
        Label price = new Label("Price : " + cat.getPrix(), "NewsTopLine1");
        Label quantity = new Label("Quantity : " + cat.getQuantite(), "NewsTopLine1");
        Label total = new Label("Total : " + cat.getTotal(), "NewsTopLine1");
        String file = "http://127.0.0.1:8000/uploads/" + cat.getImage();
        EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(this.getWidth() / 2, this.getWidth() / 5, 0xffff0000), true);
        URLImage background = URLImage.createToStorage(placeholder, file, file);
        background.fetch();
        ImageViewer image = new ImageViewer(background);
        Label addToCart = new Label("Delete from cart");
        addToCart.setUIID("NewsTopLine");
        Style cartStyle = new Style(addToCart.getUnselectedStyle());
        cartStyle.setFgColor(0xf21f1f);
        FontImage cartImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, cartStyle);
        addToCart.setIcon(cartImage);
        addToCart.setTextPosition(RIGHT);
        //click
        addToCart.addPointerPressedListener(l -> {
            Dialog dig = new Dialog("Deleting");
            if (dig.show("Delete", "Are you sure you want to delete this product from your cart?", "Cancel", "Yes")) {
                dig.dispose();
            } else {
                dig.dispose();
                System.out.println(cat.getId());
                CartService.getInstance().deleteFromCart(cat.getId());
                new ShowCart(res).show();
                refreshTheme();

            }
        });
        Container post = BoxLayout.encloseY(
                GridLayout.encloseIn(2, name, quantity), GridLayout.encloseIn(2, price, total), GridLayout.encloseIn(1, addToCart));
        Container pub = BoxLayout.encloseY(
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                image
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
