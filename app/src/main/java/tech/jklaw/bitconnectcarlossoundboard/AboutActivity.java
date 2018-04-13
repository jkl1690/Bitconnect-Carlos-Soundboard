/*
 *     Bitconnect Carlos Soundboard
 *     Copyright (C) 2018  jkl1690
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package tech.jklaw.bitconnectcarlossoundboard;

import android.os.Bundle;
import android.preference.Preference;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import de.psdev.licensesdialog.LicensesDialog;
import de.psdev.licensesdialog.licenses.ApacheSoftwareLicense20;
import de.psdev.licensesdialog.licenses.GnuGeneralPublicLicense30;
import de.psdev.licensesdialog.licenses.GnuLesserGeneralPublicLicense21;
import de.psdev.licensesdialog.model.Notice;
import de.psdev.licensesdialog.model.Notices;

public class AboutActivity extends AppCompatPreferenceActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        addPreferencesFromResource(R.xml.about);

        Preference ospLicenceDialog = findPreference("open_source");
        Preference appLicence = findPreference("licence");

        ospLicenceDialog.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                final Notices notices = new Notices();
                notices.addNotice(new Notice("Android Donations Library", "https://github.com/PrivacyApps/donations", "PrivacyApps", new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("ckChangelog", "https://github.com/cketti/ckChangeLog", "cketti", new ApacheSoftwareLicense20()));
                new LicensesDialog.Builder(AboutActivity.this).setNotices(notices).setIncludeOwnLicense(true).build().show();
                return false;
            }
        });

        appLicence.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                final Notices notices = new Notices();
                notices.addNotice(new Notice("Bitconnect Carlos Soundboard", "https://github.com/jkl1690/Bitconnect-Carlos-Soundboard", "jkl1690", new GnuGeneralPublicLicense30()));
                new LicensesDialog.Builder(AboutActivity.this).setNotices(notices).setIncludeOwnLicense(false).build().show();
                return false;
            }
        });

    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}