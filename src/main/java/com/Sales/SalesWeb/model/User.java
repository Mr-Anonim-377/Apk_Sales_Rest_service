package com.Sales.SalesWeb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    private UUID usersId;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    private String email;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image image;

    private String passwordHash;

    @OneToMany(mappedBy = "user")
    private List<ChangeRequest> changeRequests = new ArrayList<>();

}
