import java.net.InetAddress;

public class NetworkScanner {

    public static void main(String[] args) {

        try {

            // Get local device IP
            InetAddress localHost = InetAddress.getLocalHost();
            String localIP = localHost.getHostAddress();

            System.out.println("Your IP Address: " + localIP);

            // Extract network prefix (e.g. 192.168.1.)
            String network = localIP.substring(0, localIP.lastIndexOf(".") + 1);

            System.out.println("Scanning network: " + network + "0 - " + network + "255");
            System.out.println("Devices found:\n");

            // Scan 1–254
            for (int i = 1; i < 255; i++) {

                String host = network + i;
                InetAddress address = InetAddress.getByName(host);

                if (address.isReachable(100)) {
                    System.out.println(host + " is connected (" + address.getHostName() + ")");
                }
            }

            System.out.println("\nScan completed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}