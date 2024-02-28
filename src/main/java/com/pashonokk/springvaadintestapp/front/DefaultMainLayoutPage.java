package com.pashonokk.springvaadintestapp.front;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
public class DefaultMainLayoutPage extends VerticalLayout {
    public DefaultMainLayoutPage() {
        add(new Paragraph("Welcome to Spring Vaadin Test App!"));
    }
}
