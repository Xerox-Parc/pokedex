package com.xeroxparc.pokedex.data;

import android.widget.ImageView;

public class Pokemon {
    private String name;
    private ImageView image;
    private boolean prefer=false;

    public String getName() {
        return name;
    }

    public void setPrefer(){
        this.prefer=true;
    }

    public boolean getPrefer(){
        return prefer;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ImageView getImage(){
        return image;
    }

    public void setImage(ImageView image)
    {
        this.image = image;
    }

}
