package iu.edu.c322.trackingservice.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Tracker {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    @OneToMany(mappedBy = "tracker", cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Item getItemById(int id) {
        return items.get(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tracker tracker = (Tracker) o;
        return id == tracker.id && Objects.equals(items, tracker.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, items);
    }
}

