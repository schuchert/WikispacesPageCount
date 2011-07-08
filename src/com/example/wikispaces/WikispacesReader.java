package com.example.wikispaces;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

public class WikispacesReader {
  private HttpClient httpClient;
  private WikispacesPageCountParser parser;
  private WikispacesUrlIterator urlIterator;

  public WikispacesReader(HttpClient adapter, String basePageName) {
    this.httpClient = adapter;
    this.parser = new WikispacesPageCountParser();
    buildIterator(basePageName);
  }

  private void buildIterator(String basePageName) {
    this.urlIterator = new WikispacesUrlIterator(basePageName, 1);
    WikispacesPageCountParser parser = new WikispacesPageCountParser();
    urlIterator.hasNext();
    String firstPageUrl = urlIterator.next();
    int pages = parser.calculateWikiPages(getUrl(firstPageUrl));
    urlIterator = new WikispacesUrlIterator(basePageName, pages);
  }
  
  public List<PageHitCount> readAll() {
    List<PageHitCount> result = new LinkedList<PageHitCount>();

    for (String url : urlIterator) {
      String page = getUrl(url);
      List<PageHitCount> hits = parser.parse(page);
      result.addAll(hits);
    }

    return result;
  }

  private String getUrl(String url) {
    try {
      HttpMethod method = new GetMethod(url);
      httpClient.executeMethod(method);
      String result = method.getResponseBodyAsString();
      method.releaseConnection();
      return result;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
