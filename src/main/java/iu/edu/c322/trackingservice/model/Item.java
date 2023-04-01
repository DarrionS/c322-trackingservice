package iu.edu.c322.trackingservice.model;

import jakarta.persistence.*;

@Entity
public class Item {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    @ManyToOne
    private Tracker tracker;

    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Tracker getTracker() {
        return tracker;
    }
}
