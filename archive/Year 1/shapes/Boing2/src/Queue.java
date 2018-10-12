
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by LinkedListElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author you
 *
 */

import java.util.NoSuchElementException;

public class Queue {

	private QueueElement head;
        private QueueElement tail;
        
        /**
	 * Constructs an empty Queue.
	 */
	public Queue () {
            head = null;
            tail = null;
            
                    //TODO:  Queue needs to be initialized to an empty Queue.
	}

	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty () {
		//TODO:  Needs to return true when empty and false otherwise
		return ((head == null) && (tail == null));
	}
	/**
	 * Returns the element at the head of the queue
	 */
	public Object peek () {
		//TODO:  Returns the front of the queue if it exists and throws an exception otherwise
		if (head == null) {
            throw new NoSuchElementException("List is empty");
                }
                return head.getElement();
	}
	
	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () {
		//TODO:  Removes the front front of the queue if it exists and throws an exception otherwise
                if (isEmpty()) {
            throw new NoSuchElementException("Underflow");
                }
             //   QueueElement newQueueElement = new QueueElement(head, null);
                if (tail == head) {
                    tail = null;
                }
                head = head.getNext();                
	}
	
	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue (Object element) {
                //TODO:  Puts an element on the back of the queue.
                QueueElement newQueueElement = new QueueElement(element, null);
                
                if (isEmpty()) {
                    head = newQueueElement;
                } else {
                    tail.setNext(newQueueElement);
                }
                tail = newQueueElement;
	}
	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
            
                QueueElement printer = head;

                while (printer != null){
                System.out.print(printer.getElement()+" ");
                printer = printer.getNext();

        }

        System.out.println();        
            
                        
        }
    }
		//TODO:  Prints out the full queue.  If empty prints out a line saying so.
	
