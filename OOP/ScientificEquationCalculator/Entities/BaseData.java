package OOP.ScientificEquationCalculator.Entities;

import java.util.UUID;

public class BaseData {

    private UUID id;

    @Override
    public String toString() {
        return "BaseData{" +
                "id=" + id +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
