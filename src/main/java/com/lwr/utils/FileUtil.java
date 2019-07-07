package com.lwr.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {

    /**
     * 如果toFile存在可能会被覆盖
     * @param fromFile
     * @param toFile
     * @throws IOException 
     */
    public static void copy(File fromFile, File toFile) throws IOException {
        copy(new FileInputStream(fromFile), toFile);
    }

    public static void copy(InputStream inputStream, File toFile) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(inputStream, 1024);
            out = new BufferedOutputStream(new FileOutputStream(toFile), 1024);
            byte[] buffer = new byte[1024];
            int size = 0;
            while ((size = in.read(buffer)) > 0) {
                out.write(buffer, 0, size);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
