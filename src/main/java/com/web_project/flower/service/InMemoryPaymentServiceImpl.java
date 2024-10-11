package com.web_project.flower.service;

import com.web_project.flower.model.PaymentModel;
import com.web_project.flower.repository.PaymentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class InMemoryPaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;

    public InMemoryPaymentServiceImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }


    @Override
    public List<PaymentModel> findAllPayments() {
        return paymentRepository.findAll(Sort.by("id"));
    }


    @Override
    public PaymentModel findPaymentById(UUID id) {

        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public PaymentModel addPayment(PaymentModel payment) {

        return paymentRepository.save(payment);
    }

    @Override
    public PaymentModel updatePayment(PaymentModel payment) {
        if(paymentRepository.existsById(payment.getId())) {
            return paymentRepository.save(payment);
        }
        return null;
    }

    @Override
    public void deletePayment(UUID id) {
        if(paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
        }
    }
}
