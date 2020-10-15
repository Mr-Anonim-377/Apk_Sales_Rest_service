package com.Sales.SalesWeb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "persons")
@Getter
@Setter
public class Person {

    @Id
    private UUID personId;

    private String personPhone;

    private String firstName;

    private String lastName;
}