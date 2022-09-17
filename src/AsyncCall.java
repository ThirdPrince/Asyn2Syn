import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncCall {

    private Random random = new Random(System.currentTimeMillis());
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void call(BaseDemo baseDemo) {
        new Thread(() -> {
            long res = random.nextInt(10);
            try {
                Thread.sleep(res * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            baseDemo.callback(res);
        }).start();
    }
    public Future<Long> futureCall(){
        return executorService.submit(()->{
            long res = random.nextInt(10);
            try {
                Thread.sleep(res*1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            return res;
        });
    }

    public void shutdown(){
        executorService.shutdown();
    }
}
