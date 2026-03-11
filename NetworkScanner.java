import java.awt.*;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NetworkScanner {

    private DefaultTableModel tableModel;

    public NetworkScanner() {

        JFrame frame = new JFrame("WiFi Network Scanner");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Local Network Device Scanner", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JButton scanButton = new JButton("Start Scan");

        tableModel = new DefaultTableModel();
        tableModel.addColumn("IP Address");
        tableModel.addColumn("Host Name");

        JTable table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(title, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(scanButton, BorderLayout.SOUTH);

        scanButton.addActionListener(e -> startScan());

        frame.setVisible(true);
    }

    private void startScan() {

        tableModel.setRowCount(0);

        new Thread(() -> {

            try {

                InetAddress localhost = InetAddress.getLocalHost();
                String localIP = localhost.getHostAddress();

                String network = localIP.substring(0, localIP.lastIndexOf(".") + 1);

                ExecutorService executor = Executors.newFixedThreadPool(50);

                for (int i = 1; i <= 254; i++) {

                    final String host = network + i;

                    executor.submit(() -> {

                        try {

                            InetAddress address = InetAddress.getByName(host);

                            if (address.isReachable(200)) {

                                String hostname = address.getCanonicalHostName();

                                SwingUtilities.invokeLater(() -> {
                                    tableModel.addRow(new Object[]{host, hostname});
                                });

                            }

                        } catch (Exception ignored) {
                        }

                    });
                }

                executor.shutdown();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();
    }

    public static void main(String[] args) {
        new NetworkScanner();
    }
}
