package com.sodse.trade.redis.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeUtil {
    public static final String TAG = "SerializeUtil";

    /**
     * 序列化
     *
     * @param object
     * @return
     * @throws IOException
     */
    public static byte[] serialize(Object object) throws IOException {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
//            Log.e(TAG, "序列化对象发生错误，返回NULL");
            return null;
        }
    }

    /**
     * 反序列化
     *
     * @param bytes
     * @return
     */
    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
//            Log.e(TAG, "反序列化对象发生错误，返回NULL");
            return null;
        }
    }

    /**
     * 集合序列化
     * @param object
     * @return
     */
    public static byte[] serializeListObject(List<?> object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            //oos.writeObject(object);
            for(Object obj : object){
                oos.writeObject(obj);
            }
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 集合反序列化
     * @param in
     * @return
     */
    public static List<Object> deserialize(byte[] in) {
        List<Object> list = new ArrayList();
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if(in != null) {
                bis=new ByteArrayInputStream(in);
                is=new ObjectInputStream(bis);
                while (true) {
                    Object obj=(Object) is.readObject();

                    if(obj == null){
                        break;
                    }else{
                        list.add(obj);
                    }
                }
                is.close();
                bis.close();
            }
        } catch (IOException e) {

        }  catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }
        return list;
    }


}
