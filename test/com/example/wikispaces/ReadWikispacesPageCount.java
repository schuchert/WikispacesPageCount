package com.example.wikispaces;

import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReadWikispacesPageCount extends LoggerInitialization {
  private static List<PageHitCount> result;

  @BeforeClass
  public static void readEntireSite() {
    WikispacesReader reader = new WikispacesReader(new HttpClient(), "schuchert");
    result = reader.readAll();
  }

  @Test
  public void countIsBigEnough() {
    assertTrue(result.size() > 600);
  }

  @Test
  public void canSortResults() {
    Collections.sort(result, new Comparator<PageHitCount>() {

      @Override
      public int compare(PageHitCount lhs, PageHitCount rhs) {
        return rhs.pageHitCount - lhs.pageHitCount;
      }
    });

    assertTrue(result.get(0).pageHitCount >= result.get(result.size() - 1).pageHitCount);
  }
}
