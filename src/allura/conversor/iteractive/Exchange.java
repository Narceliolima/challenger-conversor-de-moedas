package allura.conversor.iteractive;

//Classe utilizada para receber os valores JSON da API
public record Exchange(String result, String base_code, Currency conversion_rates) {
	
}
