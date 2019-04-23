package com.example.netease.supterinterface.function;

/**
 * 有参数和返回值的方法
 */
public abstract class FunctionHasParamAndResult<T, P> extends Function {
    public FunctionHasParamAndResult(String functionName) {
        super(functionName);
    }

    public abstract T function(P p);
}
