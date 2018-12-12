package com.casual_games;

import android.os.Bundle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.casual_games.FingerGun;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class AndroidLauncher extends AndroidApplication implements AdsController{

	private static final String INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-4067772952315996/9923662728";
	InterstitialAd interstitialAd;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		setupAds();

		config.numSamples = 4;
		initialize(new FingerGun(this), config);
	}

	public void setupAds(){
		MobileAds.initialize(this,
				"ca-app-pub-4067772952315996~6200626867");

		interstitialAd = new InterstitialAd(this);
		//real below
		//		interstitialAd.setAdUnitId(INTERSTITIAL_AD_UNIT_ID);

		//fake test ad unit id below
		interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

		AdRequest.Builder builder = new AdRequest.Builder();
		AdRequest ad = builder.build();
		interstitialAd.loadAd(ad);
	}

	@Override
	public void showInterstitialAd(final Runnable then) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
//				if (then != null) {
				interstitialAd.setAdListener(new AdListener() {
					@Override
					public void onAdClosed() {
						Gdx.app.postRunnable(then);
						AdRequest.Builder builder = new AdRequest.Builder();
						AdRequest ad = builder.build();
						interstitialAd.loadAd(ad);
					}
				});
//				}
				interstitialAd.show();
			}
		});
	}

	@Override
	public void onAdClosed() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				AdRequest.Builder builder = new AdRequest.Builder();
				AdRequest ad = builder.build();
				interstitialAd.loadAd(ad);
			}
		});
	}
}
