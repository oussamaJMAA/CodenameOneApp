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
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;

/**
 *
 * @author oussa
 */
public class DeleteAccount  extends Form {
    Form previous ;
    public DeleteAccount(Resources res ) {
        previous = new Menu(res);
        setTitle("Delete a User");
        TextField id = new TextField("", "userid");
        Button btnDelete = new Button("Delete");
        addAll(id, btnDelete);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
      /*  btnDelete.addActionListener(ev -> {
            ServiceTask.getInstance().delete(id.getText().toString());
        });
        */
         btnDelete.addActionListener(new ActionListener(){
                 
                 
                    @Override
            public void actionPerformed(ActionEvent evt) {
              
                           Dialog.show("Success","Your account is deleted",new Command("OK"));
                              
                          ServiceTask.getInstance().delete(SessionManager.getEmail());
                          new SignIn().show();
                            
                  
                }
                
                
            
        });
        
    }

}
