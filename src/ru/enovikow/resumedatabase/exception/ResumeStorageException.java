package ru.enovikow.resumedatabase.exception;

public class ResumeStorageException extends RuntimeException {
    private final String uuid;

    public ResumeStorageException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
