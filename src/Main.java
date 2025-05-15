
public class Main {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://www.example.com";


        URLFetcherThread fetcher = new URLFetcherThread(url);
        Thread thread = new Thread(fetcher);
        thread.setName("FetcherThread-1");

        thread.start();


        System.out.println("Main thread continues processing...");


        thread.join();
    }
}
