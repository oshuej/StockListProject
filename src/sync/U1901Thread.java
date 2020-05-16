package sync;

public class U1901Thread extends Thread {

    private U1901Bank bankWork;
    private int intTrans;
    private long lngSleep;

    public U1901Bank getBankWork() {
        return bankWork;
    }

    public void setBankWork(U1901Bank bankWork) {
        this.bankWork = bankWork;
    }

    public int getIntTrans() {
        return intTrans;
    }

    public void setIntTrans(int intTrans) {
        this.intTrans = intTrans;
    }

    public long getLngSleep() {
        return lngSleep;
    }

    public void setLngSleep(long lngSleep) {
        this.lngSleep = lngSleep;
    }

    public U1901Thread(U1901Bank bankWork, int intTrans, long lngSleep) {
        this.bankWork = bankWork;
        this.intTrans = intTrans;
        this.lngSleep = lngSleep;
    }

    public void run() {
        this.bankWork.calc(intTrans, lngSleep);
    }
}
