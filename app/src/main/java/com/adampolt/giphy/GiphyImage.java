package com.adampolt.giphy;

import com.google.gson.annotations.SerializedName;

public class GiphyImage {
    String title;
    GiphyImageList images;

    public String getTitle() {
        return title;
    }

    public String getGifUrl() {
        return images.previewGif.url;
    }
}

class GiphyImageList {
    ImageData preview;
    ImageData original;

    @SerializedName("preview_gif")
    ImageData previewGif;
}

class ImageData {
    String url;
}
