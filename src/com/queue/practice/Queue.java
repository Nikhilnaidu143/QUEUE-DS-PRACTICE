package com.queue.practice;

/***
 * 
 * @author nikhils4
 * 
 *         Queue Data Structure:-
 * 
 *         A queue is a useful data structure in programming. It is similar to
 *         the ticket queue outside a cinema hall, where the first person
 *         entering the queue is the first person who gets the ticket.
 * 
 *         Queue follows the First In First Out (FIFO) rule - the item that goes
 *         in first is the item that comes out first.
 * 
 *         In programming terms, putting items in the queue is called enqueue,
 *         and removing items from the queue is called dequeue.
 *
 *         Basic Operations of Queue :- 
 *         ---->A queue is an object (an abstract data
 *         structure - ADT) that allows the following operations:
 * 
 *         -->Enqueue: Add an element to the end of the queue 
 *         -->Dequeue: Remove an element from the front of the queue 
 *         -->IsEmpty: Check if the queue is empty 
 *         -->IsFull: Check if the queue is full 
 *         -->Peek: Get the value of the front of the queue without removing it
 * 
 * 
 * 		   Working of Queue :- 
 *			Queue operations work as follows:
 *
 *			->two pointers FRONT and REAR
 *			->FRONT track the first element of the queue
 *			->REAR track the last element of the queue
 * 			->initially, set value of FRONT and REAR to -1
 *			
 *			Enqueue Operation :-
 *				-> check if the queue is full
 *				->for the first element, set the value of FRONT to 0
 *				->increase the REAR index by 1
 *			 	->add the new element in the position pointed to by REAR	
 *			
 *			Dequeue Operation:- 
 *			    ->check if the queue is empty
 *				->return the value pointed by FRONT
 *				->increase the FRONT index by 1
 *				->for the last element, reset the values of FRONT and REAR to -1
 *
 *
 *			Limitations of Queue:- 
 *				->After REAR reaches the last index, if we try to store extra 
 *				  elements in the empty spaces (for example :- 0 and 1 indexes), we cannot make use of the empty spaces. 
 *
 *				-> We can solve this limitation by using a modified queue called 
 *				   the CIRCULAR QUEUE.
 */

public class Queue {
	private int[] array;
	private int capacity;
	private int FRONT = -1;
	private int REAR = -1;

	public Queue(int size) {
		array = new int[size];
		capacity = size;
	}

	// checking whether the queue is full or not
	public boolean isFull() {
		return (REAR == capacity - 1 && FRONT == 0) ? true : false;
	}

	// inserting element to the end of the queue
	public void enqueue(int element) {
		if (isFull()) {
			System.out.println("Queue is already full. Try dequeue");
		} else {
			FRONT = 0;
			REAR = REAR + 1;
			array[REAR] = element;
			System.out.println("inserted : " + element + " & rear position : " + REAR);
		}
	}

	// checking whether the queue is empty or not
	public boolean isEmpty() {
		return FRONT == -1 && REAR == -1 ? true : false;
	}

	// deleting element from the start of the queue.
	public void dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty. Try enqueue");
		} else {
			int element = array[FRONT];
			if (FRONT >= REAR) {
				FRONT = -1;
				REAR = -1;
			} else {
				FRONT++;
			}
			System.out.println("\nDeleted element : " + element + " FRONT position : " + FRONT);
		}
	}

	// returning FRONT element without deleting it.
	public int peek() {
		if (isEmpty()) {
			return -1;
		}
		return array[FRONT];
	}

	// printing queue.
	public void printQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
		} else {
			for (int i = FRONT; i <= REAR; i++) {
				System.out.print(array[i] + " - ");
			}
		}
	}

	// main method.
	public static void main(String[] args) {
		Queue queue = new Queue(5);

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);

		queue.printQueue();

		System.out.print("\npeek value : " + queue.peek());

		queue.dequeue();
		queue.printQueue();
		System.out.print("\npeek value : " + queue.peek());
		queue.dequeue();
		queue.printQueue();
		System.out.print("\npeek value : " + queue.peek());

//		queue.enqueue(10);   		 -----_______________F_________R___
//		queue.printQueue();           -1     0     1     2    3    4       0 & 1 are empty. we cannot insert an element in empty spaces until we we reset(fully empty) the queue, this is limitation of queue..
//		                             -----_______________3____4____5__
		queue.dequeue();
		queue.printQueue();
		System.out.print("\npeek value : " + queue.peek());
		queue.dequeue();
		queue.printQueue();
		System.out.print("\npeek value : " + queue.peek());
		queue.dequeue();
		queue.printQueue();
		System.out.print("\npeek value : " + queue.peek());
	}
}
