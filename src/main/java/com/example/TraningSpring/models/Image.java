package com.example.TraningSpring.models;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "image")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "OriginFileName")
    private String OriginFileName;
    @Column(name = "size")
    private Long size;
    @Column(name = "contentType")
    private String contentType;
    @Column(name = "isPreviewImage")
    private boolean isPreviewImage;

    //Lob
    @Lob
    private byte[] bytes;

    // LAZY - ленивая загрузка, код будет работать быстрее, но мы не будем подгружать все связанные сущности
    //EAGER - наоборт
    //ManyToOne - многое к одному(много фотографий к одному продукту)
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Products products;
}
