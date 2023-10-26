package com.bozhilov.shiftscheduler.schedules.config;

public enum Status {
    DAY("D","day shift", 12d),
    NGHT("N", "night shift", 12*1.134),
    OFF("O","day off", 0d),
    REG("R","regular shift", 8d),
    SICK("S","sick leave", 8d),
    EDU("E","education", 4d),
    ADM("A","administrative", 8d),
    VAC("V", "vacation", 0d);
    private Status(String symbol, String label, double hours){
        this.label = label;
        this.hours = hours;
    }
    private final String label;
    private final double hours;

    public String getLabel() {
        return label;
    }
}
