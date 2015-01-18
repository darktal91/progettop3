public class Counter {
    private int count;
    
    Counter(int c) {
      count = c;
    }
    
    public synchronized void increment() {
      count++;
    }
    
    public synchronized void decrement() {
      count--;
      notify();
    }
    
    public synchronized int getCount() {
      return count;
    }
  }