package allura.conversor.apiconnection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConectionRequesterResponser {

	private HttpClient client = null;
	private HttpRequest request = null;
	private HttpResponse<String> response = null;
	private String url = null;
	
	public ConectionRequesterResponser(String url) {
		this.url = url;
		this.client = HttpClient.newHttpClient();
	}
	
	public String requestData(String data) {
		
		//https://v6.exchangerate-api.com/v6/df296b1c45038de8d7f4a05c/latest/+data
		this.request = HttpRequest.newBuilder().uri(URI.create(url+data)).build();
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return "Erro na conexao";
		}
		return response.body();
	}
}
