package tp.labs.two;

public class U0901WorkArray <T extends Number> {
    public T[] arrNums;

    public U0901WorkArray(T[] numP) {
        this.arrNums = numP;
    }


    public double sum() {
        double doubleWork = 0;
        for (T num : arrNums) {
            doubleWork += num.doubleValue();
        }
        return doubleWork;
    }
}
