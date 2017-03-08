package test.controller; 

import controller.SubnetController;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/** 
* SubnetController Tester. 
* 
* @author <Authors name> 
* @since <pre>Mar 6, 2017</pre> 
* @version 1.0 
*/ 
public class SubnetControllerTest {

    SubnetController sc;
    String ipAddress = "192.168.1.1";

    @Before
    public void before() throws Exception {
        sc = new SubnetController();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: parseIPAddress(String ipAddress)
     */

    @Test
    public void calculateNetmaskFromCIDR() throws Exception {
        assertEquals("11111111111111111111111100000000", sc.calculateNetmaskFromCIDR(24));
    }

    @Test
    public void calculateNetworkClass() throws Exception {
        assertEquals("C", sc.calculateNetworkClass(ipAddress));
        assertEquals("A", sc.calculateNetworkClass("10.10.1.24"));
        assertEquals("B", sc.calculateNetworkClass("158.10.1.24"));
        assertEquals("Error", sc.calculateNetworkClass("322.10.1.24"));
    }

    @Test
    public void convertBinaryToBaseTenString() throws Exception {
        assertEquals("192", sc.convertBinaryToBaseTenString("11000000"));
        assertEquals("11", sc.convertBinaryToBaseTenString("00001011"));
    }

    @Test
    public void convertBinaryToFormattedIPAddress() throws Exception {
        assertEquals("192.168.1.1", sc.convertBinaryToFormattedIPAddress("11000000101010000000000100000001"));
        assertEquals("172.31.6.131", sc.convertBinaryToFormattedIPAddress("10101100000111110000011010000011"));
    }

    @Test
    public void convertIPToBinaryString() throws Exception {
        assertEquals("11000000101010000000000100000001", sc.convertIPToBinaryString(ipAddress));
    }

    @Test
    public void convertIPToFormattedHEXIPString() throws Exception {
       assertEquals("0A16212C", sc.convertIPToFormattedHEXIPString("10.22.33.44"));
    }

    @Test
    public void convertIPOctetToHexString() throws Exception {
        assertEquals("14", sc.convertIPOctetToHexString("20"));
        assertEquals("4F", sc.convertIPOctetToHexString("79"));
        assertEquals("0A", sc.convertIPOctetToHexString("10"));
    }

    @Test
    public void invertBinaryString() throws Exception {
        assertEquals("11111111111111111111111111111111", sc.invertBinaryString(sc.convertIPToBinaryString("0.0.0.0")));
        assertEquals("00111111010101111111111011111110", sc.invertBinaryString(sc.convertIPToBinaryString(ipAddress)));
    }

    @Test
    public void parseIPAddress() throws Exception {
        assertEquals("192", sc.parseIPAddress(ipAddress)[0]);
        assertEquals("168", sc.parseIPAddress(ipAddress)[1]);
        assertEquals("1", sc.parseIPAddress(ipAddress)[2]);
        assertEquals("1", sc.parseIPAddress(ipAddress)[3]);
    }
}
