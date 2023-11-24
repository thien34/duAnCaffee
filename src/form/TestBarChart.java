
package form;

import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import services.HoaDonServiceV2;

public class TestBarChart {

    private final HoaDonServiceV2 hoaDonServiceV2 = new HoaDonServiceV2();

    public static JFreeChart createChart() {
        TestBarChart testBarChart = new TestBarChart();
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ THỐNG KÊ DOANH THU SẢN PHẨM Trong Năm 2023",
                "Tháng", "Số Tiền",
                testBarChart.createDataset(), PlotOrientation.VERTICAL, false, false, false);
      
        return barChart;
    }

    private CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String, Integer> revenueByMonth = hoaDonServiceV2.getRevenueByMonth();
        for (Map.Entry<String, Integer> entry : revenueByMonth.entrySet()) {
            String month = entry.getKey();
            Double revenue = entry.getValue().doubleValue();
            dataset.addValue(revenue, "Doanh thu", month);
        }
        return dataset;
    }

   

    

}
