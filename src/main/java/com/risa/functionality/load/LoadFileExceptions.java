package com.risa.functionality.load;

public class LoadFileExceptions extends Exception {
    /**
     * Error codes :
     * 1 -> When oppenning and reading file.
     * 2 -> When valueOfTypeRoute or valueOfTypeLieu returns null value.
     * 3 -> When
     */
    private final int errorCode;

    public LoadFileExceptions(int errorCode) {
        this.errorCode = errorCode;
    }
}
