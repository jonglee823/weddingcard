package com.wedding.weddingcard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="t_mngr_info")
public class Mngr {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mngr_id")
    private Integer id;

    @Column(name="mngr_name", nullable = false, columnDefinition = "CHAR(10)")
    private String name;

    @Column(name="mngr_account", nullable = false, columnDefinition = "CHAR(15)")
    private String account;

    @Column(name="mngr_password", nullable = false, length = 45)
    private String pasword;

    @Column(name="mngr_mac", length = 45)
    private String mac;

    @Embedded
    private PropertyInfo propertyInfo;
}