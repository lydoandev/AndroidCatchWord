package com.example.chaseimagecatchword;

import java.util.ArrayList;

public class listQuestion {
    public ArrayList<itemQuestion> listQuestion = new ArrayList<itemQuestion>();

    public listQuestion() {

        itemQuestion item1 = new itemQuestion("@drawable/cungcau", "CUNG CAU");
        itemQuestion item2 = new itemQuestion("@drawable/bahoa", "BA HOA");
        itemQuestion item3 = new itemQuestion("@drawable/baocao", "BAO CAO");
        itemQuestion item4 = new itemQuestion("@drawable/cadao", "CA DAO");
        itemQuestion item5 = new itemQuestion("@drawable/kinhdo", "KINH DO");
        itemQuestion item6 = new itemQuestion("@drawable/hanhlang", "HANH LANG");
        itemQuestion item7 = new itemQuestion("@drawable/matma", "MAT MA");
        itemQuestion item8 = new itemQuestion("@drawable/bioi", "BI OI");
        itemQuestion item9 = new itemQuestion("@drawable/coloa", "CO LOA");
        itemQuestion item10 = new itemQuestion("@drawable/nhatbao", "NHAT BAO");
        listQuestion.add(item1);
        listQuestion.add(item2);
        listQuestion.add(item3);
        listQuestion.add(item4);
        listQuestion.add(item5);
        listQuestion.add(item6);
        listQuestion.add(item7);
        listQuestion.add(item8);
        listQuestion.add(item9);
        listQuestion.add(item10);
    }
}