package controller;

/**
 * Created by MCurtner on 3/6/2017.
 */
public class SubnetController {

    // Contstanrinary 0's: 00000000
    private static final int binaryPaddingLength = 8;

    public String calculateNetworkClass(String ipAddress) {
        int octet1 =  Integer.parseInt(parseIPAddress(ipAddress)[0]);

        if (octet1 > 0 && octet1 < 127) {
            return "A";
        } else if (octet1 > 127 && octet1 < 192) {
            return "B";
        } else if (octet1 > 191 && octet1 < 224) {
            return "C";
        } else {
            return "Error";
        }
    }

    public String calculateNetmaskFromCIDR(int CIDR){
        String str = "";

        // Add '1's' to string
        for (int i = 0; i < CIDR; i++) {
            str += "1";
        }

        // Add '0's'
        for (int i = 0; str.length() < 32; i++) {
            str += "0";
        }

        return str;
    }

    public String calculateNetworkAddress(String ipAddress, String netmaskAddress) {
        String binaryIP; //Array(convertIPToBinary(ipAddress: ipAddress).characters)
        String binaryNetmask;  //Array(convertIPToBinary(ipAddress: netmaskAddress).characters)
        String str = "";

//        for i in 0..<binaryIP.count {
//            if binaryIP[i] == "1" && binaryNetmask[i] == "1" {
//                str += "1"
//            } else {
//                str += "0"
//            }
//        }


        return str;
    }



    public String convertBinaryToFormattedIPAddress(String binaryString) {

        String octet1 = convertBinaryToBaseTenString(binaryString.substring(0, 8));
        String octet2 = convertBinaryToBaseTenString(binaryString.substring(8, 16));
        String octet3 = convertBinaryToBaseTenString(binaryString.substring(16, 24));
        String octet4 = convertBinaryToBaseTenString(binaryString.substring(24, 32));

        return octet1 + "." + octet2 + "." + octet3 + "." + octet4;
    }

    public String convertBinaryToBaseTenString(String binaryString) {
        int base = Integer.parseInt(binaryString, 2);
        return Integer.toString(base);
    }

    public String convertIPToBinaryString(String ipAddress) {
        String binaryStr = "";
        String[] parsedIP = parseIPAddress(ipAddress);

         // Loop through each String[] element and append result to binaryStr.
        for (int i = 0; i< parsedIP.length ; i++) {
            binaryStr +=  ConvertToBinaryStringWithPadding(Integer.parseInt(parsedIP[i]));
        }

        return binaryStr;
    }

    public String convertIPToFormattedHEXIPString(String ipAddress) {
        String[] ip = parseIPAddress(ipAddress);

        String octet1 = convertIPOctetToHexString(ip[0]);
        String octet2 = convertIPOctetToHexString(ip[1]);
        String octet3 = convertIPOctetToHexString(ip[2]);
        String octet4 = convertIPOctetToHexString(ip[3]);

        return octet1 + octet2 + octet3 + octet4;
    }

    public String convertIPOctetToHexString(String ipOctect) {
        return String.format("%02X", Integer.parseInt(ipOctect));
    }

    public String invertBinaryString(String binaryString) {
        String str = "";

        for (int i = 0, n = binaryString.length(); i < n; i++) {
            char c = binaryString.charAt(i);
            if (c == '1') {
                str +=  "0";
            } else {
                str += "1";
            }
        }

        return str;
    }

    public String[] parseIPAddress(String ipAddress) {
        return  ipAddress.split("\\.");
    }

    private String ConvertToBinaryStringWithPadding(int ip) {
        String padding = String.format("%0" + binaryPaddingLength + 'd', 0);
        String str = Integer.toBinaryString(ip);
        str = padding.substring(str.length()) + str;
        return str;
    }
}


