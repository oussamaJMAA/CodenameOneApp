/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.ServiceTask;
import Utils.SessionManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;


/**
 *
 * @author oussa
 */
public class EditAccount extends Form  {
    Form previous;
    public EditAccount(Resources res){
        previous = new Menu(res);
      TextField nom = new TextField("", "firstname");
        TextField username = new TextField("", "username");
        Button btnUpdate = new Button("Update");
          addAll(nom,username, btnUpdate);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        btnUpdate.addActionListener(ev -> {
            ServiceTask.getInstance().update(SessionManager.getEmail(),nom.getText().toString(),username.getText().toString());
            
             Dialog.show("Success","Account updated ",new Command("OK"));
             
        });
}}
