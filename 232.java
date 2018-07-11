class MyQueue {
    Queue<Integer> input;
    Queue<Integer> output;

    /** Initialize your data structure here. */
    public MyQueue() {
        input = new LinkedList<>();
        output = new LinkedList<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        input.offer(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {   
        peek();
        return output.poll();
    }
    
    /** Get the front element. */
    public int peek() {   
        while (!input.isEmpty()) {
            output.offer(input.poll());
        }
        return output.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return output.isEmpty() && input.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */