package tech.jklaw.bitconnectcarlossoundboard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import de.cketti.library.changelog.ChangeLog;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private AdView mAdView;
    ListView listView;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-9986876982407306~2113273048");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        listView = (ListView) findViewById(R.id.listView);

        ChangeLog cl = new ChangeLog(this);
        if (cl.isFirstRun()) {
            cl.getLogDialog().show();
        }

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.sounds));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                try {
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
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Unable to play sound :(", Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Exception caught when playing sound:");
                    e.printStackTrace();
                }
            }
        });

        listView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Intent i = new Intent(this, AboutActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

}