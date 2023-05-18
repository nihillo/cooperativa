package view;

import java.util.ArrayList;

public class Table {
	ArrayList<String> header;
	ArrayList<ArrayList<String>> lines;
	ArrayList<Integer> columnWidths;
	
	
	public Table(ArrayList<String> header, ArrayList<ArrayList<String>> lines, ArrayList<Integer> widths) {
		this.header = header;
		this.lines = lines;
		this.columnWidths = widths;
	}


	public void render() {
		String format = "";
		
		for (int i = 0; i < this.columnWidths.size(); i++) {
			int width = this.columnWidths.get(i);
			format += "%-" + Integer.toString(width) + "s ";
			
			if (i != this.columnWidths.size() - 1) {
				format += " | ";
			} else {
				format += "%n";
			}
		}
		
		System.out.format(format, this.header.toArray());		
		for (ArrayList<String> line : this.lines) {
			System.out.format(format, line.toArray());
		}
	}
	
}
