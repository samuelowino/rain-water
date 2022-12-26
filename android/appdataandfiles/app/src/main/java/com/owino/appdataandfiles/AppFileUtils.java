package com.owino.appdataandfiles;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AppFileUtils {

    /**
     * Your app's ordinary, persistent files reside in a directory that you can access using the
     * {Context.fileDir} property of the context object.
     * <p>
     * The framework provides several methods to help you access and store files in this directoru
     *
     * @param context android.content.Context
     * @return java.io.File
     */
    private static File loadInternalFileDir(Context context) {
        return context.getFilesDir();
    }

    /**
     * As an alternative to using the {java.io.File} API, you can call openFileOutput()
     * to get a {java.io.FileOutputStream} that writes to a file within the {Context.fileDir}
     * directory.
     *
     * @param context  android.content.Context
     * @param fileName java.io.File
     * @return java.io.FileOutputStream
     * @throws FileNotFoundException Exception
     */
    private static FileOutputStream openInternalFileOutStream(Context context, String fileName) throws FileNotFoundException {
        return context.openFileOutput(fileName, Context.MODE_PRIVATE);
    }

    /**
     * Writes an empty file to fileDir.
     * <p>
     * You can use the {java.io.File} API to access and store files.
     * To help maintain your app's performance, don't open and close the same file multiple times.
     *
     * @param context  Context
     * @param fileName String
     */
    public static void writeFileInPersistentInternalFilesDir(Context context, String fileName) {
        File internalFilesDir = AppFileUtils.loadInternalFileDir(context);
        new File(internalFilesDir, fileName);
    }

    /**
     * FileOutputStream writes to a file within the filesDir  directory
     *
     * @param context Context
     * @param fileName String
     * @param content String
     */
    public static void writeFileInPersistentInternalFilesDir(Context context, String fileName, String content) {
        try {
            FileOutputStream fileOutputStream = AppFileUtils.openInternalFileOutStream(context, fileName);
            fileOutputStream.write(content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * List files in app internal directory
     *
     * You can get an array containing the names of all files within the {android.content.Context.filesDir}
     *
     *
     * @param context Context
     * @return String[]
     */
    public static String[] listFilesInAppInternalDir(Context context){
        return context.fileList();
    }

    /**
     * You can create nested directories by passing the root directory and a new
     * directory name into a {java.io.File} constructor
     *
     * @param context Context
     * @param directoryName java.io.File
     * @return java.io.File
     */
    public static File createDirectory(Context context, String directoryName){
        return new File(context.getFilesDir(), directoryName);
    }

    /**
     * Create a cached file by calling File.createTempFile()
     *
     * Apps access a file in this directory using the {android.content.Context.getCacheDir()}
     *
     * @param context android.content.Context
     * @param fileName java.lang.String
     * @return java.io.File
     * @throws IOException java.io.IOException
     */
    public static File createFileInCacheDir(Context context, String fileName) throws IOException {
        String suffix = null; //todo: what is this suffix thingi ?
        return File.createTempFile(fileName, suffix, context.getCacheDir());
    }

    /**
     * Delete cache file
     *
     * To remove a file from the cache directory within internal storage,
     * Call {android.content.Context.deleteFile(fileName)} or File.delete()
     *
     * @param context Context
     * @param fileName String
     * @return Boolean
     */
    public static boolean deleteCacheFile(Context context, String fileName){
        return context.deleteFile(fileName);
    }
}
