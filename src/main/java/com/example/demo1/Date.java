package com.example.demo1;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;

public class Date {
    private ZonedDateTime time;
    private List<LocalTime> availableSlots;
    public Date(ZonedDateTime time) {
        this.time=time;
    }
    public ZonedDateTime getTime() {
        return time;
    }
    public void addSlot(LocalTime time) {
        availableSlots.add(time);
    }
    public void removeSlot(LocalTime time){
        availableSlots.remove(time);
    }
}