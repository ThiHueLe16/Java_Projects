package pgdp.iter;

import java.util.function.Function;

public class PasswordBreaker {

    public static String findPassword(Function<String, Integer> hashFunction, int passwordLength,
            String salt, int saltedPasswordHashValue) {
    	
        // TODO
    	PasswordIterator pass=new PasswordIterator(passwordLength);
    	while(pass.hasNext()) {
    		String a=pass.next();
    		if(hashFunction.apply(a+salt)==saltedPasswordHashValue) {
    		return a;
    		}
    	}
        return null;
    }
}
