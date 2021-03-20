package com.hello;

import javax.xml.stream.events.EndDocument;
import java.io.*;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;

/**
 * <br/>
 * User: eugene <br/>
 * Date&Time: 2021/3/20 22:07
 */
public class HelloXClassLoader extends ClassLoader{
    public static void main(String[] args) throws Exception {
//        loadAndConvert();
        Object hello = new HelloXClassLoader().findClass("Hello").newInstance();
        Method[] methods = hello.getClass().getMethods();
        for (Method method : methods) {
            String name = method.getName();
//            System.out.println("method.getName() = " + name);
            if ("hello".equals(name)) {
                method.invoke(hello,null);
                break;
            }
        }
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        sun.misc.Launcher.getBootstrapClassPath().getURLs()
        byte[] bytes = loadAndConvert();
        if (bytes == null || bytes.length == 0) {
            throw new ClassNotFoundException(name);
        }
        return super.defineClass(name, bytes, 0, bytes.length);
    }


    protected byte[] loadAndConvert() {
        String basePath = "/Users/eugene/projects/Frontend-01-Template/week01/src/main/java/com/hello/";
        String xclass = basePath.concat("Hello.xlass");
        BufferedInputStream bufferedInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            int read;
            bufferedInputStream = new BufferedInputStream(new FileInputStream(xclass));
            byteArrayOutputStream = new ByteArrayOutputStream();
            while ((read = bufferedInputStream.read()) != -1) {
                byteArrayOutputStream.write(255 - read);
            }
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
