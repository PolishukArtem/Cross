class Lamp implements LightSource {
    int lightPower;
    Lamp(int lightPower) {
        this.lightPower = lightPower;
    }
    public int getLightPower() { return lightPower; }
    @Override
    public void light() {
        System.out.println("Lamp on the ceiling lights with light power: " + lightPower);
    }
}
