package com.casual_games;

public interface AdsController {

    public void showInterstitialAd (Runnable then);

    public void onAdClosed();

}