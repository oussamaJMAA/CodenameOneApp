/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.CategoryService;
import Services.ServiceTask;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Category;
import com.mycompany.myapp.entity.User;


/**
 *
 * @author oussa
 */
public class Register  extends Form{
    
    String fileNameInServer;
    String ipath;
    String filePath = "";

    public Register(Form previous) {
       
      setTitle("Create an account");
        setLayout(BoxLayout.y());
    

            TextField tfFname = new TextField("","Firstname");
        TextField tfLname = new TextField("","Lastname");
        TextField tfUsername = new TextField("","Username");
           TextField tfPassword = new TextField("","Password");
        TextField tfEmail = new TextField("","Email");

        Button btnValider = new Button("Add");
        btnValider.setUIID("InboxNumber3");
        btnValider.addActionListener((e) -> {

            try {
                if (tfFname.getText() == "" || tfLname.getText() == ""|| tfUsername.getText() == ""|| tfPassword.getText() == ""||tfEmail.getText() == "") {
                    Dialog.show("Verify your data", "", "cancel", "ok");
                } else {
                    InfiniteProgress ip = new InfiniteProgress();
                    final Dialog iDialog = ip.showInfiniteBlocking();

                   User u = new User(tfFname.getText().toString(), tfLname.getText().toString(),tfUsername.getText().toString(),tfEmail.getText().toString(),tfPassword.getText().toString());
                   

               if( ServiceTask.getInstance().addUser(u))
                        {
                           Dialog.show("Success","Account created",new Command("OK"));
                          
                new InboxForm().show();
                           iDialog.dispose();
                              
            
               
                    refreshTheme();
                        }else{
                            Dialog.show("ERROR", "Server error", new Command("OK"));
      iDialog.dispose();
               }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

          addAll(tfFname,tfLname,tfUsername ,tfEmail,tfPassword,btnValider);
           getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }
  
    
}
