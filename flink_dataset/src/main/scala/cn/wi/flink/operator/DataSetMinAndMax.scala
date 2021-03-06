package cn.wi.flink.operator

import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.api.scala._

import scala.collection.mutable

/**
 * @ProjectName: Flink_Parent 
 * @ClassName: DataSetMinAndMax
 * @Author: xianlawei
 * @Description:
 * @date: 2019/9/1 17:48
 */
object DataSetMinAndMax {
  def main(args: Array[String]): Unit = {
    val environment: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment

    val dataML: mutable.MutableList[(Int, String, Double)] = new mutable.MutableList[(Int, String, Double)]

    dataML.+=((1, "Chinese", 90.0))
    dataML.+=((2, "Math", 20.0))
    dataML.+=((3, "English", 30.0))
    dataML.+=((4, "Physical", 40.0))
    dataML.+=((5, "Chinese", 50.0))
    dataML.+=((6, "Physical", 60.0))
    dataML.+=((7, "Chinese", 70.0))

    val dataDS: DataSet[(Int, String, Double)] = environment.fromCollection(dataML)

    val minDS: DataSet[(Int, String, Double)] = dataDS
      .groupBy(1)
      //打印每组中分数的最大值
      .minBy(2)

    minDS.print()

    val maxDS: DataSet[(Int, String, Double)] = dataDS
      .groupBy(1)
      //打印每组中分数的最大值
      .maxBy(2)

    maxDS.print()
  }
}
