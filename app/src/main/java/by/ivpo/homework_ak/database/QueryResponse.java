package by.ivpo.homework_ak.database;

public interface QueryResponse<T> {
    void onSuccess(T data);
    void onFailure(String message);
}
