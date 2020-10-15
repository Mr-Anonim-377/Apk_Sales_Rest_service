package com.Sales.SalesWeb.model;

import com.Sales.SalesWeb.model.dbEnums.BanerLocation;
import com.Sales.SalesWeb.model.dbEnums.Page;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "baners")
@Getter
@Setter
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer banerId;

    @OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="image_id")
    private Image image;

    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "page")
    private Page page;

    @Enumerated(EnumType.STRING)
    @Column(name = "page_location")
    private BanerLocation pageLocation;

    @Column(name = "baner_uses_status")
    private Boolean banerUsesStatus;
}
