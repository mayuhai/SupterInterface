package com.example.netease.supterinterface;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.netease.supterinterface.function.FunctionHasParamNoResult;
import com.example.netease.supterinterface.function.FunctionManager;
import com.example.netease.supterinterface.model.Person;

public class SecondActivity extends AppCompatActivity {
    private String TAG = "SecondActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        FunctionManager.getInstance().invokeFunction( "main_functionNoParamNoResult");

//        Person person = FunctionManager.getInstance().invokeFunction("main_FunctionNoParamHasResult", Person.class);
//        if (person !=null) {
//            Log.e(TAG, person.toString());
//        }

        FunctionManager.getInstance().invokeFunction("main_FunctionHasParamNoResult", "test");

//        Person temPerson = FunctionManager.getInstance().invokeFunction("main_FunctionHasParamAndResult", "test", Person.class);
//        if (temPerson !=null) {
//            Log.e(TAG, temPerson.toString());
//        }
    }
}
