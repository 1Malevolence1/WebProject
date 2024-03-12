package com.example.TraningSpring.models;



import lombok.*;


@Data //за нас создаёт пустой конструктор класса, создаёт get and set, переписывает методы по типу hascode()
@AllArgsConstructor //создаёт констурктор со всеми полями
public class Products {
    private Long id;
    private String name;
    private String description;
    private int price;
    private String city;
    private String author;

}
