package sync;

// lab 6 ex 6-2
public class U1901Bank {

    private int intTo;
    private int intFrom = 220;

    public int getIntTo() {
        return intTo;
    }

    public void setIntTo(int intTo) {
        this.intTo = intTo;
    }

    public int getIntFrom() {
        return intFrom;
    }

    public void setIntFrom(int intFrom) {
        this.intFrom = intFrom;
    }

    public U1901Bank(){
    }

    public synchronized void calc(int intTransaction, long lngTimeout) {
        System.out.printf("\nCurrent values BEFORE TRANSACTION \n intTo: %d \n intFrom: %d \n ThreadName: %s \n",
                this.intTo, this.intFrom, Thread.currentThread().getName());

        this.intFrom -= intTransaction;
        try {
            Thread.sleep(lngTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.intTo += intTransaction;

        System.out.printf("\nCurrent values AFTER TRANSACTION \n intTo: %d \n intFrom: %d \n ThreadName: %s \n",
                this.intTo, this.intFrom,  Thread.currentThread().getName());
    }
}
