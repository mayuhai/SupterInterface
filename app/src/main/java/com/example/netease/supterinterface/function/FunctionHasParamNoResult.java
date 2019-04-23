package com.example.netease.supterinterface.function;

/**
 * 有参数和没有返回值的方法
 */
public abstract class FunctionHasParamNoResult<P> extends Function {
    public FunctionHasParamNoResult(String functionName) {
        super(functionName);
    }

    public abstract void function(P param);
}
