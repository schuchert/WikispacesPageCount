package com.example.wikispaces;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.URL;

public class OnePageObjectMother {
  public static String getPage() throws Exception {
    FileInputStream fis = null;
    ObjectInputStream ois = null;

    try {
      String packageName = OnePageObjectMother.class.getPackage().getName().replaceAll("[.]", "/");
      String fileName = String.format("%s/%s", packageName, "OnePage.ser");
      URL resource = OnePageObjectMother.class.getClassLoader().getResource(fileName);
      fis = new FileInputStream(new File(resource.toURI()));
      ois = new ObjectInputStream(fis);
      return (String) ois.readObject();
    } finally {
      if (ois != null)
        ois.close();
      if (fis != null)
        fis.close();
    }
  }
}
