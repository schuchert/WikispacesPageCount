package com.example.wikispaces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PageHitCountIteratorTest extends LoggerInitialization {
  private static String onePage;
  private PageHitCountIterator iter;

  @BeforeClass
  public static void initOnePage() throws Exception {
    onePage = OnePageObjectMother.getPage();
  }

  @Before
  public void initIterator() {
    iter = new PageHitCountIterator(onePage);
  }

  @Test
  public void initiallyHasMoreElements() throws Exception {
    assertTrue(iter.hasMoreElements());
  }

  @Test
  public void has20Rows() {
    int count = 0;
    while (iter.hasMoreElements()) {
      ++count;
      iter.next();
    }
    assertEquals(20, count);
  }
  
  @Test
  public void firstRowPageCountCorrect() {
    iter.hasNext();
    PageHitCount row = iter.next();
    assertEquals(9, row.pageHitCount);
  }
  
  @Test
  public void firstRowNameCorrect() {
    iter.hasNext();
    PageHitCount row = iter.next();
    assertEquals("2daycpptddresources", row.pageName);
  }
}