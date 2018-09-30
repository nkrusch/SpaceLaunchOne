package io.github.nkrusch.spacelaunchone.features.details;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.github.nkrusch.spacelaunchone.R;

/**
 * Custom view element that displays label and text value
 * reference: https://stackoverflow.com/a/17413018
 */
public class SummaryItem extends LinearLayout {

    private TextView mLabel;
    private TextView mValue;

    public SummaryItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    public SummaryItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SummaryItem(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        View view = inflate(getContext(), R.layout.item_summary_entry, null);
        mLabel = view.findViewById(R.id.summary_label);
        mValue = view.findViewById(R.id.summary_value);
        addView(view);
    }

    private void setText(String label, String value) {
        mLabel.setText(label);
        mValue.setText(value);
    }
    public void setText(int labelResId, String value) {
        String label = mLabel.getContext().getResources().getString(labelResId);
        this.setText(label, value);
    }
}
