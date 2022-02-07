package hiber.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {

    @Column(name = "model")
    private String model;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int series;

    @OneToOne(mappedBy = "car")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car(String model) {
        this.model = model;
    }

    public Car() {}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    @Override
    public String toString() {
        return model;
    }
}
