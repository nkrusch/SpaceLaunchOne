package io.github.nkrusch.spacelaunchone.features.locations.details;

import io.github.nkrusch.spacelaunchone.features.launches.ListAdapter;

@SuppressWarnings("unused")
interface IListClickHandler {
    void setOnItemClickHandler(ListAdapter.OnItemClickListener handler);
}
