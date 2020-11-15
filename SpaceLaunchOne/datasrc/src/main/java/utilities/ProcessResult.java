package utilities;

import apimodels.LaunchListDetailed;
import apimodels.data.BuildConfig;

public class ProcessResult {
    boolean success;
    int nextOffset;

    public boolean isSuccess() {
        return success;
    }

    public int getNextOffset() {
        return nextOffset;
    }

    public void setResult(boolean success, LaunchListDetailed result, int offset) {
        this.success = success;
        if (result == null) {
            this.nextOffset = offset;
        } else if (result.getNext() == null || offset >= result.getCount()) {
            this.nextOffset = 0;
        } else {
            this.nextOffset = offset + BuildConfig.PageSize;
        }
    }
}
