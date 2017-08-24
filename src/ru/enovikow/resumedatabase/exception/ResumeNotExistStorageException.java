package ru.enovikow.resumedatabase.exception;

public class ResumeNotExistStorageException extends ResumeStorageException {
    public ResumeNotExistStorageException(String uuid) {
        super("Resume " + uuid + " not exist", uuid);
    }
}
