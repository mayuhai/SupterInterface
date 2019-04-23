package com.example.netease.supterinterface.function;

/**
 * 没有参数和没有返回值的方法
 */
public abstract class FunctionNoParamNoResult extends Function {
    public FunctionNoParamNoResult(String functionName) {
        super(functionName);
    }

    public abstract void function();
}
