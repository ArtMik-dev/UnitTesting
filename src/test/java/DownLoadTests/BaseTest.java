package DownLoadTests;

import java.io.File;

public class BaseTest {


    public void createNewFolder(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
}
