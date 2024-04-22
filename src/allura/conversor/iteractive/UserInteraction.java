package allura.conversor.iteractive;

import java.util.Scanner;

import allura.conversor.apiconnection.GsonProcessor;

public class UserInteraction {
	
	private Scanner sc = new Scanner(System.in);
	private String apiUrl = "https://v6.exchangerate-api.com/v6/df296b1c45038de8d7f4a05c/latest/";
	private GsonProcessor gsonProce = new GsonProcessor(apiUrl, "Nomearquivo");
	private ExchangeConverter converter = null;
	private String[] menuItens = {"BRL", "USD", "EUR", "JPY", "GBP", "AUD", "CAD", "ARS", "CLP", "COP", "BOB"};
	private String[] moneyNameList = {"Real Brasileiro", "Dolar Americano", "Euro", "Yenes", "Libra Esterlina", "Dolar Australiano",
									"Dolar Canadence", "Peso Argentino", "Peso Chileno", "Peso Colombiano",
									"Boliviano da Bolivia"};
	private String userMenu = """
						~Conversor de Cambio~
			/==================================//==================================/
			Selecione qual moeda deseja converter o cambio (Digite o numero).
			1 - Real Brasileiro
			2 - Dolar Americano
			3 - Euro
			4 - Yenes
			5 - Libra Esterlina
			6 - Dolar Australiano
			7 - Dolar Canadence
			8 - Peso Argentino
			9 - Peso Chileno
			10 - Peso Colombiano
			11 - Boliviano da Bolivia
			/==================================//==================================/
			""";

	public void requestExchange() {
		
		System.out.println(userMenu);
		int firstOption = sc.nextInt()-1;
		System.out.println("Para qual moeda? (Digite o numero)");
		int secondOption = sc.nextInt()-1;
		System.out.println("Qual valor para converter? (Digite o numero referente a quantidade de moeda)");
		double thirdOption = sc.nextDouble();
		
		Exchange ex = gsonProce.getJsonData(String.valueOf(menuItens[firstOption]), Exchange.class);
		converter = new ExchangeConverter(ex.conversion_rates());
		double valueConverted = converter.convert(menuItens[secondOption], thirdOption);
		
		System.out.printf("O valor %s esta valendo em %s %.2f\n",moneyNameList[secondOption], moneyNameList[firstOption], valueConverted);
		
		sc.close();
	}
	
//	public void responseCep(Cep cep) {
//		
//		System.out.println(gsonProce.setJsonCepData(cep));
//	}
}
