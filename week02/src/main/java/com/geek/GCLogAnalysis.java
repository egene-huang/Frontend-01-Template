package com.geek;

import java.util.HashMap;
import java.util.Random;

/**
 * <br/>
 * User: eugene <br/>
 * Date&Time: 2021/3/28 21:04
 */
public class GCLogAnalysis {
    //-Xms128M -Xmx128M -XX:+UseSerialGC -XX:+PrintGCDetails
    //-Xms256M -Xmx256M -XX:+UseParallelGC -XX:+PrintGCDetails
    //-Xms256M -Xmx256M -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails
    //-Xms256M -Xmx256M -XX:+UseG1GC -XX:MaxGCPauseMillis=100 -XX:+PrintGCDetails
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        int interval = 30 * 1000;
        Random random = new Random();
        Object[] objects = new Object[1000];
        HashMap<KeyWrap, Object> cache = new HashMap<>(1024);
        while (true) {
            if (System.currentTimeMillis() - l > interval) {
                break;
            }
            int nextInt = random.nextInt(100 * 1024);
            Object mock = mock(nextInt);
            cache.put(new KeyWrap(nextInt), mock);
            int anInt = random.nextInt(4 * 1000);
            if (anInt < 1000) {
                objects[anInt] = mock;
            }
        }
        System.out.println("cache.size = " + cache.size());
    }
    static class KeyWrap {
        int key;

        public KeyWrap(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            KeyWrap keyWrap = (KeyWrap) o;

            return key == keyWrap.key;
        }

        @Override
        public int hashCode() {
            return key;
        }
    }

    static Object mock(int source) {
        int mod = source % 2;
        switch (mod) {
            case 0:
//                return new Integer(source);
            case 1:
//                return new Byte[source];
            case 2:
//                return new Object();
            case 3:
//                return new Long(source);
//            case 4:
            default:
                return new Object[source];
//            default:
//                return "模拟业务使用字符串";
        }
    }
}
