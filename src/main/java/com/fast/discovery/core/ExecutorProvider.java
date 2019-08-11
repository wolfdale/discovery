package com.fast.discovery.core;

import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorProvider {
    public static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

    private ThreadPoolExecutor executor;

}
