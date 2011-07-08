package com.example.wikispaces;

public class WikispacesUrlFormatter {
  public static String generateUrl(String wikiSpaceName, String date, int pageNumber) {
    if (date != null && date.length() > 0) {
      return String.format("http://%s.wikispaces.com/space/stats/page/%s?&o=%d", wikiSpaceName, date, pageNumber);
    }

    return String.format("http://%s.wikispaces.com/space/stats/page/%s%%26o%%3D40?&o=%d", wikiSpaceName, date, pageNumber);
  }
}
