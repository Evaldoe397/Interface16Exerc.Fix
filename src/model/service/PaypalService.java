package model.service;

public class PaypalService implements OnlinePaymentService {
	
	double paymentFee, interest = 0.0;
	
	public double interest(Double amount, Integer months) {
		interest = amount + amount*0.01;
		return interest;
	}
		
	
	public double paymentFee(Double amount) {
		paymentFee = amount*0.02;
		return paymentFee;
	}
	
	
	
}
