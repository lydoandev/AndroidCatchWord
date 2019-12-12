package com.example.chaseimagecatchword;

public class itemQuestion {

    String img, anwser;

    public itemQuestion(String img, String anwser){
        this.img = img;
        this.anwser = anwser;
    }

    public String getImg() {
        return img;
    }

    public String getAnwser() {
        return anwser;
    }


    public void setImg(String img) {
        this.img = img;
    }

    public void setAnwser(String anwser) {
        this.anwser = anwser;
    }
}