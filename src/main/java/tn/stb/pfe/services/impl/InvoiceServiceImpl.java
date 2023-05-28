package tn.stb.pfe.services.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.stb.pfe.models.Appointment;
import tn.stb.pfe.models.AppointmentStatus;
import tn.stb.pfe.models.Invoice;
import tn.stb.pfe.models.user.customer.Customer;
import tn.stb.pfe.repositories.InvoiceRepository;
import tn.stb.pfe.services.AppointmentService;
//import tn.stb.pfe.util.PdfGeneratorUtil;
import tn.stb.pfe.services.InvoiceService;
import tn.stb.pfe.services.NotificationService;
import tn.stb.pfe.services.UserService;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final UserService userService;
    private final AppointmentService appointmentService;
    private final NotificationService notificationService;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, /*PdfGeneratorUtil pdfGeneratorUtil,*/ UserService userService, AppointmentService appointmentService, NotificationService notificationService) {
        this.invoiceRepository = invoiceRepository;
        //this.pdfGeneratorUtil = pdfGeneratorUtil;
        this.userService = userService;
        this.appointmentService = appointmentService;
        this.notificationService = notificationService;
    }

    @Override
    public String generateInvoiceNumber() {
        List<Invoice> invoices = invoiceRepository.findAllIssuedInCurrentMonth(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()).atStartOfDay());
        int nextInvoiceNumber = invoices.size() + 1;
        LocalDateTime today = LocalDateTime.now();
        return "FV/" + today.getYear() + "/" + today.getMonthValue() + "/" + nextInvoiceNumber;
    }

    @Override
    public void createNewInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoiceByAppointmentId(int appointmentId) {
        return invoiceRepository.findByAppointmentId(appointmentId);
    }

    @Override
    public Invoice getInvoiceById(int invoiceId) {
        return invoiceRepository.findById(invoiceId)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    /*@Override
    public File generatePdfForInvoice(int invoiceId) {
        CustomUserDetails currentUser = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Invoice invoice = invoiceRepository.getOne(invoiceId);
        if (!isUserAllowedToDownloadInvoice(currentUser, invoice)) {
            throw new org.springframework.security.access.AccessDeniedException("Unauthorized");
        }
        return pdfGeneratorUtil.generatePdfFromInvoice(invoice);
    }*/

    @Override
    public void changeInvoiceStatusToPaid(int invoiceId) {
        Invoice invoice = invoiceRepository.getOne(invoiceId);
        invoice.setStatus("paid");
        invoiceRepository.save(invoice);
    }

}
