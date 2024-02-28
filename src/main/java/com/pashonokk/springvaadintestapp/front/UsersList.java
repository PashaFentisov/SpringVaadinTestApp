package com.pashonokk.springvaadintestapp.front;

import com.pashonokk.springvaadintestapp.entity.User;
import com.pashonokk.springvaadintestapp.service.UserService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Route(value = "users-list", layout = MainLayout.class)
public class UsersList extends VerticalLayout {
    private final RestTemplate restTemplate;
    private final Grid<User> grid = new Grid<>();

    public UsersList(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        configureGrid();
        add(new Paragraph("Users List"), grid);
    }

    private void configureGrid() {
        grid.addColumn(User::getId).setHeader("ID");
        grid.addColumn(User::getEmail).setHeader("Email");
        grid.addColumn(User::getName).setHeader("Name");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.setItems(getUsers());
        grid.setPartNameGenerator(user -> {
            if (user.getId()>=2) {
                return "styled-row";
            } else {
                return "";
            }
        });
    }

    private List<User> getUsers() {
        ResponseEntity<List<User>> entity = restTemplate.exchange(
                "http://localhost:8080/api/v1/users",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {}
        );
        return entity.getBody();
    }

}
