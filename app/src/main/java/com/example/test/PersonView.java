package com.example.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class PersonView extends TextView {

    public PersonView(Context context){
        super(context);
    }

    public PersonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray tArray = context.obtainStyledAttributes(attrs,R.styleable.PersonAtr);
        String name = tArray.getString(R.styleable.PersonAtr_name);

        int age = tArray.getInt(R.styleable.PersonAtr_age,15);


        Boolean adult = tArray.getBoolean(R.styleable.PersonAtr_adult,false);
        String str_adult = getAdultStatus(adult);


        int weight = tArray.getInt(R.styleable.PersonAtr_weight,1);

        String str_weight = getWeightStatus(weight);
        @SuppressLint("ResourceAsColor") float textSize = tArray.getDimension(R.styleable.PersonAtr_textSize,R.dimen.default_text_size);

        tArray.recycle();
        setTextSize(textSize);

        setText("姓名：" + name + "\n" + "年龄：" + age + "\n" + "是否成年：" + str_adult
        + "\n" + "体型：" + str_weight);

    }

    public PersonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public String getAdultStatus(Boolean adult){
        String result;

        if(adult){
            result = "成年";
        }else{
            result = "未成年";
        }
        return result;
    }


    public String getWeightStatus(int weight){
        String str_weight = "中等";

        switch (weight){
            case 0:
                str_weight = "瘦";
                break;
            case 1:
                str_weight = "中等";
                break;
            case 2:
                str_weight = "肥胖";
                break;
            default:
                break;
        }


        return str_weight;
    }




}
