package samples.function;

import java.util.function.Predicate;

public class BolsaFamiliaFunction {

	public static Predicate<String[]> idadeMaiorQue( int idade){
		return s -> {
			int id  = 0;
			boolean ok = false;
			if ( !s[6].equalsIgnoreCase("NA") ) {
				id = Integer.parseInt(s[6]);
				ok = (id > idade);
			}
			return ok;
		};
	}
	
	public static boolean idadeMaiorQue( int limite, String idade) {
		boolean ok = false;
		int i = 0;
		if ( !idade.equalsIgnoreCase("NA") ) {
			i = Integer.parseInt(idade);
			ok = (i > limite);
		}
		return ok; 
	}
}
