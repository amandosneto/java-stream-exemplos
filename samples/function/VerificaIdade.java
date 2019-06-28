package samples.function;

import java.util.function.Predicate;

public class VerificaIdade implements Predicate<String> {

	@Override
	public boolean test(String t) {
		return ( t != null && !t.equalsIgnoreCase("NA") );
	}

}
