public class MovingAverage {
    LinkedList<Integer> queue;
    int size;
    double avg;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new LinkedList<Integer>();
        this.size = size;
    }

    public double next(int val) {
        if(queue.size()<this.size){
            // the queuye is not full yet
            queue.offer(val);
            int sum=0;
            for(int i: queue){
                sum+=i;
            }
            avg = (double)sum/queue.size();

            return avg;
        }
        else{
            // queue is full
            int head = queue.poll();
            double minus = (double)head/this.size;
            queue.offer(val);
            double add = (double)val/this.size;
            avg = avg + add - minus;
            return avg;
        }
    }
}
