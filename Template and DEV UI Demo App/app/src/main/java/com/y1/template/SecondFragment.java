package com.gallagher.y1.framework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * SecondFragment: Placeholder for a demo UI component. Refactor for modular use.
 */
public class SecondFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Replace with actual demo UI
        View view = new View(inflater.getContext());
        view.setBackgroundColor(0xFFAAAAAA); // Slightly darker gray placeholder
        return view;
    }
}