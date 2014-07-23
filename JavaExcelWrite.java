import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import jxl.CellView;
import jxl.JXLException;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class JavaExcelWrite {

	HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

	public JavaExcelWrite(HashMap<Integer, ArrayList<String>> map) {
		this.map = map;
	}

	public void writeToFile() throws IOException, RowsExceededException,
			JXLException, WriteException {
		WritableWorkbook wworkbook = Workbook.createWorkbook(new File(
				"D:\\output.xls"));
		WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);

		Label l1 = new Label(0, 0, "Module Name");
		Label l2 = new Label(1, 0, "File Name");
		Label l3 = new Label(2, 0, "File Type");
		Label l4 = new Label(3, 0, "File Path");
		Label l5 = new Label(4, 0, "No of files scanned in same directory");
		wsheet.addCell(l1);
		wsheet.addCell(l2);
		wsheet.addCell(l3);
		wsheet.addCell(l4);
		wsheet.addCell(l5);

		int i = 2;
		for (Entry<Integer, ArrayList<String>> entry : map.entrySet()) {
			Label lbl1 = new Label(0, i, entry.getValue().get(0));
			Label lbl2 = new Label(1, i, entry.getValue().get(1));
			Label lbl3 = new Label(2, i, entry.getValue().get(2));
			Label lbl4 = new Label(3, i, entry.getValue().get(3));
			Label lbl5 = new Label(4, i, entry.getValue().get(4));
			i++;
			wsheet.addCell(lbl1);
			wsheet.addCell(lbl2);
			wsheet.addCell(lbl3);
			wsheet.addCell(lbl4);
			wsheet.addCell(lbl5);
		}
		Label label1 = new Label(0, i + 3, "Total files scanned-" + (i - 2));
		wsheet.addCell(label1);

		sheetAutoFitColumns(wsheet, 5);

		wworkbook.write();
		wworkbook.close();
	}

	private void sheetAutoFitColumns(WritableSheet sheet, int amountOfColumns) {
		int c = amountOfColumns;
		for (int x = 0; x < c; x++) {
			CellView cell = sheet.getColumnView(x);
			cell.setAutosize(true);
			sheet.setColumnView(x, cell);
		}
	}
}
