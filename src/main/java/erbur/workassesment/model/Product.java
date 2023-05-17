package erbur.workassesment.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "code")
    private String code;


    @Column(name = "category")
    private String category;

    @Column(name = "brand")
    private String brand;


    @Column(name="type")
    private String type;

    @Column(name = "description")
    private String description;
}
