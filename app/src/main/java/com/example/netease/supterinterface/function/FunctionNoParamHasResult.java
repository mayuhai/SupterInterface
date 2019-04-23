package com.example.netease.supterinterface.function;

/**
 * 没参数有返回值的方法
 */
public abstract class FunctionNoParamHasResult<T> extends Function {
    public FunctionNoParamHasResult(String functionName) {
        super(functionName);
    }

    public abstract T function();
}
