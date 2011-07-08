package com.example.wikispaces;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WikispacesPageCountParserTest extends LoggerInitialization {
  static String onePage;
  private WikispacesPageCountParser parser;

  @BeforeClass
  public static void readOnePage() throws Exception {
    onePage = OnePageObjectMother.getPage();
  }

  @Before
  public void initParser() {
    parser = new WikispacesPageCountParser();
  }

  @Test
  public void findsTotalCountCorrectly() throws Exception {
    int count = parser.calculateWikiPages(onePage);
    assertEquals(635, count);
  }

  @Test
  public void readsCorrectNumberOfLinesFromSinglePage() {
    List<PageHitCount> lines = parser.parse(onePage);
    assertEquals(20, lines.size());
  }
}
