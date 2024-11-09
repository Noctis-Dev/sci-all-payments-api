package org.noctisdev.payments.utils;

public class ThreadsUtil {

    public static void runTask(Runnable task) {
        new Thread(task).start();
    }

}
