package labTest2Services;

import beans.ServiceData;

public class ServiceInvokerFactory {
	

	
	public IServiceInvoker createService(String checked) {
		IServiceInvoker result = null;
	
		if (checked.equals("S1")) 
			// CONCRETE CREATOR #1
			result = new Service1Invoker();
		else if (checked.equals("S2"))
			// CONCRETE CREATOR #2 
			result = new Service2Invoker();
		return result;

	}
}
