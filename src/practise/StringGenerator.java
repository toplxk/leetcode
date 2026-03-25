package practise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class StringGenerator {
    private static final int NUM_STRINGS = 800;
    private static final String FILENAME = "string_800.txt";
    private static final String[] HEX_DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public static void main(String[] args) {
        Set<String> snSet = new HashSet<>();
        Set<String> ethMacSet = new HashSet<>();
        Set<String> didKeySet = new HashSet<>();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME));
            Random random = new Random();

            for (int i = 0; i < NUM_STRINGS; i++) {
                String sn = generateSN(snSet);
                String ethMac = generateEthMac(ethMacSet);
                String didKey = generateDidKey(didKeySet);

//                String string = "SN=" + sn + ",ETH_MAC=" + ethMac + ",DID_KEY=" + didKey;
                String string = "SN,ETH_MAC,DID_KEY;" + sn + "," + ethMac + "," + didKey;
                writer.write(string);
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateSN(Set<String> snSet) {
        String sn;
        do {
            sn = generateRandomNumber(5) + "/" + generateRandomNumber(12);
        } while (snSet.contains(sn));
        snSet.add(sn);
        return sn;
    }

    private static String generateEthMac(Set<String> ethMacSet) {
        String ethMac;
        do {
            ethMac = generateRandomHexDigit() + generateRandomHexDigit() + ":" +
                    generateRandomHexDigit() + generateRandomHexDigit() + ":" +
                    generateRandomHexDigit() + generateRandomHexDigit() + ":" +
                    generateRandomHexDigit() + generateRandomHexDigit() + ":" +
                    generateRandomHexDigit() + generateRandomHexDigit() + ":" +
                    generateRandomHexDigit() + generateRandomHexDigit();
        } while (ethMacSet.contains(ethMac));
        ethMacSet.add(ethMac);
        return ethMac;
    }

    private static String  generateDidKey(Set<String> didKeySet) {
        String didKey;
        do {
            didKey = generateRandomHexString(12) + "|" + generateRandomNumber(9) + "|" + generateRandomHexString(64);
        } while (didKeySet.contains(didKey));
        didKeySet.add(didKey);
        return didKey;
    }

    private static String generateRandomNumber(int numDigits) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < numDigits; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private static String generateRandomHexDigit() {
        Random random = new Random();
        return HEX_DIGITS[random.nextInt(16)];
    }

    private static String generateRandomHexString(int numDigits) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numDigits; i++) {
            sb.append(generateRandomHexDigit());
        }
        return sb.toString();
    }
}