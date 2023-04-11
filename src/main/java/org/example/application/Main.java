package org.example.application;

import org.example.entities.Contract;
import org.example.entities.Installment;
import org.example.services.ContractService;
import org.example.services.PaypalService;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter with contract data: ");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        System.out.print("Date: ");

        LocalDate date = LocalDate.parse(sc.next(), dtf);
        System.out.print("Contract value: ");
        Double value = sc.nextDouble();
        System.out.print("How much installments: ");
        Integer amount = sc.nextInt();

        Contract contract = new Contract(date, value, number);

        ContractService service = new ContractService(new PaypalService());

        service.processContract(contract, amount);

        System.out.println("Installments: ");
        for (Installment p : contract.getInstallments()) {
            System.out.println(p);
        }
    }
}