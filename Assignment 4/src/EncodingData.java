/**
 * 
 * @author CalebBorwick
 *
 */
public class EncodingData {
	private char symbol;
	private String encoding;

	/**
	 * 
	 * @param symbol
	 * @param encoding
	 */
	public EncodingData(char symbol, String encoding) {
		this.symbol = symbol;
		this.encoding = encoding;

	}

	/**
	 * getter method to return the symbol
	 * 
	 * @return symbols
	 */
	public char getSymbol() {
		return symbol;
	}

	/**
	 * getter method to return encoding
	 * 
	 * @return encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * setter method to change the symbol
	 * 
	 * @param newSym
	 */
	public void setSymbol(char newSym) {
		this.symbol = newSym;
	}

	/**
	 * setter method to change the encoding
	 * 
	 * @param newEnc
	 */
	public void setEncoding(String newEnc) {
		this.encoding = newEnc;
	}

	/**
	 * method that determines if two EncodingData objects are equal based on the
	 * symbol attribute
	 * 
	 * @return
	 */
	public boolean equals(EncodingData obj) {
		EncodingData other = (EncodingData) obj;
		if (symbol != other.getSymbol())
			return false;
		return true;
	}

	/**
	 * method that gives a string representation of the symbol and its Huffman code
	 */
	public String toString() {
		String s = "";
		s = "(" + Character.toString(symbol) + ", " + (encoding) + ")\n";
		return s;

	}

}
