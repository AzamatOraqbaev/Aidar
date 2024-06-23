package com.example.diplom4;

public class ImageSoundPair {
    private int imageResourceId;
    private int soundResourceId;


    public ImageSoundPair(int imageResourceId, int soundResourceId) {
        this.imageResourceId = imageResourceId;
        this.soundResourceId = soundResourceId;

    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getSoundResourceId() {
        return soundResourceId;
    }


}
