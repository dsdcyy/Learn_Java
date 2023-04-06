import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ljw
 * @version 1.0
 */
public class AOP_ {
    public static void main(String[] args) {
        A1 a1 = new A1();
        A proxyInstance = (A) A2.getProxyInstance(a1);
        proxyInstance.hi();
    }
}

interface A {
    void hi();
}

class A1 implements A {
    @Override
    public void hi() {
        System.out.println("hi");
    }
}

class A2 {
    public static Object getProxyInstance(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new A3(obj));
    }
}

class TestAOP {
    public void say() {
        System.out.println("ao wu");
    }

    public void diver() {
        System.out.println("I am diver...");
    }
}

class A3 implements InvocationHandler {
    Object obj;

    public A3(Object obj) {
        this.obj = obj;
    }

    TestAOP testAOP = new TestAOP();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        testAOP.say();
        Object invoke = method.invoke(obj, args);
        testAOP.diver();
        return invoke;
    }
}