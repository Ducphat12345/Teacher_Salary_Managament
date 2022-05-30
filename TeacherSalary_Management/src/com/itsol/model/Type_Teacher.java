package com.itsol.model;

public enum Type_Teacher {
    Prof_Dr("GS-TS"), Associate_Professor_PhD("PGS-TS"), Lecturer("Giảng Viên"), Masters("Thạc Sĩ");

    private String type_Teacher;

    private Type_Teacher(String type_Teacher){
        this.type_Teacher = type_Teacher;
    }

    public String getType_Teacher() {
        return type_Teacher;
    }
}
