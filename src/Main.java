import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Qual a quantidade de atletas? ");
		int numberOfAthletes = sc.nextInt();
		
		int menQuantity = 0;
		int womenQuantity = 0;
		String tallestAthlete = "" ;
		double totalHeightOfWomen = 0.0;		
		double totalWeight = 0.0;
		double greatestHeight = 0.0;
		
		for (int i = 0; i < numberOfAthletes; i++) {
			int numberOfAthlete = i + 1;
			
			System.out.println("Digite os dados do atleta numero " + numberOfAthlete + ":");
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();					
			System.out.print("Sexo: ");
			char gender = sc.next().charAt(0);
			while (gender != 'F' && gender !=  'M') {				
				System.out.print("Valor invalido! Favor digitar F ou M: ");
				gender = sc.next().charAt(0);				
			}
			
			System.out.print("Altura: ");
			double height = sc.nextDouble();
			sc.nextLine();
			while (height <= 0.0) {
				System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				height = sc.nextDouble();
			}
			
			System.out.print("Peso: ");
			double weight = sc.nextDouble();
			while (weight <= 0.0) {
				System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				weight = sc.nextDouble();
			}
			
			totalWeight += weight;
			
			if (height > greatestHeight) {
				greatestHeight = height;
				tallestAthlete = name;				
			}
			
			if(gender == 'F'){
				womenQuantity ++;
				totalHeightOfWomen += height;				
			}
			else {
				menQuantity ++;
			}
			
		}
		
		double averageWeight = totalWeight / numberOfAthletes;
		double menPercent = (double)menQuantity / (double)numberOfAthletes * 100.0;
		double averageHeightOfWomen = 0.0;
		
		System.out.println();
		System.out.printf("Peso médio dos atletas: %.2f%n", averageWeight);
		System.out.println("Atleta mais alto: " + tallestAthlete);
		System.out.printf("Porcentagem de homens: %.2f %% %n", menPercent);
		if (totalHeightOfWomen != 0.0) {
			averageHeightOfWomen = totalHeightOfWomen / womenQuantity;
			System.out.printf("Altura média das mulheres: %.1f%n", averageHeightOfWomen);
		}
		else {
			System.out.println("Não há mulheres cadastradas");
		}
		
		sc.close();

	}

}
