package model.service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.entities.Contract;
import model.entities.Installment;
public class ContractService {
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	Contract contract = new Contract();
	private OnlinePaymentService onlinePaymentService;
	public ContractService(OnlinePaymentService onlinePaymentService ) {
		this.onlinePaymentService = onlinePaymentService;
	}
	public void processContract(Contract contract, int months ) {
		for (int i=0; i<months; i++ ) {
			double amount = contract.getTotalValue()/months; 
			amount += onlinePaymentService.interest(amount, months)*(i+1);
			amount += onlinePaymentService.paymentFee(amount); 
			LocalDate vencimento = contract.getLocalDate().plusMonths(i+1);
			Installment installment = new Installment(vencimento,amount);
			contract.addInstallment(installment);
		}
	}
}	
	
		