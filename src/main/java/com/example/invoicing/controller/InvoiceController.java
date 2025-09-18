package com.example.invoicing.controller;

import com.example.invoicing.model.Invoice;
import com.example.invoicing.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceController {
    private InvoiceService invoiceService;

    @Autowired

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("")
    public ResponseEntity<?> addInvoice(@RequestBody Invoice invoice) {
        invoiceService.addInvoice(invoice);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        invoiceService.getAll(page, size);
        return ResponseEntity.ok(invoiceService.getAll(page, size));
    }

    @GetMapping("byprodname")
    public ResponseEntity<Page<Invoice>> getInvoicesByProduct(@RequestParam String prodName, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Invoice> invoices = invoiceService.getInvoicesByProductName(prodName, page, size);
        return ResponseEntity.ok(invoices);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteInvoice(@RequestParam long invoiceNo) {
        invoiceService.deleteInvoice(invoiceNo);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @PatchMapping("")
    public ResponseEntity<?> updateInvoice(@RequestParam long invoiceNo, @RequestParam String buyerName) {
        invoiceService.update(invoiceNo, buyerName);
        return ResponseEntity.ok((HttpStatus.NO_CONTENT));
    }

}
