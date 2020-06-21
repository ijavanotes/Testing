package com.example.travelsearch.service;

public interface IService<T,R> {
    public R execute(T request);
}
