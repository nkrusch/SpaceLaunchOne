package api;

public interface OnLoadCallback<T> {
    void call(T result);
    void onError(Exception e);
}
