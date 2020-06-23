/**
 * DLPriorityQueue defines the interface to a priority queue collection
 * 
 * @author CalebBorwick
 *
 * @param <T>
 */

public class DLPriorityQueue<T> implements PriorityQueueADT<T> {
	private PriorityNode<T> front;
	private PriorityNode<T> rear;
	private int count;

	/**
	 * Creates an empty priority queue
	 */
	public DLPriorityQueue() {
		count = 0;
		front = null;
		rear = null;
	}

	/**
	 * Adds one element to the rear of this queue.
	 * 
	 * @param element
	 *            the element to be added to the rear of this queue
	 */
	public void enqueue(T dataItem, double priority) {
		PriorityNode<T> node = new PriorityNode<T>(dataItem, priority);
		if (isEmpty()) {
			front = node;
			rear = node;
		} else {
			rear.setNext(node);
			node.setPrevious(rear);
			rear = node;
		}
		node.setNext(null);
		count++;
	}

	/**
	 * Removes and returns the element at the front of this queue.
	 * 
	 * @return the element at the front of this queue
	 */
	public T dequeue() throws EmptyPriorityQueueException {
		if (isEmpty()) {
			throw new EmptyPriorityQueueException("queue");
		}
		T result = front.getDataItem();
		front = front.getNext();
		count--;
		if (isEmpty()) {
			rear = null;
		}
		return result;
	}

	/**
	 * Searches through priority queue and finds a specified objects priority
	 * 
	 * @param dataItem
	 * @return priority of a specific data item
	 * @throws InvalidDataItemException
	 *             if object is not present
	 */
	public double getPriority(T dataItem) throws InvalidDataItemException {
		PriorityNode<T> current = front;
		while (current != null) {
			if (current.getDataItem().equals(dataItem)) {
				return current.getPriority();
			} else {
				current = current.getNext();
			}
		}
		throw new InvalidDataItemException("Invalid Data Item");
	}

	/**
	 * Searches through priority queue and changes a specified objects priority
	 * 
	 * @param dataItem,
	 *            newPriority
	 * @throws InvalidDataItemException
	 *             if object is not present
	 */
	public void changePriority(T dataItem, double newPriority) throws InvalidDataItemException {
		PriorityNode<T> current = front;
		while (current != null) {
			if (current.getDataItem().equals(dataItem)) {
				current.setPriority(newPriority);
				break;

			} else {
				current = current.getNext();
			}
		}
		if (current == null) {
			throw new InvalidDataItemException("Invalid Data Item");
		}

	}

	/**
	 * Searches through priority queue and finds the object with the smallest
	 * priority it then removes and returns that object
	 * 
	 * @returns smallest priority in the queue
	 * @throws EmptyPriorityQueueException
	 *             if queue is empty
	 */
	public T getSmallest() throws EmptyPriorityQueueException {
		if (isEmpty()) {
			throw new EmptyPriorityQueueException("Queue is empty");
		}
		PriorityNode<T> current = front;
		PriorityNode<T> smallest = front;
		for (int i = 0; i < count; i++) {
			if (current.getPriority() < smallest.getPriority()) {
				smallest = current;
			}
			current = current.getNext();

		}
		count--;
		return smallest.getDataItem();
	}

	/**
	 * Returns true if this queue contains no elements.
	 * 
	 * @return true if this queue is empty
	 */
	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the number of elements in this queue.
	 * 
	 * @return the integer representation of the size of this queue
	 */
	public int numItems() {
		return count;
	}

	/**
	 * Returns a string representation of this queue.
	 *
	 * @return the string representation of this queue
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		PriorityNode<T> current = front;
		if (isEmpty()) {
			return "";
		} else {
			while (current != null) {
				result.append(" ").append(current);
				current = current.getNext();
			}
		}
		return result.toString();

	}
}