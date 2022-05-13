package api;

/**
 * Generic handler for some an async operation.
 *
 * @param <T>  Type of successful result.
 */
public interface AsyncCallback<T> {
    /**
     * the method to call when specific async operation succeeds.
     *
     * @param result  Result of the async procedure.
     */
    void onSuccess(T result);

    /**
     * The method to call when specified async operation throws an exception.
     *
     * @param exception  The raised exception.
     */
    void onError(Exception exception);
}
