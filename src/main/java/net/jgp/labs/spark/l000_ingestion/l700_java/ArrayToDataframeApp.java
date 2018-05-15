package net.jgp.labs.spark.l000_ingestion.l700_java;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * Look at https://github.com/jgperrin/net.jgp.books.sparkWithJava.ch03 for more
 * explanations.
 * 
 * @author jgp
 *
 */
public class ArrayToDataframeApp {

  public static void main(String[] args) {
    ArrayToDataframeApp app = new ArrayToDataframeApp();
    app.start();
  }

  private void start() {
    SparkSession spark = SparkSession.builder()
        .appName("Array to Dataframe (Dataset<Row>)")
        .master("local")
        .getOrCreate();

    String[] l = new String[] { "a", "b", "c", "d" };
    List<String> data = Arrays.asList(l);
    Dataset<String> ds = spark.createDataset(data, Encoders.STRING());
    Dataset<Row> df = ds.toDF();
    df.show();
  }
}
