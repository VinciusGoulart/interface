package org.example.services;

import org.example.entities.Contract;
import org.example.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {

        double amount = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);

            double interest = onlinePaymentService.interest(amount, i);
            double paymentFee = onlinePaymentService.paymentFee(amount + interest);
            double quota = amount + paymentFee + interest;

            contract.getInstallments().add(new Installment(dueDate,quota));
        }

    }
}
