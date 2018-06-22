package com.speckulate.speckulate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

public class PhotosFragment extends Fragment {
    public String FRAGMENT_TAG = this.getClass().toString();
    private RadioButton bookmark;
    private RadioButton share;
    private ViewGroup viewGroup;

    @Override
    public View onCreateView(LayoutInflater layoutInflater,
                             ViewGroup containerView,
                             Bundle savedInstanceState) {

        viewGroup =
                (ViewGroup) layoutInflater.inflate(R.layout.photos_fragment, null, false);

        bookmark = (RadioButton) viewGroup.findViewById(R.id.bookmark);
        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookmark.toggle();
            }
        });

        share = (RadioButton) viewGroup.findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                share.toggle();
            }
        });

        return viewGroup;
    }
}
