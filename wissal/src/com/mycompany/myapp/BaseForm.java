/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.mycompany.myapp;

import Utils.SessionManager;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.util.Resources;

/**
 * Utility methods common to forms e.g. for binding the side menu
 *
 * @author Shai Almog
 */
public class BaseForm extends Form {

    public void installSidemenu(Resources res) {
        Image selection = res.getImage("line.png");

        Image inboxImage = null;
        if (isCurrentInbox()) {
            inboxImage = selection;
        }

        Image trendingImage = null;
        if (isCurrentTrending()) {
            trendingImage = selection;
        }

        Image calendarImage = null;
        if (isCurrentCalendar()) {
            calendarImage = selection;
        }

        Image statsImage = null;
        if (isCurrentStats()) {
            statsImage = selection;
        }

        // spacer
        getToolbar().addComponentToSideMenu(new Label(res.getImage("profile_image.png"), "Container"));
        getToolbar().addComponentToSideMenu(new Label("Detra Mcmunn", "SideCommandNoPad"));
        getToolbar().addComponentToSideMenu(new Label(" ", "SideCommand"));
          getToolbar().addCommandToSideMenu("All Users", null, e -> {
            new AllUsers(res).show();
        });
  getToolbar().addCommandToSideMenu("Menu", null, e -> {
            new InboxForm().show();
        });
        getToolbar().addCommandToSideMenu("Add category", null, e -> {
            new AddCategory(res).show();
        });
        getToolbar().addCommandToSideMenu("list category", null, e -> {
            new ShowCategory(res).show();
        });
        getToolbar().addCommandToSideMenu("Add game", null, e -> {
            new AddGame(res).show();
        });
        getToolbar().addCommandToSideMenu("list games", null, e -> {
            new ShowGame(res).show();
        });
         getToolbar().addCommandToSideMenu("Orders", null, e -> {
            new ShowOrdersAdmin(res).show();
        });
            getToolbar().addCommandToSideMenu("Promotions", null, e -> {
            new AllPromotion(res).show();
        });
              getToolbar().addCommandToSideMenu("Add Promotion", null, e -> {
            new AddPromotion(res).show();
        });
            getToolbar().addCommandToSideMenu("Sign out", null, e -> {
                     SessionManager.setEmail(null);
            new SignIn().show();
        });


    }

    protected boolean isCurrentInbox() {
        return false;
    }

    protected boolean isCurrentTrending() {
        return false;
    }

    protected boolean isCurrentCalendar() {
        return false;
    }

    protected boolean isCurrentStats() {
        return false;
    }
}
