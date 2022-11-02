import java.io.IOException;

public class Thread2 extends Thread {
    private ThreadQueue<Thread1> queue;

    public Thread2(ThreadQueue<Thread1> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            // Get request
            while (true) {
                Thread1 item = queue.pop();
                System.out.println(item);
                if(item == null) return;
                HttpRequest request = HttpRequest.parse(item.bufferedReader);
                // Process request
                Processor proc = new Processor(item.socket, request);
                proc.process();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
