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

import com.danielstone.materialaboutlibrary.MaterialAboutFragment;
import com.danielstone.materialaboutlibrary.model.MaterialAboutList;

import static tech.jklaw.bitconnectsoundboard.MaterialAboutActivity.THEME_LIGHT_DARKBAR;

public class materialAboutFragment extends MaterialAboutFragment {

    @Override
    protected MaterialAboutList getMaterialAboutList(final Context c) {
        return AboutActivity.createMaterialAboutList(c, R.color.mal_color_icon_dark_theme, THEME_LIGHT_DARKBAR);
    }

    @Override
    protected int getTheme() {
        return R.style.AppTheme_MaterialAboutActivity_Fragment;
    }

}
