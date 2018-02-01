package tech.jklaw.bitconnectcarlossoundboard;

import android.os.Bundle;
import android.preference.Preference;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import de.psdev.licensesdialog.LicensesDialog;
import de.psdev.licensesdialog.licenses.ApacheSoftwareLicense20;
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
                notices.addNotice(new Notice("ckChangelog", "https://github.com/cketti/ckChangeLog", "cketti", new ApacheSoftwareLicense20()));
                new LicensesDialog.Builder(AboutActivity.this).setNotices(notices).setIncludeOwnLicense(true).build().show();
                return false;
            }
        });

        appLicence.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                final Notices notices = new Notices();
                notices.addNotice(new Notice("Bitconnect Carlos Soundboard", "https://github.com/jkl1690/Bitconnect-Carlos-Soundboard", "jkl1690", new GnuLesserGeneralPublicLicense21()));
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