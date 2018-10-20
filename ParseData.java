import java.io.*;
import java.io.FileReader;
import java.util.Iterator;
import java.util.ArrayList;
import java.lang.*;

import org.json.simple.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseData {

  public static void main(String [] args){
    findVoteHistory("TedCruzRawJSON.txt");
  }

  public static void findVoteHistory(String fileName){
    JSONParser parser = new JSONParser();

    try {
      Object obj = parser.parse(new FileReader(fileName));
      JSONObject allData = (JSONObject) obj;
      JSONArray results = (JSONArray) allData.get("results");

      Iterator iterator = results.iterator();
      while (iterator.hasNext()){
        JSONObject currResult = (JSONObject) iterator.next();
        JSONArray currVote = (JSONArray) currResult.get("votes");

        Iterator voteIterator = currVote.iterator();
        while (voteIterator.hasNext()){
          JSONObject thisVote = (JSONObject) voteIterator.next();
            System.out.println((String) thisVote.get("description"));
            System.out.println((String) thisVote.get("position"));
        }
      }

    } catch (Exception e) {
        e.printStackTrace();
    }

  }

}
