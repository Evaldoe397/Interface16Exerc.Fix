package model.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	Contract obj = new Contract();
		
	public ContractService() {
	}
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public void processContract(Contract obj, int months) {
		OnlinePaymentService servico = new PaypalService();
		//PaypalService pp = new PaypalService();
		LocalDate P = null;
		double parc = obj.getTotalValue() / months;
		double amount = parc + servico.paymentFee(parc);
		for (int i=0; i<months; i++ ) {
			P = obj.getLocalDate().plusMonths(i+1);
			amount += servico.interest(amount, months);
			Installment installment = new Installment(P,amount);
			obj.addInstallment(installment);
		}
	}
}	
	
		