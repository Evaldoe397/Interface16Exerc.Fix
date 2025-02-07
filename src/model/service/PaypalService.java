package model.service;

public class PaypalService implements OnlinePaymentService {
	public double interest(Double amount, Integer months) {
		double interest = amount * 0.01;
		return interest;
		
	}
	public double paymentFee(Double amount) {
		double paymentFee = amount*0.02;
		return paymentFee;
	}
	
}
