package com.bobbingboy.springbootdemo.form;

public interface FormConvert<S, T> {
    T convert(S s);
}
