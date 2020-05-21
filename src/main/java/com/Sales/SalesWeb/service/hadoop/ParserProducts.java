package com.Sales.SalesWeb.service.hadoop;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.service.AdministrationService;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParserProducts extends Configured implements Tool {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_LL_yyyy_HH_mm_ss");
    private String productParse = String.format("hadoop_log_%s_%s", "ProductParse", LocalDateTime.now().format(formatter));

    public int run(String[] args) throws Exception {

        Job job = new Job();
        job.setJarByClass(ParserProducts.class);
        job.setJobName("ParserProducts");

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(productParse));
        job.getConfiguration().set("mapreduce.output.basename", productParse);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(Text.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        job.setMapperClass(MapClass.class);
        job.setReducerClass(ReduceClass.class);

        int returnValue = job.waitForCompletion(true) ? 0 : 1;

        if (job.isSuccessful()) {
                System.out.println("Job was successful");
        } else if (!job.isSuccessful()) {
            System.out.println("Job was not successful");
            throw new ApiException("Parsing file Error:(",
                    "Parsing Error",
                    ExceptionType.ParseError);
        }

        return returnValue;
    }
}
