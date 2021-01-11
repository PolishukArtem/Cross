public class TableLamp extends Lamp {
    private String direction;
    TableLamp(int lightPower, String direction) {
        super(lightPower);
        this.direction = direction;
    }
    @Override
    public void light() {
        System.out.println("Table lamp pointed on " + direction + " with light power: " + lightPower);
    }
}
