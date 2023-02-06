package airQuality;

public class CommonResource {
    private int semaphore = 2;

    public CommonResource(int semaphore) {
        this.semaphore = semaphore;
    }

    public int getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(int semaphore) {
        this.semaphore = semaphore;
    }
}
