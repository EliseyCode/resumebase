package ru.enovikow.resumedatabase.exception;

public class ResumeExistStorageException extends ResumeStorageException {
    public ResumeExistStorageException(String uuid) {
        super("Resume " + uuid + " already exist", uuid);
    }
}
