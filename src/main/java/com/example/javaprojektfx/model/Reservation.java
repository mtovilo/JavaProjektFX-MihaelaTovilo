package com.example.javaprojektfx.model;

public class Reservation extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type = "DATETIME", isnull = false)
    String date;

    @Entity(type = "VARCHAR", size = 50, isnull = false)
    String occasion;

    @ForeignKey(table = "User", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int user_id;

    @ForeignKey(table = "Bench", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int bench_id;

    @ForeignKey(table = "Appointment", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int appointment_id;

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBench_id() {
        return bench_id;
    }

    public void setBench_id(int bench_id) {
        this.bench_id = bench_id;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }
}
