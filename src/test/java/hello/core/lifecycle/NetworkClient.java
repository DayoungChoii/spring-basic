package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.naming.ldap.InitialLdapContext;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url=" + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect " + url);
    }

    public void call(String message) {
        System.out.println("call: "+ url + "message = " + message);
    }

    //서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close" + url);
    }

    @Override
    public void afterPropertiesSet() throws Exception { //의존관계 주입이 끝나
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 생성 메시지");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
