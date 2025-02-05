package Apliccation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Contract;
import model.service.ContractService;



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
		ContractService service = new ContractService();
		
		

		for (int i=0; i<months; i++ ) {
			double amount = totalValue / months;
			LocalDate P = date.plusMonths(months);
			
			System.out.println("Parcela " + i + "#: " + P);
		}
		
		System.out.println();
		service.processContract(cr,months);
		LocalDate teste1 = date.plusMonths(months);
		LocalDate teste2 = teste1.plusMonths(months);
		LocalDate teste3 = teste2.plusMonths(months);
		
			
		System.out.println("Parcela 1#: " + teste1.format(fmt));
		System.out.println("Parcela 2#: " + fmt.format(teste2));
		System.out.println("Parcela 3#: " + teste3.format(fmt));
		
		sc.close();
	}

}
