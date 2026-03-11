# Network Scanner (Java)

## Description

This project is a **simple network scanner written in Java** that scans the local network to detect active devices.
The program retrieves the local machine’s IP address, determines the network range, and checks which devices are reachable within that network.

It helps demonstrate **basic networking concepts in Java**, such as IP addressing and host reachability.

---

## Features

* Detects the **local device IP address**
* Automatically determines the **network prefix**
* Scans all IP addresses in the local network range (1–254)
* Identifies **active devices connected to the network**
* Displays the **IP address and hostname** of reachable devices

---

## Technologies Used

* Java
* Java Networking Library (`java.net.InetAddress`)

---

## How the Program Works

1. The program retrieves the local machine's IP address.
2. It extracts the **network prefix** (for example `192.168.1.`).
3. It scans all IP addresses from **1 to 254** in that network.
4. For each IP address, it checks if the host is reachable.
5. If a device responds, the program prints the **IP address and hostname**.

---

## How to Run the Program

### 1. Save the file

Save the code as:

NetworkScanner.java

### 2. Compile the program

```bash
javac NetworkScanner.java
```

### 3. Run the program

```bash
java NetworkScanner
```

---

## Example Output

```
Your IP Address: 192.168.1.5
Scanning network: 192.168.1.0 - 192.168.1.255

Devices found:

192.168.1.1 is connected (router)
192.168.1.10 is connected (laptop)

Scan completed.
```

---

## Limitations

* The scanner only checks devices in the **local network range**.
* Some devices may not respond to ping requests and may not appear in the results.
* The scan speed depends on the **network response time**.

---

## Educational Purpose

This project is intended for **learning networking and Java programming concepts**, including:

* IP addressing
* Host discovery
* Network scanning basics

---

## Author

KOWNY

---

## License

This project is for **educational and learning purposes only**.
