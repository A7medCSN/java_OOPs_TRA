package OOP.ScientificEquationCalculator.Entities;

public class PhysicsData {

    private Float mass;
    private Float acceleration;

    private MotionData motionData;

    @Override
    public String toString() {
        return "PhysicsData{" +
                "mass=" + mass +
                ", acceleration=" + acceleration +
                ", motionData=" + motionData +
                '}';
    }

    public Float getMass() {
        return mass;
    }

    public void setMass(Float mass) {
        this.mass = mass;
    }

    public Float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Float acceleration) {
        this.acceleration = acceleration;
    }

    public MotionData getMotionData() {
        return motionData;
    }

    public void setMotionData(MotionData motionData) {
        this.motionData = motionData;
    }
}
