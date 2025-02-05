package model.service;

public class PaypalService implements OnlinePaymentService {
	
	double paymentFee, interest = 0.0;
	
	public double paymentFee(Double amount) {
		if (amount>0.0) {
		paymentFee = amount *0.02;
		}
		return paymentFee;
	}
	
	
	public double interest(Double amount, Integer months) {
		for (int i=0; i<months; i++) {
		interest = (amount + paymentFee) * 0.01;
		}
		return interest;
	}
		
}
