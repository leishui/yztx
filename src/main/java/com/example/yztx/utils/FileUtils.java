package com.example.yztx.utils;

import java.io.File;

public class FileUtils {
    /**
     * 创建或重命名文件
     * ps：sss.jpg    sss(1).jpg
     * @param from
     * @param toPrefix
     * @param toSuffix
     * @return
     */
    public static File createOrRenameFile(File from, String toPrefix, String toSuffix) {
        File directory = from.getParentFile();
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Created directory " + directory.getAbsolutePath());
            }
        }
        File newFile = new File(directory, toPrefix + toSuffix);
        for (int i = 1; newFile.exists() && i < Integer.MAX_VALUE; i++) {
            newFile = new File(directory, toPrefix + "(" + i + ")" + toSuffix);
        }
        if (!from.renameTo(newFile)) {
            System.out.println("Couldn't rename file to " + newFile.getAbsolutePath());
            return from;

        }
        return newFile;
    }

    /**
     * 获取File的   . 前后字串
     * @param from
     * @return
     */
    public static String[] getFileInfo(File from) {
        String fileName = from.getName();
        int index = fileName.lastIndexOf(".");
        String toPrefix = "";
        String toSuffix = "";
        if (index == -1) {
            toPrefix = fileName;
        } else {
            toPrefix = fileName.substring(0, index);
            toSuffix = fileName.substring(index, fileName.length());
        }
        return new String[]{toPrefix, toSuffix};
    }
}
