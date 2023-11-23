package services;

import ultis.DBContext;
import java.sql.*;
import java.text.DateFormatSymbols;
import java.util.LinkedHashMap;
import java.util.Map;

public class HoaDonServiceV2 extends DBContext {

    public Map<String, Integer> getRevenueByMonth() {
        Map<String, Integer> revenueByMonth = new LinkedHashMap<>();

        try {
            String query = "SELECT MONTH(NgayMua) AS Month, SUM(TongTien) AS Revenue FROM dbo.HoaDon GROUP BY MONTH(NgayMua)";
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int month = rs.getInt("Month");
                int revenue = rs.getInt("Revenue");
                String monthName = new DateFormatSymbols().getMonths()[month - 1];
                revenueByMonth.put(monthName, revenue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return revenueByMonth;
    }

    public int thongKeByNgay() {
        int soLuongDon = 0;
        try {
            String sql = """
                         SELECT COUNT(*) AS SoLuongDon
                         FROM dbo.HoaDon
                         WHERE CAST(NgayMua AS DATE) = CAST(GETDATE() AS DATE)""";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                soLuongDon = rs.getInt("SoLuongDon");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soLuongDon;
    }

    public int thongKeByThang() {
        int soLuongDon = 0;
        try {
            String sql = """
                         SELECT COUNT(*) AS SoLuongDon
                         FROM dbo.HoaDon
                         WHERE MONTH(NgayMua) = MONTH(GETDATE()) AND YEAR(NgayMua) = YEAR(GETDATE())""";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                soLuongDon = rs.getInt("SoLuongDon");
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soLuongDon;
    }

    public double thongKeDoanhThuByNgay() {
        double doanhThu = 0;
        try {
            String sql = """
                         SELECT SUM(TongTien) AS DoanhThu
                         FROM dbo.HoaDon
                         WHERE CAST(NgayMua AS DATE) = CAST(GETDATE() AS DATE)""";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                doanhThu = rs.getDouble("DoanhThu");
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doanhThu;
    }

    public double thongKeDoanhThuByThang() {
        double doanhThu = 0;
        try {
            String sql = """
                         SELECT SUM(TongTien) AS DoanhThu
                         FROM dbo.HoaDon
                         WHERE MONTH(NgayMua) = MONTH(GETDATE()) AND YEAR(NgayMua) = YEAR(GETDATE())""";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                doanhThu = rs.getDouble("DoanhThu");
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doanhThu;
    }

    public double thongKeDoanhThuByNam() {
        double doanhThu = 0;

        try {
            String sql = """
                         SELECT SUM(TongTien) AS DoanhThu
                         FROM dbo.HoaDon
                         WHERE YEAR(NgayMua) = YEAR(GETDATE())""";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                doanhThu = rs.getDouble("DoanhThu");
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doanhThu;
    }

    public int thongKeByNam() {
        int soLuongDon = 0;
        try {
            String sql = """
                         SELECT COUNT(*) AS SoLuongDon
                         FROM dbo.HoaDon
                         WHERE YEAR(NgayMua) = YEAR(GETDATE())""";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                soLuongDon = rs.getInt("SoLuongDon");
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soLuongDon;
    }

}
