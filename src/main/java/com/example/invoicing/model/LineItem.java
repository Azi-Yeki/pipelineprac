package com.example.invoicing.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class LineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemNo;
    private String prodName;
    private long quantity;
    private double unitPrice;
    @ManyToMany(mappedBy = "invoiceData")
    private List<Invoice> invoices;

}
