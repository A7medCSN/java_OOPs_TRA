package OOP.ScientificEquationCalculator.Entities;

public class InterestData {

    private Float principle;
    private Float rate;
    private Float time;
    private PhysicsData physicsData;

    @Override
    public String toString() {
        return "InterestData{" +
                "principle=" + principle +
                ", rate=" + rate +
                ", time=" + time +
                ", physicsData=" + physicsData +
                '}';
    }

    public Float getPrinciple() {
        return principle;
    }

    public void setPrinciple(Float principle) {
        this.principle = principle;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }

    public PhysicsData getPhysicsData() {
        return physicsData;
    }

    public void setPhysicsData(PhysicsData physicsData) {
        this.physicsData = physicsData;
    }
}
