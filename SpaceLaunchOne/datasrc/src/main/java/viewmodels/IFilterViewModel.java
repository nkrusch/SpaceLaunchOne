package viewmodels;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface IFilterViewModel<T> {

    LiveData<List<T>> getAll();

    void toggle(final T item);

    void setAll(final boolean insert);
}
