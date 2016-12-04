package com.example.simplecropviewsample;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hanekawanal on 2016/11/05.
 */

public class FunctionsSeek {

    public static String valueOfBreastMilk(int seek){
        switch (seek){
            case 0:
                return "1. ぜんぜん飲んでいない";
            case 1:
                return "2. 少し飲んだ";
            case 2:
                return "3. いつもくらい";
            case 3:
                return "4. けっこう飲んだ";
            case 4:
                return "5. ものすごく飲んだ";
            default:
                return "うんちまみれ"; // 例外処理
        }
    }

    /*  */
    public static String realTime(int x){
        Date date = new Date();
        String s = null;
        //SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分");

        switch(x){
            case 1:
                s = sdf1.format(date).toString();
            break;
            case 2:
                s = sdf2.format(date).toString();
            break;
            default:
        }
        return s;
    }

}
