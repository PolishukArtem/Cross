public class Main {

    public static void main(String[] args) {
        LightSource ceilingLamp = new Lamp(50);
        LightSource tableLamp = new TableLamp(30, "Face of a criminal");

        ceilingLamp.light();
        tableLamp.light();
    }
}
