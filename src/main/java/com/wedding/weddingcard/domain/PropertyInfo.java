package com.wedding.weddingcard.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class PropertyInfo {

    @Column(name="create_id", columnDefinition = "char(15)")
    private String createId;


    @Column(name="create_date", columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    private LocalDateTime createDate;

    @Column(name="last_modified_id", columnDefinition = "char(15)")
    private String lastModifiedId;

    @Column(name = "last_modified_date", columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    private LocalDateTime lastModifiedDate;


}