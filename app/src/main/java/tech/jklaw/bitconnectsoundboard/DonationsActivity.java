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

    private static final String GOOGLE_PUBKEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxU/i3wUcwvjWff19HTpY+LZ+7jI0+mwWruSGiL5jWmjibLyJpZgld5pIz3Q6GlMXzRNHU+fpNz9C1zX00PMjlxgckoCZOhdOEzh/F6uZc8cKwnkjLC4GUoDTWeExkNc0Q5dLm+9B8/u1LJ6L+8aMcRm1Z9VovlHOlY0/dWx9UkpqROy9M9mC9MKICjJJ5n1+KyE1uz33EqYeVx4da/5LwUpcYes6xGa0f+5YMJsaToICIgXjB3PvjsCOONoZd2nP59X9EGd/o/sFYKxkslaEBoxfYwQjdpOTIEk8i2Jue4p9xCobNR6/lyGBszkMtNvk9xNiPp23ZyIydzaN6BSKswIDAQAB";
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