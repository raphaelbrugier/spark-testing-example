package com.ipponusa

import org.apache.spark.rdd.RDD

object WordCounter {
  def count(lines: RDD[String]): RDD[(String, Int)] = {
    val wordsCount = lines.flatMap(l => l.split("\\W+"))
      .map(word => word.trim())
      .map(word => (word, 1))
      .reduceByKey(_ + _)
    wordsCount
  }
}
