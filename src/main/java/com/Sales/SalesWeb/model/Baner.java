package com.Sales.SalesWeb.model;

import com.Sales.SalesWeb.model.dbEnums.BanerLocation;
import com.Sales.SalesWeb.model.dbEnums.Page;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "baners")
@Data
public class Baner {

    @Id
    private Integer banerId;

    @OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="image_id")
    private Image image;

    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "page_location")
    private BanerLocation pageLocation;

    @Enumerated(EnumType.STRING)
    @Column(name = "page")
    private Page page;

    @Column(name = "baner_uses_status")
    private Boolean banerStatus;
}
