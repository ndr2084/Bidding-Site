package labTest2Services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import beans.ServiceData;

public class Service1Invoker implements IServiceInvoker {

	public String perform(ServiceData theData) {
		String field1 = theData.getFirstName();
		String field2 = theData.getLastName();
		
		String urlString = String.format(
				"http://localhost:8080/RESTJAXRSJersey/rest/restService1/op1?firstName=%s&lastName=%s", field1, field2);
		System.out.println(urlString);
		
		String inline = "";
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode == 200) {
				
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				
				System.out.println(inline); //"Life long and propser" is printed on terminal
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}

		return inline;

	}

}
