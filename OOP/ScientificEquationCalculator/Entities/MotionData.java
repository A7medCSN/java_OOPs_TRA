package OOP.ScientificEquationCalculator.Entities;

public class MotionData {

    private Float initialVelocity;
    private Float acceleration;
    private Float time;
    private BaseData basedata;

    @Override
    public String toString() {
        return "MotionData{" +
                "initialVelocity=" + initialVelocity +
                ", acceleration=" + acceleration +
                ", time=" + time +
                ", basedata=" + basedata +
                '}';
    }

    public Float getInitialVelocity() {
        return initialVelocity;
    }

    public void setInitialVelocity(Float initialVelocity) {
        this.initialVelocity = initialVelocity;
    }

    public Float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Float acceleration) {
        this.acceleration = acceleration;
    }

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }

    public BaseData getBaseData() {
        return basedata;
    }

    public void setBaseData(BaseData basedata) {
        this.basedata = basedata;
    }
}
