package com.example.wikispaces;

import java.util.Iterator;

public class WikispacesUrlIterator implements Iterator<String>, Iterable<String> {
  String spaceName;
  String date = "";
  Integer totalPages;
  int currentPage;

  public WikispacesUrlIterator(String spaceName, int pageCount) {
    this.spaceName = spaceName;
    this.totalPages = pageCount;
  }

  public WikispacesUrlIterator(String spaceName, int pageCount, String year) {
    this(spaceName, pageCount);
    this.date = year;
  }

  public boolean hasNext() {
    return currentPage < totalPages;
  }

  public String next() {
    if (hasNext()) {
      String result = WikispacesUrlFormatter.generateUrl(spaceName, date, currentPage);
      currentPage += 20;
      return result;
    }
    return null;
  }

  public void remove() {
    throw new UnsupportedOperationException();
  }

  public Iterator<String> iterator() {
    return this;
  }

}
