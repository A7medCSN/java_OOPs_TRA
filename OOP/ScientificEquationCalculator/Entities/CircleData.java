package OOP.ScientificEquationCalculator.Entities;

public class CircleData {

    private Float radius;
    private BaseData baseData;

    @Override
    public String toString() {
        return "CircleData{" +
                "radius=" + radius +
                ", baseData=" + baseData +
                '}';
    }

    public Float getRadius() {
        return radius;
    }

    public void setRadius(Float radius) {
        this.radius = radius;
    }

    public BaseData getBaseData() {
        return baseData;
    }

    public void setBaseData(BaseData baseData) {
        this.baseData = baseData;
    }
}
