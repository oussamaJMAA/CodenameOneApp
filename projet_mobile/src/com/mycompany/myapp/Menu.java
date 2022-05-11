/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import Services.ServiceTask;
import Utils.SessionManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author rouka
 */
public class Menu extends Form{
    Form current;
    public Menu(Resources res) {
  getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Home2", "Title")
                )
        );
         Toolbar tb = getToolbar();
        current=this; //Back 
        setTitle("Home");
        Label a = new Label("welcome "+SessionManager.getEmail());
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        Button btnAddUser = new Button("Add a team");
      //  Button btnListUsers = new Button("List of teams");
Button tournaments = new Button("All tournaments");
      Button update = new Button("Update a team");
        Button Delete = new Button("Delete a team");
          Button Products = new Button("All products");
             Button mycart = new Button("My cart");
                Button myorders = new Button("My orders");
                Button delete = new Button("Delete Account");
                Button edit = new Button("Edit Account");
                Button pub = new Button("Blog");
        Button signout = new Button("Sign out");
        btnAddUser.addActionListener(e-> new AddTeam(res).show());
  signout.addActionListener(new ActionListener(){
                 
                 
                    @Override
            public void actionPerformed(ActionEvent evt) {
                 
               
                 SessionManager.setEmail(null);
                          
                            new SignIn().show();     
                          
            
                }
        
        });
  delete.addActionListener(new ActionListener(){
                 
                 
                    @Override
            public void actionPerformed(ActionEvent evt) {
                 ServiceTask.getInstance().delete(SessionManager.getEmail());
                  Dialog.show("Success","Your account is deleted",new Command("OK"));
                 SessionManager.setEmail(null);
                          new SignIn().show();
                            
                          
                
                }
                
                
            
        });
  
        tournaments.addActionListener(e-> new ListTournaments(res).show());
update.addActionListener(e-> new EditTeam(res).show());
Delete.addActionListener(e-> new DeleteTeam(res).show());
Products.addActionListener(e-> new ShowProducts(res).show());
mycart.addActionListener(e-> new ShowCart(res).show());
myorders.addActionListener(e-> new ShowOrders(res).show());
edit.addActionListener(e-> new EditAccount(res).show());
pub.addActionListener(e->new AllBlog(res).show());
        addAll(tournaments,btnAddUser,update,Delete,Products,mycart,myorders,edit,delete,pub,signout);
        
         
        
    }
    
}
