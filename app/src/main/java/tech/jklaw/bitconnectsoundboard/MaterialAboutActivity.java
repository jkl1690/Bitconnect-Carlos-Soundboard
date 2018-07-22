/*
 * Bitconnect Carlos Soundboard
 * Copyright (C) 2018  jkl1690
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package tech.jklaw.bitconnectsoundboard;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;

import com.danielstone.materialaboutlibrary.adapters.MaterialAboutListAdapter;
import com.danielstone.materialaboutlibrary.model.MaterialAboutList;
import com.danielstone.materialaboutlibrary.util.DefaultViewTypeManager;
import com.danielstone.materialaboutlibrary.util.ViewTypeManager;

import java.lang.ref.WeakReference;

public abstract class MaterialAboutActivity extends AppCompatActivity {

    public static final String THEME_EXTRA = "";
    public static final int THEME_LIGHT_LIGHTBAR = 0;
    public static final int THEME_LIGHT_DARKBAR = 1;
    public static final int THEME_DARK_LIGHTBAR = 2;
    public static final int THEME_DARK_DARKBAR = 3;
    public static final int THEME_CUSTOM_CARDVIEW = 4;

    protected int colorIcon = R.color.mal_color_icon_light_theme;


    private MaterialAboutList list = new MaterialAboutList.Builder().build();
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private MaterialAboutListAdapter adapter;

    @NonNull
    protected abstract MaterialAboutList getMaterialAboutList(@NonNull Context context);

    @Nullable
    protected abstract CharSequence getActivityTitle();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        verifyAttributesExist();

        setContentView(R.layout.mal_material_about_activity);

        CharSequence title = getActivityTitle();
        if (title == null)
            setTitle(R.string.mal_title_about);
        else
            setTitle(title);


        assignViews();
        initViews();

        ListTask task = new ListTask(this);
        task.execute();
    }

    private void verifyAttributesExist() {
        TypedValue typedValue = new TypedValue();
        boolean malColorPrimaryExists =
                getTheme().resolveAttribute(R.attr.mal_color_primary, typedValue, true);
        boolean malColorSecondaryExists =
                getTheme().resolveAttribute(R.attr.mal_color_secondary, typedValue, true);
        if (!malColorPrimaryExists || !malColorSecondaryExists) {
            throw new IllegalStateException(String.format("The current theme doesn't provide %s " +
                            "and/or %s. Please use a theme provided by the library or an extension.",
                    getResources().getResourceEntryName(R.attr.mal_color_primary),
                    getResources().getResourceEntryName(R.attr.mal_color_secondary)));
        }
    }

    private void assignViews() {
        toolbar = (Toolbar) findViewById(R.id.mal_toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.mal_recyclerview);
        recyclerView.setAlpha(0f);
        recyclerView.setTranslationY(20);
    }

    private void initViews() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        adapter = new MaterialAboutListAdapter(getViewTypeManager());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
    }

    @NonNull
    protected ViewTypeManager getViewTypeManager() {
        return new DefaultViewTypeManager();
    }

    @NonNull
    protected MaterialAboutList getList() {
        return list;
    }

    protected boolean shouldAnimate() {
        return true;
    }

    protected void refreshMaterialAboutList() {
        setMaterialAboutList(list);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onTaskFinished(@Nullable MaterialAboutList materialAboutList) {
        if (materialAboutList != null) {
            list = materialAboutList;
            adapter.setData(list.getCards());

            if (shouldAnimate()) {
                recyclerView.animate()
                        .alpha(1f)
                        .translationY(0f)
                        .setDuration(600)
                        .setInterpolator(new FastOutSlowInInterpolator()).start();
            } else {
                recyclerView.setAlpha(1f);
                recyclerView.setTranslationY(0f);
            }
        } else {
            finish();
        }
    }

    protected void setMaterialAboutList(MaterialAboutList materialAboutList) {
        list = materialAboutList;
        adapter.setData(list.getCards());
    }

    protected void setScrollToolbar(boolean scrollToolbar) {
        if (toolbar != null) {
            AppBarLayout.LayoutParams params =
                    (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
            if (scrollToolbar) {
                params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                        | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
            } else {
                params.setScrollFlags(0);
            }
        }
    }

    private static class ListTask extends AsyncTask<String, String, MaterialAboutList> {

        private WeakReference<MaterialAboutActivity> context;

        ListTask(MaterialAboutActivity context) {
            this.context = new WeakReference<>(context);
        }

        @Override
        protected MaterialAboutList doInBackground(String... params) {
            return isCancelled() || context.get() == null ? null : context.get().getMaterialAboutList(context.get());
        }

        @Override
        protected void onPostExecute(MaterialAboutList materialAboutList) {
            super.onPostExecute(materialAboutList);
            if (context.get() != null) {
                if (!context.get().isFinishing()) {
                    context.get().onTaskFinished(materialAboutList);
                }
            }
            context = null;
        }
    }
}