/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // 使用默认的无参构造器创建TreeMap对象是无序的
        // 使用有参构造器，传入一个比较对象
        // put方法
        /*
        * 第一次添加
        Entry<K, V> t = this.root;
        if (t == null) {
            this.compare(key, key);
            this.root = new Entry(key, value, (Entry)null);
            this.size = 1;
            ++this.modCount;
            return null;
        * 以后添加
        * Comparator<? super K> cpr = this.comparator;
            int cmp;
            Entry parent;
            if (cpr != null) {
                do {
                    parent = t;
                    cmp = cpr.compare(key, t.key);
                    if (cmp < 0) {
                        t = t.left;
                    } else {
                        if (cmp <= 0) {
                            return t.setValue(value);
                        }

                        t = t.right;
                    }
                } while(t != null);
            } else {
                if (key == null) {
                    throw new NullPointerException();
                }

                Comparable<? super K> k = (Comparable)key;

                do {
                    parent = t;
                    cmp = k.compareTo(t.key);
                    if (cmp < 0) {
                        t = t.left;
                    } else {
                        if (cmp <= 0) {
                            return t.setValue(value);
                        }

                        t = t.right;
                    }
                } while(t != null);
            }

            Entry<K, V> e = new Entry(key, value, parent);
            if (cmp < 0) {
                parent.left = e;
            } else {
                parent.right = e;
            }

            this.fixAfterInsertion(e);
            ++this.size;
            ++this.modCount;
            return null;
        }
        * */
        System.out.println("Hello world!");
    }
}