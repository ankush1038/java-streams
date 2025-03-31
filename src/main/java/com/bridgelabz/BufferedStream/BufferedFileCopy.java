package com.bridgelabz.BufferedStream;

import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        // Input file (100MB+ for testing)
        String sourceFile = "src/main/java/com/bridgelabz/BufferedStream/largeFile";

        // Output using buffered streams
        String destBuffered = "src/main/java/com/bridgelabz/BufferedStream//bufferedcopy";

        // Output using unbuffered streams
        String destUnbuffered = "src/main/java/com/bridgelabz/BufferedStream//unBufferedcopy";

        // Measure performance for buffered stream
        long startBuffered = System.nanoTime();
        copyFileUsingBufferedStreams(sourceFile, destBuffered);
        long endBuffered = System.nanoTime();
        // Convert to milliseconds
        long timeBuffered = (endBuffered - startBuffered) / 1_000_000;

        // Measure performance for unbuffered stream
        long startUnbuffered = System.nanoTime();
        copyFileUsingUnbufferedStreams(sourceFile, destUnbuffered);
        long endUnbuffered = System.nanoTime();
        long timeUnbuffered = (endUnbuffered - startUnbuffered) / 1_000_000;

        System.out.println("Buffered Streams Copy Time: " + timeBuffered + " ms");
        System.out.println("Unbuffered Streams Copy Time: " + timeUnbuffered + " ms");
    }

    //BufferedInputStream and BufferedOutputStream
    public static void copyFileUsingBufferedStreams(String source, String destination) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            // 4 KB buffer
            byte[] buffer = new byte[4096];

            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully using Buffered Streams.");
        } catch (IOException e) {
            System.err.println("Error copying file using Buffered Streams: " + e.getMessage());
        }
    }

    //unbuffered FileInputStream and FileOutputStream
    public static void copyFileUsingUnbufferedStreams(String source, String destination) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                // Writing one byte at a time (inefficient)
                fos.write(byteData);
            }

            System.out.println("File copied successfully using Unbuffered Streams.");
        } catch (IOException e) {
            System.err.println("Error copying file using Unbuffered Streams: " + e.getMessage());
        }
    }
}

/*

O/P->
File copied successfully using Buffered Streams.
File copied successfully using Unbuffered Streams.
Buffered Streams Copy Time: 15 ms
Unbuffered Streams Copy Time: 18733 ms
 */