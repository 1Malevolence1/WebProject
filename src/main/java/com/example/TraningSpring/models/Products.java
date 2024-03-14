package com.example.TraningSpring.models;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data //за нас создаёт пустой конструктор класса, создаёт get and set, переписывает методы по типу hascode()
@AllArgsConstructor //создаёт констурктор со всеми полями
@NoArgsConstructor // созадёт пустой конструктор
public class Products {


    @Id // присваивает значение праймори key
    @GeneratedValue(strategy =  GenerationType.AUTO) // выполняет функцию Surell
    @Column(name = "id")// создаёт колонку
    private Long id;
    @Column(name = "title")// создаёт колонку
    private String title;
    @Column(name = "description" , columnDefinition = "text")// создаёт колонку
    private String description;
    @Column(name = "price")// создаёт колонку
    private int price;
    @Column(name = "city")// создаёт колонку
    private String city;
    @Column(name = "author")// создаёт колонку
    private String author;

}
