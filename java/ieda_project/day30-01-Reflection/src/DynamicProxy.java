import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ljw
 * @version 1.0
 * 态代要想实现动理，需要解决的问题？
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
 * Proxy.newProxyInstance
 * 问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法。
 */
public class DynamicProxy {
    public static void main(String[] args) {
        BProxy bProxy = new BProxy();
        H proxyInstance = (H) ProxyFactory.getProxyInstance(bProxy);
        proxyInstance.add();
        System.out.println(proxyInstance.eat("鱼"));

    }
}

interface H {
    void add();

    String eat(String food);
}

class BProxy implements H {

    @Override
    public void add() {
        System.out.println("Adding...");
    }

    @Override
    public String eat(String food) {
        return "爱吃" + food;
    }
}

class ProxyFactory {
    public static Object getProxyInstance(Object object) { // obj为被代理的对象
        // object.getClass().getClassLoader() 获得被代理类的类加载器
        // object.getClass().getInterfaces() 获得被代理类所实现的接口
        // InvocationHandler h 一个实现了InvocationHandler接口的类

        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
                new MyInvocationHandler(object));

    }
}

class MyInvocationHandler implements InvocationHandler {
    private final Object obj; // 被代理类的对象

    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    // 当我们通过代理类的对象，调用方法a时，就会调用如下方法invoke()
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // method 代理类调用的方法
        System.out.println("你正在被代理...");
        Object invoke = method.invoke(obj, args);
        System.out.println("代理结束...");
        return invoke;
    }
}