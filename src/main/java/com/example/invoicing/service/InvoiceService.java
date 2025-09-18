package com.example.invoicing.service;

import com.example.invoicing.accessingdatajpa.InvoiceRepository;
import com.example.invoicing.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional
    public void addInvoice(Invoice invoice) {
        System.out.println("Invoice data before saving: " + invoice);
        invoiceRepository.save(invoice);
    }

    @Transactional
    public Page<Invoice> getInvoicesByProductName(String prodName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return invoiceRepository.findInvoicesByProductName(prodName, pageable);
    }

    @Transactional
    public void deleteInvoice(long invoiceNo) {
        invoiceRepository.deleteById(invoiceNo);
    }

    @Transactional
    public List<Invoice> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return invoiceRepository.findAll();
    }

    @Transactional
    public Invoice update(long invoiceNo, String name) {
        Optional<Invoice> invoice = invoiceRepository.findById(invoiceNo);
        Invoice invoice2 = new Invoice();
        if (invoice.isPresent()) {
            invoice2 = invoice.get();
            invoice2.setBuyerName(name);
        }
        return invoiceRepository.save(invoice2);

    }
}
