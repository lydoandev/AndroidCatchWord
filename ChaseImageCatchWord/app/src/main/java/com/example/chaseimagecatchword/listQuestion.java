package com.example.chaseimagecatchword;

import java.util.ArrayList;

public class listQuestion {
    public ArrayList<itemQuestion> listQuestion = new ArrayList<itemQuestion>();

    public listQuestion() {

        itemQuestion item = new itemQuestion("@drawable/cungcau", "CU");
        listQuestion.add(item);
    }
}
