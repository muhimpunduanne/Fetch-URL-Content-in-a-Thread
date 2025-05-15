import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLFetcherThread implements Runnable {
    private final String urlString;

    public URLFetcherThread(String urlString) {
        this.urlString = urlString;
    }

    @Override
    public void run() {
        try {

            URL url = new URL(urlString);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Thread [" + Thread.currentThread().getName() + "]: " + line);
                }
            }
        } catch (MalformedURLException e) {
            System.err.println("Thread [" + Thread.currentThread().getName() + "]: Invalid URL - " + urlString);
        } catch (IOException e) {
            System.err.println("Thread [" + Thread.currentThread().getName() + "]: Error fetching data!");
        }
    }
}
