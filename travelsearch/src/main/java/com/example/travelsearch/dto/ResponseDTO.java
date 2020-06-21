package com.example.travelsearch.dto;

public class ResponseDTO<T> {
    private Integer resultCount;
    private T result;

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public ResponseDTO(Integer resultCount, T result) {
        this.resultCount = resultCount;
        this.result = result;
    }

    public ResponseDTO() {
    }
}
