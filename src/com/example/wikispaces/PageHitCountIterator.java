package com.example.wikispaces;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageHitCountIterator implements Enumeration<PageHitCount>, Iterable<PageHitCount>, Iterator<PageHitCount> {
  Matcher pageNameMatcher;
  Matcher pageHitCountMatcher;
  boolean hitEnd;

  public PageHitCountIterator(String page) {
    Pattern pagePattern = Pattern.compile(".*<td nowrap><a href=\"/(.*)\">.*");
    pageNameMatcher = pagePattern.matcher(page);
    Pattern hitAndTotalCountPattern = Pattern.compile(".*<td>([0-9]+)</td>.*");
    pageHitCountMatcher = hitAndTotalCountPattern.matcher(page);
  }

  public Iterator<PageHitCount> iterator() {
    return this;
  }

  public boolean hasNext() {
    boolean moreNames = pageNameMatcher.find();
    boolean moreHits = pageHitCountMatcher.find();
    return moreNames && moreHits;
  }

  public PageHitCount next() {
    String name = pageNameMatcher.group(1);
    String pageCount = pageHitCountMatcher.group(1);
    return new PageHitCount(name, Integer.parseInt(pageCount));
  }

  public void remove() {
    throw new UnsupportedOperationException();
  }

  public boolean hasMoreElements() {
    return hasNext();
  }

  public PageHitCount nextElement() {
    return next();
  }

}
