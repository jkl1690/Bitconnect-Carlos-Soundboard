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

package tech.jklaw.bitconnectsoundboard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.google.ads.consent.ConsentForm;
import com.google.ads.consent.ConsentFormListener;
import com.google.ads.consent.ConsentInfoUpdateListener;
import com.google.ads.consent.ConsentInformation;
import com.google.ads.consent.ConsentStatus;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.net.MalformedURLException;
import java.net.URL;

import de.cketti.library.changelog.ChangeLog;


public class MainActivity extends AppCompatActivity  {

    private InterstitialAd mInterstitialAd;

    ListView listView;

    private String TAG = this.getClass().getSimpleName();

    private ConsentForm form;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        checkForConsent();

        ChangeLog cl = new ChangeLog(this);
        if (cl.isFirstRun()) {
            cl.getLogDialog().show();
        }

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.sounds));


        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            try {

                MediaPlayer mp = new MediaPlayer();

                switch (i) {
                    case 0:
                        mp = MediaPlayer.create(getApplicationContext(), R.raw.a137days);
                        mp.start();
                        break;
                    case 1:
                        mp = MediaPlayer.create(getApplicationContext(), R.raw.a140000);
                        mp.start();
                        break;
                    case 2:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.a25610);
                        mp.start();
                        break;
                    case 3:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.bank);
                        mp.start();
                        break;
                    case 4:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.bitcoins);
                        mp.start();
                        break;
                    case 5:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.bitconnect1);
                        mp.start();
                        break;
                    case 6:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.bitconnect2);
                        mp.start();
                        break;
                    case 7:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.conartist);
                        mp.start();
                        break;
                    case 8:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.everyday);
                        mp.start();
                        break;
                    case 9:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.explode);
                        mp.start();
                        break;
                    case 10:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.faithandbelief);
                        mp.start();
                        break;
                    case 11:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.financiallyindependently);
                        mp.start();
                        break;
                    case 12:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.hahaha);
                        mp.start();
                        break;
                    case 13:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.hhh);
                        mp.start();
                        break;
                    case 14:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.hhhlong);
                        mp.start();
                        break;
                    case 15:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.ilovebitconnect);
                        mp.start();
                        break;
                    case 16:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.losemoney);
                        mp.start();
                        break;
                    case 17:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.mmmmmmnonono);
                        mp.start();
                        break;
                    case 18:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.mynameiscarlos);
                        mp.start();
                        break;
                    case 19:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.naw);
                        mp.start();
                        break;
                    case 20:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.nonononono);
                        mp.start();
                        break;
                    case 21:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.onehunimean);
                        mp.start();
                        break;
                    case 22:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.real);
                        mp.start();
                        break;
                    case 23:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.scam);
                        mp.start();
                        break;
                    case 24:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.scammergame);
                        mp.start();
                        break;
                    case 25:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.seed);
                        mp.start();
                        break;
                    case 26:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.table);
                        mp.start();
                        break;
                    case 27:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.tellusomething);
                        mp.start();
                        break;
                    case 28:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.tookmoney);
                        mp.start();
                        break;
                    case 29:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.vietnam);
                        mp.start();
                        break;
                    case 30:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.wearecoming);
                        mp.start();
                        break;
                    case 31:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.wearestarting);
                        mp.start();
                        break;
                    case 32:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.what);
                        mp.start();
                        break;
                    case 33:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.whatamigonnado);
                        mp.start();
                        break;
                    case 34:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.wife);
                        mp.start();
                        break;
                    case 35:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.woah);
                        mp.start();
                        break;
                    case 36:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.wooooo);
                        mp.start();
                        break;
                    case 37:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.wowowowowo);
                        mp.start();
                        break;
                    case 38:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.wusup);
                        mp.start();
                        break;
                    case 39:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.wusuwusup);
                        mp.start();
                        break;
                    case 40:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.wusuwusuwusu);
                        mp.start();
                        break;
                    case 41:
                        mp = MediaPlayer.create(MainActivity.this, R.raw.yeyeyeyeyeye);
                        mp.start();
                        break;
                }

                mp.setOnCompletionListener(MediaPlayer::release);

            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Unable to play sound :(", Toast.LENGTH_LONG).show();
                Log.e(TAG, "Exception caught when playing sound:");
                e.printStackTrace();
            }
        });

        listView.setAdapter(mAdapter);
    }

    private void checkForConsent() {
        ConsentInformation consentInformation = ConsentInformation.getInstance(MainActivity.this);
        String[] publisherIds = {"pub-9986876982407306"};
        consentInformation.requestConsentInfoUpdate(publisherIds, new ConsentInfoUpdateListener() {
            @Override
            public void onConsentInfoUpdated(ConsentStatus consentStatus) {
                // User's consent status successfully updated.
                switch (consentStatus) {
                    case PERSONALIZED:
                        Log.d(TAG, "Showing Personalized ads");
                        showPersonalizedAds();
                        break;
                    case NON_PERSONALIZED:
                        Log.d(TAG, "Showing Non-Personalized ads");
                        showNonPersonalizedAds();
                        break;
                    case UNKNOWN:
                        Log.d(TAG, "Requesting Consent");
                        if (ConsentInformation.getInstance(getBaseContext())
                                .isRequestLocationInEeaOrUnknown()) {
                            requestConsent();
                        } else {
                            showPersonalizedAds();
                        }
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailedToUpdateConsentInfo(String errorDescription) {
                // User's consent status failed to update.
            }
        });
    }

    private void requestConsent() {
        URL privacyUrl = null;
        try {
            privacyUrl = new URL("https://your.privacy.url/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            // Handle error.
        }
        form = new ConsentForm.Builder(MainActivity.this, privacyUrl)
                .withListener(new ConsentFormListener() {
                    @Override
                    public void onConsentFormLoaded() {
                        // Consent form loaded successfully.
                        Log.d(TAG, "Requesting Consent: onConsentFormLoaded");
                        showForm();
                    }

                    @Override
                    public void onConsentFormOpened() {
                        // Consent form was displayed.
                        Log.d(TAG, "Requesting Consent: onConsentFormOpened");
                    }

                    @Override
                    public void onConsentFormClosed(
                            ConsentStatus consentStatus, Boolean userPrefersAdFree) {
                        Log.d(TAG, "Requesting Consent: onConsentFormClosed");
                        if (userPrefersAdFree) {
                            // Buy or Subscribe
                            Log.d(TAG, "Requesting Consent: User prefers AdFree");
                        } else {
                            Log.d(TAG, "Requesting Consent: Requesting consent again");
                            switch (consentStatus) {
                                case PERSONALIZED:
                                    showPersonalizedAds();break;
                                case NON_PERSONALIZED:
                                    showNonPersonalizedAds();break;
                                case UNKNOWN:
                                    showNonPersonalizedAds();break;
                            }

                        }
                }

                    @Override
                    public void onConsentFormError(String errorDescription) {
                        Log.d(TAG, "Requesting Consent: onConsentFormError. Error - " + errorDescription);
                        // Consent form error.
                    }
                })
                .withPersonalizedAdsOption()
                .withNonPersonalizedAdsOption()
                .build();
        form.load();
    }

    private void showPersonalizedAds() {
        MobileAds.initialize(this, "ca-app-pub-9986876982407306~2113273048");
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
    }

    private void showNonPersonalizedAds() {
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, getNonPersonalizedAdsBundle())
                .build();
        mAdView.loadAd(adRequest);
    }

    private Bundle getNonPersonalizedAdsBundle() {
        Bundle extras = new Bundle();
        extras.putString("npa","1");
        return extras;
    }

    private void showForm() {
        if (form == null) {
            Log.d(TAG, "Consent form is null");
        }
        if (form != null) {
            Log.d(TAG, "Showing consent form");
            form.show();
        } else {
            Log.d(TAG, "Not Showing consent form");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_about) {

            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-9986876982407306/4172761807");
            mInterstitialAd.loadAd(new AdRequest.Builder().build());

            mInterstitialAd.setAdListener(new AdListener() {
                public void onAdLoaded() {
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        Intent i = new Intent(MainActivity.this, AboutActivity.class);
                        startActivity(i);
                        Log.i("Ads", "Interstitial init failed, activity launched.");
                    }
                }

                @Override
                public void onAdClosed() {
                    Intent i = new Intent(MainActivity.this, AboutActivity.class);
                    startActivity(i);
                    Log.i("Ads", "Activity launched upon ad exit.");
                }
            });

        }

        return super.onOptionsItemSelected(item);
    }

}