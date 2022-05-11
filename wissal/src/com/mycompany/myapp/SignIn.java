/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.ServiceTask;
import Utils.SessionManager;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.User;

/**
 *
 * @author oussa
 */
public class SignIn  extends Form{
    Resources res;
    String fileNameInServer;
    String ipath;
    String filePath = "";
    Form current;
public SignIn(){
             current=this;
     setTitle("Sign In");
         setLayout(BoxLayout.y());
        setLayout(BoxLayout.y());
         TextField tfFUsername = new TextField("","Username");
        TextField tfPassword = new TextField(null,"Password",0,TextField.PASSWORD);
           Button btnValider = new Button("SignIn");
                   SpanLabel sp = new SpanLabel();
                   sp.setText("                                OR");
         
    
    
             Button r = new Button("Register");
               btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfFUsername.getText().length()==0)||(tfPassword.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                       InfiniteProgress ip = new InfiniteProgress();
                    final Dialog iDialog = ip.showInfiniteBlocking();
                    
                        User u = new User(tfFUsername.getText().toString(),tfPassword.getText().toString());
                        if( ServiceTask.getInstance().role(u)=="admin")
                        {
                           
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                            SessionManager.setEmail(tfFUsername.getText().toString());
                           iDialog.dispose();
                   new InboxForm().show();
                    refreshTheme();
                        }
                        else if( ServiceTask.getInstance().role(u)=="client")
                        {
                               SessionManager.setEmail(tfFUsername.getText().toString());
                            new Menu(res).show();
                          // System.out.println("client");
                  
                        }
                        
                        else{
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                      iDialog.dispose();
                  
                        }
                }
                
                
            }
        });
                r.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              
                      new Register(current).show();
                }
                
                
            
        });
                 addAll(tfFUsername,tfPassword,btnValider,sp,r);

}
    
}
