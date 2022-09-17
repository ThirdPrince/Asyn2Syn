
public abstract class BaseDemo {

    private AsyncCall asyncCall = new AsyncCall();
    public abstract void callback(long response);
    public void call(){
        System.out.println("发起调用");
        asyncCall.call(this);
        System.out.println("调用返回");
    }


}
