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
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.net.Uri;

import com.danielstone.materialaboutlibrary.ConvenienceBuilder;
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem;
import com.danielstone.materialaboutlibrary.items.MaterialAboutTitleItem;
import com.danielstone.materialaboutlibrary.model.MaterialAboutCard;
import com.danielstone.materialaboutlibrary.model.MaterialAboutList;
import com.danielstone.materialaboutlibrary.util.OpenSourceLicense;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.iconics.IconicsDrawable;

public class AboutActivity {

        public static MaterialAboutList createMaterialAboutList(final Context c, final int colorIcon, final int theme) {
            MaterialAboutCard.Builder appCardBuilder = new MaterialAboutCard.Builder();


            appCardBuilder.addItem(new MaterialAboutTitleItem.Builder()
                    .text("Bitconnect Carlos Soundboard")
                    .desc("© 2018 jkl1690")
                    .icon(R.mipmap.ic_launcher)
                    .build());

            appCardBuilder.addItem(ConvenienceBuilder.createVersionActionItem(c,
                    new IconicsDrawable(c)
                            .icon(CommunityMaterial.Icon.cmd_information_outline)
                            .color(ContextCompat.getColor(c, colorIcon))
                            .sizeDp(18),
                    "Version",
                    false));

            appCardBuilder.addItem(new MaterialAboutActionItem.Builder()
                    .text("View Source on GitHub")
                    .icon(new IconicsDrawable(c)
                            .icon(CommunityMaterial.Icon.cmd_github_circle)
                            .color(ContextCompat.getColor(c, colorIcon))
                            .sizeDp(18))
                    .setOnClickAction(ConvenienceBuilder.createWebsiteOnClickAction(c, Uri.parse("https://github.com/jkl1690/bitconnect-carlos-soundboard")))
                    .build());

            appCardBuilder.addItem(new MaterialAboutActionItem.Builder()
                    .text("Donate")
                    .subText("If you're feeling generous, support me and buy me a beer!")
                    .icon(new IconicsDrawable(c)
                            .icon(CommunityMaterial.Icon.cmd_beer)
                            .color(ContextCompat.getColor(c, colorIcon))
                            .sizeDp(18))
                    .setOnClickAction(() -> {
                        Intent intent = new Intent(c, DonationsActivity.class);
                        intent.putExtra(MaterialAboutActivity.THEME_EXTRA, theme);
                        c.startActivity(intent);
                    })
                    .build());

            appCardBuilder.addItem(new MaterialAboutActionItem.Builder()
                    .text("Licences")
                    .icon(new IconicsDrawable(c)
                            .icon(CommunityMaterial.Icon.cmd_book)
                            .color(ContextCompat.getColor(c, colorIcon))
                            .sizeDp(18))
                    .setOnClickAction(() -> {
                        Intent intent = new Intent(c, LicenceActivity.class);
                        intent.putExtra(MaterialAboutActivity.THEME_EXTRA, theme);
                        c.startActivity(intent);
                    })
                    .build());

            appCardBuilder.addItem(ConvenienceBuilder.createRateActionItem(c,
                    new IconicsDrawable(c)
                            .icon(CommunityMaterial.Icon.cmd_star)
                            .color(ContextCompat.getColor(c, colorIcon))
                            .sizeDp(18),
                    "Rate on Google Play",
                    null
            ));

            MaterialAboutCard.Builder authorCardBuilder = new MaterialAboutCard.Builder();
            authorCardBuilder.title("Developer");
            authorCardBuilder.addItem(new MaterialAboutActionItem.Builder()
                    .text("jkl1690")
                    .subText("United Kingdom")
                    .icon(new IconicsDrawable(c)
                            .icon(CommunityMaterial.Icon.cmd_account)
                            .color(ContextCompat.getColor(c, colorIcon))
                            .sizeDp(18))
                    .setOnClickAction(ConvenienceBuilder.createWebsiteOnClickAction(c, Uri.parse("https://github.com/jkl1690")))
                    .build());

            authorCardBuilder.addItem(ConvenienceBuilder.createWebsiteActionItem(c,
                    new IconicsDrawable(c)
                            .icon(CommunityMaterial.Icon.cmd_earth)
                            .color(ContextCompat.getColor(c, colorIcon))
                            .sizeDp(18),
                    "Visit Website",
                    true,
                    Uri.parse("http://jklaw.tech")));

            authorCardBuilder.addItem(ConvenienceBuilder.createEmailItem(c,
                    new IconicsDrawable(c)
                            .icon(CommunityMaterial.Icon.cmd_email)
                            .color(ContextCompat.getColor(c, colorIcon))
                            .sizeDp(18),
                    "Email",
                    true,
                    "jkl1690@protonmail.com",
                    "Question - Bitconnect Carlos Soundboard"));

            return new MaterialAboutList(appCardBuilder.build(), authorCardBuilder.build());
        }

        public static MaterialAboutList createMaterialAboutLicenseList(final Context c, int colorIcon) {

            MaterialAboutCard appLicenceCard = ConvenienceBuilder.createLicenseCard(c,
                    new IconicsDrawable(c)
                            .icon(CommunityMaterial.Icon.cmd_book)
                            .color(ContextCompat.getColor(c, colorIcon))
                            .sizeDp(18),
                    "Bitconnect Carlos Soundboard", "2018", "jkl1690",
                    OpenSourceLicense.GNU_GPL_3);

            MaterialAboutCard materialAboutLibraryLicenceCard = ConvenienceBuilder.createLicenseCard(c,
                    new IconicsDrawable(c)
                            .icon(CommunityMaterial.Icon.cmd_book)
                            .color(ContextCompat.getColor(c, colorIcon))
                            .sizeDp(18),
                    "material-about-library", "2016", "Daniel Stone",
                    OpenSourceLicense.APACHE_2);

            MaterialAboutCard androidIconicsLicenceCard = ConvenienceBuilder.createLicenseCard(c,
                    new IconicsDrawable(c)
                            .icon(CommunityMaterial.Icon.cmd_book)
                            .color(ContextCompat.getColor(c, colorIcon))
                            .sizeDp(18),
                    "Android Iconics", "2016", "Mike Penz",
                    OpenSourceLicense.APACHE_2);

            MaterialAboutCard androidDonationsLicenceCard = ConvenienceBuilder.createLicenseCard(c,
                    new IconicsDrawable(c)
                            .icon(CommunityMaterial.Icon.cmd_book)
                            .color(ContextCompat.getColor(c, colorIcon))
                            .sizeDp(18),
                    "Android Donations Library", "2011", "Dominik Schürmann",
                    OpenSourceLicense.APACHE_2);

            MaterialAboutCard ckChangelogLicenceCard = ConvenienceBuilder.createLicenseCard(c,
                    new IconicsDrawable(c)
                            .icon(CommunityMaterial.Icon.cmd_book)
                            .color(ContextCompat.getColor(c, colorIcon))
                            .sizeDp(18),
                    "ckChangelog", "2012", "cketti",
                    OpenSourceLicense.APACHE_2);

            return new MaterialAboutList(
                    appLicenceCard,
                    materialAboutLibraryLicenceCard,
                    androidIconicsLicenceCard,
                    androidDonationsLicenceCard,
                    ckChangelogLicenceCard);
        }
    }
