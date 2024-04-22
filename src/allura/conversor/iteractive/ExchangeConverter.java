package allura.conversor.iteractive;

public class ExchangeConverter {

	private Currency cur = null;
	
	public ExchangeConverter(Currency cur) {
		this.cur = cur;
	}
	
	public double convert(String isoCode, double value) {
		
		if(isoCode.equals("BRL")) {
			return cur.BRL() * value;
		}
		else if(isoCode.equals("USD")) {
			return cur.USD() * value;
		}
		else if(isoCode.equals("JPY")) {
			return cur.JPY() * value;
		}
		else if(isoCode.equals("EUR")) {
			return cur.EUR() * value;
		}
		else if(isoCode.equals("GPB")) {
			return cur.GBP() * value;
		}
		else if(isoCode.equals("AUD")) {
			return cur.AUD() * value;
		}
		else if(isoCode.equals("CAD")) {
			return cur.CAD() * value;
		}
		else if(isoCode.equals("ARS")) {
			return cur.ARS() * value;
		}
		else if(isoCode.equals("CLP")) {
			return cur.CLP() * value;
		}
		else if(isoCode.equals("BOB")) {
			return cur.BOB() * value;
		}
		else if(isoCode.equals("COP")) {
			return cur.COP() * value;
		}
		else {
			return 0;
		}
	}
}
