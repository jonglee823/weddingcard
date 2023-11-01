package com.wedding.weddingcard.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="t_wedding_info")
public class Wedding {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="wedding_id")
    private Integer id;

    @Column(name="wedding_date")
    @NotNull
    private LocalDateTime weddingDate;

    @Column(name="wedding_hall_location", length = 100)
    @NotNull
    private String hallLocation;

}
