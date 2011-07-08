package com.example.wikispaces;

public class PageHitCount {
  public final String pageName;
  public final int pageHitCount;

  public PageHitCount(String pageName, int pageHitCount) {
    this.pageName = pageName;
    this.pageHitCount = pageHitCount;
  }

  public String toString() {
    return String.format("PageHitCount{%s, %d}", pageName, pageHitCount);
  }
}
