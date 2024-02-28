package com.pashonokk.springvaadintestapp.front;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {
    public MainLayout() {
        addToNavbar(new DrawerToggle());
        addToNavbar(new Paragraph("Spring Vaadin Test App"));

        addToDrawer(new RouterLink("Users List", UsersList.class));
    }
}
