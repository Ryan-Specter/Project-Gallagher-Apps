package com.gallagher.y1.framework;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * MainActivity: iPod Classic-style split-screen menu for Project Gallagher App Framework.
 * Left: ListView of demo interfaces. Right: Placeholder icon for selected demo.
 * Modular, portable, and well-commented for reuse in other Y1 apps.
 */
public class MainActivity extends AppCompatActivity {
    private ListView demoMenuList;
    private FrameLayout demoPreviewContainer;
    private ArrayAdapter<String> menuAdapter;
    private List<String> demoItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find split-screen views
        demoMenuList = findViewById(R.id.demo_menu_list);
        demoPreviewContainer = findViewById(R.id.demo_preview_container);

        // Demo menu items (add more as needed)
        demoItems = new ArrayList<>();
        demoItems.add("Now Playing Screen");
        demoItems.add("Song Search");
        demoItems.add("Library Interface");
        demoItems.add("Bluetooth Settings");
        demoItems.add("WiFi Settings");
        demoItems.add("Theme Picker");
        demoItems.add("Horizontal Context Menu");
        demoItems.add("Playlist Creation");
        demoItems.add("IME Demo");
        demoItems.add("Custom Control Showcase");
        // Add more creative demos here

        menuAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, demoItems);
        demoMenuList.setAdapter(menuAdapter);
        demoMenuList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // Set initial selection and preview
        demoMenuList.setItemChecked(0, true);
        showDemoPreview(0);

        // Handle menu selection changes
        demoMenuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDemoPreview(position);
            }
        });

        // Optional: handle D-pad navigation for focus clarity
        demoMenuList.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus && demoMenuList.getCheckedItemPosition() == AdapterView.INVALID_POSITION) {
                demoMenuList.setItemChecked(0, true);
                showDemoPreview(0);
            }
        });
    }

    /**
     * Show a placeholder icon in the right pane for the selected demo item.
     * Replace with actual demo fragments or previews as needed.
     */
    private void showDemoPreview(int position) {
        demoPreviewContainer.removeAllViews();
        ImageView icon = new ImageView(this);
        // Use different icons for each demo, or a generic placeholder
        int resId = getPlaceholderIconResId(position);
        icon.setImageResource(resId);
        icon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        icon.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
        demoPreviewContainer.addView(icon);
    }

    /**
     * Get a placeholder icon resource for each demo item.
     * Replace with custom icons as needed.
     */
    private int getPlaceholderIconResId(int position) {
        switch (position) {
            case 0: return android.R.drawable.ic_media_play; // Now Playing
            case 1: return android.R.drawable.ic_menu_search; // Song Search
            case 2: return android.R.drawable.ic_menu_agenda; // Library
            case 3: return android.R.drawable.ic_menu_call; // Bluetooth (placeholder)
            case 4: return android.R.drawable.ic_menu_manage; // WiFi (placeholder)
            case 5: return android.R.drawable.ic_menu_gallery; // Theme Picker
            case 6: return android.R.drawable.ic_menu_more; // Context Menu
            case 7: return android.R.drawable.ic_input_add; // Playlist Creation
            case 8: return android.R.drawable.ic_menu_edit; // IME Demo
            case 9: return android.R.drawable.ic_menu_view; // Custom Control
            default: return android.R.drawable.ic_menu_help;
        }
    }
}