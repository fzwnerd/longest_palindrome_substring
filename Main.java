/*
 * Have the function BinaryReversal(str) take 
 * the str parameter being passed, which will be 
 * a positive integer, take its binary representation 
 * (padded to the nearest N * 8 bits), 
 * reverse that string of bits, and then
 * finally return the new reversed string in decimal form. 
 * For example: if str is "47" then the binary 
 * version of this integer is 101111 but we pad it to be 00101111. 
 * Your program should reverse this binary string 
 * which then becomes: 11110100 and then 
 * finally return the decimal version of this string, which is 244.
 */
public class Main {
	int BinaryReversal(String str) {
		int num = Integer.parseInt(str);
		String binaryStr = Integer.toBinaryString(num);
		int len = binaryStr.length();
		
		int padLen = 0;
		// get length needed for padding
		if (len % 8 != 0) {
			padLen = (len / 8 + 1) * 8 - len;
		}
		
		String padStr = "";
		for (int i = 0; i < padLen; i++) {
			padStr += "0";
		}
		
		StringBuilder sb = new StringBuilder(padStr + binaryStr);
		sb.reverse();
		
		String reversedPaddedStr = sb.toString();
		return Integer.parseInt(reversedPaddedStr, 2);
	}

	public static void main(String[] args) {
		Main main = new Main();
		String input = "47";
		System.out.println("input: \"" + input + "\"");
		System.out.println("output: " + main.BinaryReversal(input));
		System.out.println();
		
		input = "1";
		System.out.println("input: \"" + input + "\"");
		// 10000000
		System.out.println("output: " + main.BinaryReversal(input));
		System.out.println();
		
		input = "682";
		System.out.println("input: \"" + input + "\"");
		// 682 -> 1010101010 -> 0000001010101010
		// -> 0101010101000000 -> 21824
		System.out.println("output: " + main.BinaryReversal(input));
	}
}
