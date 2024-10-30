package com.jerrit.E_com.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Entity //to create table in database
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_gen")
    //@SequenceGenerator(name = "product_seq_gen", sequenceName = "product_seq", allocationSize = 1)
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    private Date release_date;
    private boolean available;
    private int quantity;

    private String imagename;
    private String imagetype;

    @Lob
    private byte[] image;


}
