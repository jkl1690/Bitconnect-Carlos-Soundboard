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

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import org.sufficientlysecure.donations.DonationsFragment;

public class DonationsActivity extends FragmentActivity {

    private static final String GOOGLE_PUBKEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmrCz5HKudiDvBqXptAZiU1T5YE7ydKYsF470IdLpK2qEGCKEaqXwYSg0CC17x/mMOZrXomd8Twrc7slU8ln7HZZ3R8IEouEXKONHoBVJ3Y0OugeXpspaM/oLHmNSAIO30vn+MvOHQv9S4/nqZoXSYEV953/mP4AXfeEORY7cIvDXzp13C3lXF3ZS3qbfRXnh/aCxlgNIB7LFP97oibRVfIoaNORiGCvnph+0M1cSEoWk97EjgOrvYFHlxPFBVUOTmwQP7mXJ84puo0Xy+KJ5yW1AQmLTj9mzJvOwUBLunPpMvht3yukebCdusm5C+pOrT4lY4cR1tNrVoAkwi4J88wIDAQAB";
    private static final String[] GOOGLE_CATALOG = new String[]{"bitconnect.donation.2",
            "bitconnect.donation.5"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.donations_activity);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        DonationsFragment donationsFragment;

            donationsFragment = DonationsFragment.newInstance(BuildConfig.DEBUG, true, GOOGLE_PUBKEY, GOOGLE_CATALOG,
                    getResources().getStringArray(R.array.donation_google_catalog_values), false, null, null,
                    null, false, null, null, false, null);

        ft.replace(R.id.donations_activity_container, donationsFragment, "donationsFragment");
        ft.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag("donationsFragment");
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

}