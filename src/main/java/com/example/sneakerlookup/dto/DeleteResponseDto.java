package com.example.sneakerlookup.dto;

public class DeleteResponseDto<T> {
    private T data = null;
    private int changeCount = 0;

    public DeleteResponseDto(T data, int changeCount) {
        this.data = data;
        this.changeCount = changeCount;
    }

    public DeleteResponseDto() { }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(int changeCount) {
        this.changeCount = changeCount;
    }
}
