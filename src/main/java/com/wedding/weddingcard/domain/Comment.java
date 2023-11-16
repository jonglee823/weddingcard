package com.wedding.weddingcard.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name ="t_cong_coment", indexes = @Index(name="CREATE_DATE_INDEX", columnList = "CREATE_DATE"))
@NoArgsConstructor
public class Comment {

    @Builder
    public Comment(Integer id, String title, String content, String password, Boolean deleteYn, PropertyInfo propertyInfo) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.password = password;
        this.deleteYn = deleteYn;
        this.propertyInfo = propertyInfo;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COMENT_ID", nullable = false, length = 10, unique = true)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 500)
    private String content;

    @Column(nullable = false, length = 150)
    private String password;

    @Column(name="DELETE_YN", columnDefinition = "char(1) default 'N'")
    private Boolean deleteYn;

    @Embedded
    private PropertyInfo propertyInfo;




}