package util;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	private int x = Integer.MIN_VALUE;
	private int y = Integer.MIN_VALUE;
	
	Scanner in = new Scanner(System.in);
	private int readInput() {
		System.out.print("Digite um número: ");		
		int num = in.nextInt();
				
		return num;
	}
	
	private void inputNumbers(int num) {
		
		String line = null;
		System.out.println("Digite um número: ");
		line = in.nextLine();
		for(int i = 0; i<num; i++) {			
			line = in.nextLine();
			x = processLine(line, i);
			y = processLine(line, num-(i+1));	
			
			System.out.println("X: " + x + ", Y: " + y);
		}
		
	}
	
	private int processLine(String line, int index) {
		StringTokenizer token = new StringTokenizer(line, " ");
		int count = token.countTokens();
		int valor = 0;
		for( int i = 0; i<count; i++) {
			if ( i == index ) {
				valor = Integer.parseInt(token.nextToken());
				break;
			}
			token.nextToken();
		}
		return valor;
	}
	public static void main(String[] args) {
		Main m = new Main();
		int num = m.readInput();
		m.inputNumbers(num);

	}

}
