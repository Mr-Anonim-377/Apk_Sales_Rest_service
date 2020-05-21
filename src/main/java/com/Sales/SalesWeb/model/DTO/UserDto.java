package com.Sales.SalesWeb.model.DTO;

import com.Sales.SalesWeb.model.Image;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String firstName;

    private String lastName;

    private Image image;

    public UserDto(String firstName, String lastName, Image image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
    }

}
