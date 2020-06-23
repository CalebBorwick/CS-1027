/**
 * 
 * @author CalebBorwick
 *
 * @param <T>
 */
public class PriorityNode<T> {
	private T dataItem;
	private PriorityNode<T> next;
	private PriorityNode<T> previous;
	private double priority;

	/**
	 * Creates a node storing the given data and priority
	 * 
	 * @param data
	 * @param prio
	 */
	public PriorityNode(T data, double prio) {
		dataItem = data;
		priority = prio;

	}

	/**
	 * Creates an empty node, with null data and priority zero
	 */
	public PriorityNode() {
		next = null;
		previous = null;
		priority = 0;

	}

	/**
	 * 
	 * @return priority
	 */
	public double getPriority() {
		return priority;
	}

	/**
	 * 
	 * @return dataItem
	 */
	public T getDataItem() {
		return dataItem;
	}

	/**
	 * 
	 * @return next
	 */
	public PriorityNode<T> getNext() {
		return next;
	}

	/**
	 * 
	 * @return previous
	 */
	public PriorityNode<T> getPrevious() {
		return previous;
	}

	/**
	 * 
	 * @param data
	 *            is set to dataItem
	 */
	public void setDataItem(T data) {
		this.dataItem = data;
	}

	/**
	 * 
	 * @param newNext
	 *            is set to next
	 */
	public void setNext(PriorityNode<T> newNext) {
		this.next = newNext;

	}

	/**
	 * 
	 * @param newPrev
	 *            is set to previous
	 */
	public void setPrevious(PriorityNode<T> newPrev) {
		this.previous = newPrev;
	}

	/**
	 * 
	 * @param newPrior
	 *            is set to priority
	 */
	public void setPriority(double newPrior) {
		this.priority = newPrior;
	}
}