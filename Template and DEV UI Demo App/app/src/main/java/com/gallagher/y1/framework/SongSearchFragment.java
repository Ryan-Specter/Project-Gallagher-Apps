package com.gallagher.y1.framework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * SongSearchFragment: Demo for a Song Search UI.
 * Replace with a real search UI as needed.
 */
public class SongSearchFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv = new TextView(inflater.getContext());
        tv.setText("Song Search Demo\n(Replace with real UI)");
        tv.setTextSize(24);
        tv.setGravity(android.view.Gravity.CENTER);
        return tv;
    }
} 