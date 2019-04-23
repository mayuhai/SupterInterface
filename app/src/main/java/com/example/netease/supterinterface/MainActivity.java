package com.example.netease.supterinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.netease.supterinterface.function.FunctionHasParamAndResult;
import com.example.netease.supterinterface.function.FunctionHasParamNoResult;
import com.example.netease.supterinterface.function.FunctionManager;
import com.example.netease.supterinterface.function.FunctionNoParamHasResult;
import com.example.netease.supterinterface.function.FunctionNoParamNoResult;
import com.example.netease.supterinterface.model.Person;

/**
 * 从架构的角度看接口，万能接口的实现原理
 */
public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        FunctionManager.getInstance().addFunction(new FunctionNoParamNoResult("main_functionNoParamNoResult") {
            @Override
            public void function() {
                Toast.makeText(MainActivity.this, "Main函数的 FunctionNoParamNoResult", Toast.LENGTH_LONG).show();
            }
        });

        FunctionManager.getInstance().addFunction(new FunctionNoParamHasResult<Person>("main_FunctionNoParamHasResult") {
            @Override
            public Person function() {
                return new Person("小马", 18);
            }
        });

        FunctionManager.getInstance().addFunction(new FunctionHasParamNoResult<String>("main_FunctionHasParamNoResult") {
            @Override
            public void function(String param) {
                Log.e(param, param);
            }
        });

        FunctionManager.getInstance().addFunction(new FunctionHasParamAndResult<Person, String>("main_FunctionHasParamAndResult") {
            @Override
            public Person function(String o) {
                return new Person("小马" + o, 18);
            }
        });
    }
}
