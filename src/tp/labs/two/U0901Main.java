package tp.labs.two;

public class U0901Main {
    public static void main(String[] args) {
        Integer[] intArr = {10, 20, 15};
        Float[] floatArr = new Float[5];

        defineFloatArray(floatArr);

        U0901WorkArray<Integer> insWorkArrayInt = new U0901WorkArray<>(intArr);
        U0901WorkArray<Float> insWorkArrayFloat = new U0901WorkArray<>(floatArr);

        System.out.println(insWorkArrayInt.sum());
        System.out.println(insWorkArrayFloat.sum());
    }

    public static void defineFloatArray(Float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) Math.random();
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
