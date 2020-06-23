/**
 * 
 * @author CalebBorwick
 *
 */
public class HuffmanCoder {
	private HuffmanTree huffTree;
	private ArrayUnorderedList<EncodingData> encodingList;

	/**
	 * 
	 * @param pairsList
	 */
	public HuffmanCoder(ArrayOrderedList<HuffmanPair> pairsList) {
		huffTree = new HuffmanTree(pairsList);
		encodingList = new ArrayUnorderedList<EncodingData>();
		buildEncodingList(huffTree.getRoot(), "");

	}

	/**
	 * private helper method which will build the list of symbols and their
	 * encodings from the Huffman tree huffTree
	 * 
	 * @param node
	 * @param encoding
	 */
	private void buildEncodingList(BinaryTreeNode<HuffmanPair> node, String encoding) {
		if (node.getLeft() == null && node.getRight() == null) {
			char symbol = node.getElement().getCharacter();
			EncodingData encodeObj = new EncodingData(symbol, encoding);
			encodingList.addToRear(encodeObj);

		} else {
			buildEncodingList(node.getLeft(), encoding + "0");
			buildEncodingList(node.getRight(), encoding + "1");

		}
	}

	/**
	 * This method will take the specified string of binary digits that is a Huffman
	 * encoding, and will return the original coded character
	 * 
	 * @param code
	 * @return
	 */
	public char decode(String code) {
		BinaryTreeNode<HuffmanPair> current = huffTree.getRoot();
		for (int i = 0; i < code.length(); i++) {
			if (code.charAt(i) == '0') {
				current = current.getLeft();
			} else if (current.getLeft() == null && current.getRight() == null) {
				return 0;
			} else if (code.charAt(i) == '1') {
				current = current.getRight();

			}

		}

		return current.getElement().getCharacter();
	}

	/**
	 * This method will take the specified character and return the string
	 * representation of the binary Huffman encoding of that character
	 * 
	 * @param c
	 * @return
	 * @throws ElementNotFoundException
	 */
	public String encode(char c) throws ElementNotFoundException {
		for (int i = 0; i < encodingList.size();) {
			char node = encodingList.getElement(i).getSymbol();
			if (node == c) {
				return encodingList.getElement(i).getEncoding();
			} else {
				i++;
			}

		}
		throw new ElementNotFoundException("ELement is not found");
	}

	/**
	 * This method will return a string representation of the encoding list
	 */
	public String toString() {
		String result = "";
		for (int i = 0; i < encodingList.size(); i++) {
			result = result + ", " + encodingList.getElement(i);
		}
		return result;

	}

}
