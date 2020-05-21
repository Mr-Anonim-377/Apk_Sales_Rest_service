package com.Sales.SalesWeb.controller.requestDto.UserRequest;

import com.Sales.SalesWeb.model.Image;
import com.Sales.SalesWeb.model.Person;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.UUID;
@Data
public class    UserResponse {

    private String personPhone;

    private String firstName;

    private String lastName;

    private String email;

    private Image image;

    public UserResponse(String personPhone, String firstName, String lastName, String email, Image image) {
        this.personPhone = personPhone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.image = image;
    }

    public boolean isNull(){
        boolean isNull = false;
        if (personPhone == null) {
            isNull = true;
        }
        if (firstName == null) {
            isNull = true;
        }
        if (lastName == null) {
            isNull = true;
        }
        if (email == null) {
            isNull = true;
        }
        if (image == null) {
            isNull = true;
        }
        return isNull;
    }

    public void clear(){
    personPhone = null;
    firstName = null;
    lastName = null;
    email = null;
    image = null;
    }
}
