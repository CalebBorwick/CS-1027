import java.util.Iterator;

/**
 * 
 * @author CalebBorwick
 *
 */
public class HuffmanTree extends LinkedBinaryTree<HuffmanPair> implements Comparable<HuffmanTree> {

	/**
	 * creates an empty Huffman tree
	 */
	public HuffmanTree() {
		super();

	}

	/**
	 * creates a Huffman tree with one Huffman pair at the root
	 * 
	 * @param element
	 */
	public HuffmanTree(HuffmanPair element) {
		super(element);
	}

	/**
	 * creates a Huffman tree rooted at a node containing element, where the roots
	 * of the left subtree and right subtree are its left child and right child,
	 * respectively
	 * 
	 * @param element
	 * @param leftSubtree
	 * @param rightSubtree
	 */
	public HuffmanTree(HuffmanPair element, HuffmanTree leftSubtree, HuffmanTree rightSubtree) {
		super(element);
		BinaryTreeNode<HuffmanPair> newRoot = super.getRoot();
		BinaryTreeNode<HuffmanPair> left = leftSubtree.getRoot();
		BinaryTreeNode<HuffmanPair> right = rightSubtree.getRoot();
		newRoot.setLeft(left);
		newRoot.setRight(right);
	}

	/**
	 * The pairsList parameter is an ordered list of Huffman pairs in ascending
	 * order by frequency
	 * 
	 * @param pairsList
	 */
	public HuffmanTree(ArrayOrderedList<HuffmanPair> pairsList) {
		ArrayOrderedList<HuffmanTree> buildList = new ArrayOrderedList<HuffmanTree>();
		for (int i = 0; i < pairsList.size(); i++) {
			HuffmanPair node = pairsList.getElement(i);
			HuffmanTree tree = new HuffmanTree(node);
			buildList.add(tree);

		}
		if (buildList.size() == 1) {
			HuffmanTree tree = buildList.removeFirst();
			buildList.add(tree);

		}
		while (buildList.size() > 1) {
			HuffmanTree leftTree = buildList.removeFirst();
			HuffmanTree rightTree = buildList.removeFirst();
			int leftNode = leftTree.getRoot().getElement().getFrequency();
			int rightNode = rightTree.getRoot().getElement().getFrequency();
			int rootFreq = leftNode + rightNode;
			HuffmanPair newRoot = new HuffmanPair(rootFreq);
			HuffmanTree tree = new HuffmanTree(newRoot, leftTree, rightTree);
			buildList.add(tree);

		}
		BinaryTreeNode<HuffmanPair> finalRoot = buildList.getElement(0).getRoot();
		super.setRoot(finalRoot);
	}

	/**
	 * It will compare the frequencies in the root node of the trees
	 * 
	 * @param otherTree
	 */
	public int compareTo(HuffmanTree otherTree) {
		BinaryTreeNode<HuffmanPair> other = otherTree.getRoot();
		BinaryTreeNode<HuffmanPair> thisRoot = super.getRoot();
		return (thisRoot.getElement().compareTo(other.getElement()));

	}

	/**
	 * This method will return a string representation of a Huffman tree by doing a
	 * preorder traversal of the tree
	 */
	public String toString() {
		String s = "";

		Iterator<HuffmanPair> list;

		list = iteratorInOrder();
		while (list.hasNext()) {
			s += list.next().toString();
		}
		return s;
	}

}
