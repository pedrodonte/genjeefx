package util;

import java.util.logging.Logger;

public class ExceptionHandler {
	
	public static void handler(Exception exc){
		Logger.getGlobal().info("EXC: "+exc.getClass().getSimpleName());
		exc.printStackTrace();
	}

}
