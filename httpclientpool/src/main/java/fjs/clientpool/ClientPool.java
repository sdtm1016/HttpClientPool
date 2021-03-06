package fjs.clientpool;

import fjs.client.Client;
import fjs.http.Request;
import fjs.http.RequestFuture;
import fjs.lifecycle.Lifecycle;

/**
 * Created by fjs on 14-6-20.
 */
public interface ClientPool extends Lifecycle{
    /**
     * 获取当前连接的远端的地址
     * @return
     */
    public String getRemoteHost();

    /**
     * 获取当前pool的规模，其实也就是有多少个client
     * @return
     */
    public int getSize();

    /**
     * 发送一个http请求，并返回一个RequestFuture
     * @param request
     * @return
     */
    public RequestFuture request(Request request);

    /**
     * 向当前的pool添加client
     * @param client
     */
    public void addClient(Client client);


    /**
     * 移除一个client
     * @param client
     */
    public void removeClient(Client client);
    /**
     * 带有超时控制的请求
     * @param request
     * @param time  单位为微秒
     * @return
     */
    RequestFuture requestWithTimeOut(Request request, int time);

    /**
     * 当有client退出的时候的处理，相当于提供给client的回调
     * @param client
     */
    public void clientExit(Client client);

    /**
     * 延迟执行一个task，单位微秒
     * @param task
     * @param time
     */
    public  void schuild(Runnable task, int time);


}
