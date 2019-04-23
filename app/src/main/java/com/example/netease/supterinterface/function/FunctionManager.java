package com.example.netease.supterinterface.function;

import android.text.TextUtils;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法管理类 单利模式
 */
public class FunctionManager {
    private String TAG = "FunctionManager";
    private Map<String, FunctionNoParamNoResult> noParamNoResultMap;
    private Map<String, FunctionHasParamNoResult> hasParamNoResultMap;
    private Map<String, FunctionNoParamHasResult> noParamHasResultMap;
    private Map<String, FunctionHasParamAndResult> hasParamAndResultMap;

    private static FunctionManager instance;
    private FunctionManager() {
        noParamNoResultMap = new HashMap<>();
        hasParamNoResultMap = new HashMap<>();
        noParamHasResultMap = new HashMap<>();
        hasParamAndResultMap = new HashMap<>();

    }

    public static FunctionManager getInstance() {
        synchronized (FunctionManager.class) {
            if (instance == null) {
                instance = new FunctionManager();
            }
        }

        return instance;
    }

    //没有参数和没有返回值 start
    public void addFunction(FunctionNoParamNoResult functionNoParamNoResult) {
        noParamNoResultMap.put(functionNoParamNoResult.getFunctionName(), functionNoParamNoResult);
    }

    public void invokeFunction(String functionName) {
        FunctionNoParamNoResult function = noParamNoResultMap.get(functionName);
        if (function != null) {
            function.function();
        } else {
            Log.e(TAG, "未找到该方法");
        }
    }
    //没有参数和没有返回值 end


    //没有参数，但有返回值 start
    public void addFunction(FunctionNoParamHasResult functionNoParamHasResult) {
        noParamHasResultMap.put(functionNoParamHasResult.getFunctionName(), functionNoParamHasResult);
    }

    public <T> T invokeFunction(String functionName, Class<T> t) {
        FunctionNoParamHasResult functionNoParamHasResult = noParamHasResultMap.get(functionName);
        if (functionNoParamHasResult != null) {
            if (t != null) {
                return t.cast(functionNoParamHasResult.function());
            }
        } else {
            Log.e(TAG, "未找到该方法");
        }
        return null;
    }
    //没有参数，但有返回值 end

    //有参数，没有返回值 start
    public void addFunction(FunctionHasParamNoResult functionHasParamNoResult) {
        hasParamNoResultMap.put(functionHasParamNoResult.getFunctionName(), functionHasParamNoResult);
    }

    public <P> void invokeFunction(String functionName, P p) {
        if (TextUtils.isEmpty(functionName)) {
            return;
        }

        FunctionHasParamNoResult functionHasParamNoResult = hasParamNoResultMap.get(functionName);
        if (functionHasParamNoResult != null) {
            functionHasParamNoResult.function(p);
        }
    }
    //有参数，没有返回值 end

    //有参数，有返回值 start
    public void addFunction(FunctionHasParamAndResult functionHasParamAndResult) {
        hasParamAndResultMap.put(functionHasParamAndResult.getFunctionName(), functionHasParamAndResult);
    }

    public <T,P> T invokeFunction(String functionName, P p, Class<T> t) {
        if (TextUtils.isEmpty(functionName)) {
            return null;
        }

        FunctionHasParamAndResult functionHasParamAndResult = hasParamAndResultMap.get(functionName);
        if (functionHasParamAndResult != null) {
            if (t != null) {
                return t.cast(functionHasParamAndResult.function(p));
            }
        }

        return null;
    }
    //有参数，有返回值 end

}
