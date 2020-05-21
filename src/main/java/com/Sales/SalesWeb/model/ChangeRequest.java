package com.Sales.SalesWeb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "change_request")
@Getter
@Setter
public class ChangeRequest {

    @Id
    private UUID changeRequestId;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    private String requestCod;

    private LocalDateTime changeRequestDate;
}
