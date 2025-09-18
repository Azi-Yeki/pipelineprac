package com.example.invoicing.accessingdatajpa;

import com.example.invoicing.model.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Query("SELECT DISTINCT i FROM Invoice i JOIN FETCH i.invoiceData li WHERE li.prodName = :prodName")
    Page<Invoice> findInvoicesByProductName(@Param("prodName") String prodName, Pageable pageable);
}
