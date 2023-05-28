package tn.stb.pfe.services;

import tn.stb.pfe.models.Invoice;
import java.io.File;
import java.util.List;

public interface InvoiceService {
    void createNewInvoice(Invoice invoice);

    Invoice getInvoiceByAppointmentId(int appointmentId);

    Invoice getInvoiceById(int invoiceId);

    List<Invoice> getAllInvoices();

    void changeInvoiceStatusToPaid(int invoiceId);

  //  void issueInvoicesForConfirmedAppointments();

    String generateInvoiceNumber();

}

