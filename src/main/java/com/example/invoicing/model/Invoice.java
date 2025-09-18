package com.example.invoicing.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long invoiceNo;
    private String buyerName;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable( name = "invoice_line_item", joinColumns = @JoinColumn(name = "invoice_no"), inverseJoinColumns = @JoinColumn(name = "item_no"))
    List<LineItem> invoiceData;
}
