package com.example.wikispaces;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WikispacesPageCountParser {

  public int calculateWikiPages(String page) {
    Pattern pattern = Pattern.compile(".*\"totals\".[0-9]+ - [0-9]+ of ([0-9]+)</div>.*");
    Matcher matcher = pattern.matcher(page);
    matcher.find();
    String match = matcher.group(1);
    return Integer.parseInt(match);
  }

  public List<PageHitCount> parse(String page) {
    return Collections.list(new PageHitCountIterator(page));
  }

}
