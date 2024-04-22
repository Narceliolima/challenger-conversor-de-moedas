package allura.conversor.apiconnection;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class GsonProcessor {

	private Gson gson = null ;
	private ConectionRequesterResponser conectionRR = null;
//	private JsonFileHandler jfs = null;
//	private <T> defaultCarta = new CartaData(null);
	
	public GsonProcessor(String urlToRequest, String fileName) {
//		this.jfs = new JsonFileHandler(fileName);
		this.conectionRR = new ConectionRequesterResponser(urlToRequest);
		this.gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).setPrettyPrinting().create();
	}

	public <T> T getJsonData(String data, Class<T> classOfT) {
		
		String dataJson = conectionRR.requestData(data);
		
		if(dataJson.equals("Erro na conexao")) {
			System.err.println("Erro de conexao gerado");
			return null;
		}
		else {
			try {
				if(dataJson.contains("error")){
					System.err.println("Erro de pesquisa gerado");
					return null;
				}
				else {
					return gson.fromJson(dataJson, classOfT);
				}
			}
			catch (JsonSyntaxException e) {
				System.err.println("Erro de parametro de valor gerado");
				e.printStackTrace();
				return null;
			}
		}
	}

	public String setJsonData(Object jsonDataObject) {
		
		String jsonDataString = gson.toJson(jsonDataObject);
		//saveCartaJsonFile(jsonDataString);
		return jsonDataString;
	}
	
//	private void saveCartaJsonFile(String dataJsonString) {
//		
//		jfs.jsonDataWritter(dataJsonString);
//	}
}
