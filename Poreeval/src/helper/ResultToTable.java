package helper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultToTable {

	public String convert(ResultSet rs) {
		String table = "<table>";
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int col = rsmd.getColumnCount();
			table += "<tr>";
			for (int i = 1; i != col; i++) {
				table += "<th>" + rsmd.getColumnName(i) + "</th>";
			}
			table += "<tr>";
			do {
				table += "<tr>";
				for (int i = 1; i != col; i++) {
					table += "<td>" + rs.getString(i) + "</td>";
				}
				table += "</tr>";
			} while (rs.next());
		} catch (SQLException e) {
			table = "Keine Ergebnisse";
		}
		return table;
	}
}