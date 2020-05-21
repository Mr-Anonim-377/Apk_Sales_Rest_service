package com.Sales.SalesWeb.service.hadoop;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.model.Product;
import com.Sales.SalesWeb.service.hadoop.db.DbManager;
import com.Sales.SalesWeb.service.hadoop.db.EntityStatement;
import org.apache.commons.text.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.UUID;


public class ReduceClass extends Reducer<IntWritable, Text, Text, Text> {


    @Override
    protected void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        DbManager dbManager = new DbManager();
        Iterator<Text> iterator = values.iterator();
        UUID productId = UUID.randomUUID();
        final String inputValue = iterator.next().toString();
        StringTokenizer st = new StringTokenizer(inputValue, ",");
        if (!st.hasNext()) {
            throw new ApiException("File validte erro:(",
                    "Parsing Error",
                    ExceptionType.ParseError);
        }
        final String loggingProduct = String.format("{product:{productId:%s,productName:%s}}",productId,st.next());
        try {
            EntityStatement statement = dbManager.getStatement();
            statement.setWork(true);
            st.reset(inputValue);
            String sqlQuery = String.format("INSERT INTO public.products (product_id, " +
                            "name_product, " +
                            "category_id, " +
                            "price, " +
                            "image_id, " +
                            "collection_id, " +
                            "properties, " +
                            "product_description) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s')",
                    productId, st.next(), st.next(), st.next(), st.next(), st.next(), st.next(), st.next());
            statement.getStatement().executeUpdate(sqlQuery);
            context.write(new Text(loggingProduct), new Text("Create Successful"));
        } catch (RuntimeException | SQLException e) {
            context.write(new Text(loggingProduct), new Text("Create No successful"));
            throw new ApiException("Parsing file Error:(",
                    "Parsing Error",
                    ExceptionType.ParseError);
        }
    }

}

