package com.web_project.flower.service;

import com.web_project.flower.model.PaymentModel;

import java.util.List;
import java.util.UUID;

public interface PaymentService {

    public List<PaymentModel> findAllPayments();

    public PaymentModel findPaymentById(UUID id);

    public PaymentModel addPayment(PaymentModel payment);

    public PaymentModel updatePayment(PaymentModel payment);

    public void deletePayment(UUID id);
}
