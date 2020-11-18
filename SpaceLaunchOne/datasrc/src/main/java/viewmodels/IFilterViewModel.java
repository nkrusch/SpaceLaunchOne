package viewmodels;

import java.util.List;

import androidx.lifecycle.LiveData;
import local.IFilter;

public interface IFilterViewModel<T> {

    LiveData<List<T>> getAll();

    void toggle(final IFilter item);

    void setAll(final boolean insert);
}
