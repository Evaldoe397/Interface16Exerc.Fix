package model.service;

import model.entities.Contract;

public class ContractService {
	Contract obj = new Contract();
		
	public ContractService() {
	}
	
	public void processContract(Contract obj, int months) {
		
		double amount = obj.getTotalValue() / months;
		
		OnlinePaymentService service = new PaypalService();
		}
}	
	
		