package test.java.com.bankapp.controller;

import java.io.IOException;

import org.junit.Test;

import managers.CSVManager;

public class CSVManagerTest {
    
    @Test
    public void UpdateCSVFileTest() throws IOException {
        String lineToUpdateTest = "3, Vaas, Far, 123456-123456, 65f644d5dfd77654334d5f677df76554, vaas@gmail.com, VaasFC, 1234567, 1234566, 0";
        String updatedLineTest = "3, Vaas, Far, 123456-123456, 65f644d5dfd77654334d5f677df76554, vaas@gmail.com, VaasFC, 1234567, 1234566, 20";

        CSVManager.UpdateCSVFile(lineToUpdateTest, updatedLineTest);    // it works!!!
    }

}
