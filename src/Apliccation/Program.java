package Apliccation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;



public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do contrato: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
				
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		
		System.out.print("Entre com o numero de parcelas: ");
		int months = sc.nextInt();
		
		Contract cr = new Contract(number, date, totalValue);
		
		ContractService service = new ContractService(new PaypalService());
		
		service.processContract(cr, months);
		
		
		
		/*LocalDate P = null;
		double parc = cr.getTotalValue() / months;
		double amount = parc + pp.paymentFee(parc);
		for (int i=0; i<months; i++ ) {
			P = cr.getLocalDate().plusMonths(i+1);
			amount += pp.interest(amount, months);
			Installment installment = new Installment(P,amount);
			cr.addInstallment(installment);
		}*/
				
		System.out.println(cr.toString());
		
		sc.close();
	}

}
