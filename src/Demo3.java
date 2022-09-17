import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * future
 */
public class Demo3 {
    private AsyncCall asyncCall = new AsyncCall();
    public Future<Long> call(){
        Future<Long> future = asyncCall.futureCall();
        asyncCall.shutdown();
        return future;
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        System.out.println("发起调用");
        Future<Long> future = demo3.call();
        System.out.println("返回结果");
       // while (!future.isDone() && !future.isCancelled());
        try {
            long res = future.get();
            System.out.println(res);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
