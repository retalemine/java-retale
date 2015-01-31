package in.retalemine.itext;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Anchor;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Header;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.html.HtmlTags;
import com.lowagie.text.html.HtmlWriter;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.DottedLineSeparator;
import com.lowagie.text.pdf.draw.LineSeparator;

public class TryItext {

	Font fontCourier = new Font(Font.COURIER, 10f, Font.NORMAL);
	Font fontTimesRoman = new Font(Font.TIMES_ROMAN, 10f, Font.NORMAL);

	public TryItext(int html) {
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		try {
			HtmlWriter.getInstance(document, new FileOutputStream(
					"trypdftext.html"));

			document.addTitle("Hello World example");

			StringBuffer s = new StringBuffer();
			s.append("\t\tfunction load() {\n");
			s.append("\t\t  alert('Page has been loaded.');\n");
			s.append("\t\t}\n");
			s.append("\t\tfunction show(){\n");
			s.append("\t\t  alert('This is javascript');\n");
			s.append("\t\t}");

			document.add(new Header(HtmlTags.JAVASCRIPT, s.toString()));

			document.setJavaScript_onLoad("load()");
			document.open();
			document.add(new Paragraph("Hello World"));

			Anchor a = new Anchor("Click");
			a.setReference("javascript:show()");
			document.add(a);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			if (document != null) {
				document.close();
			}
		}
	}

	public TryItext() {
		Document document = null;
		Rectangle billPage = null;
		try {
			billPage = new Rectangle(300f, 400f);
			document = new Document(billPage, 10f, 10f, 20f, 20f);
			PdfWriter.getInstance(document,
					new FileOutputStream("tryitext.pdf"));
			document.addTitle("Invoice");
			document.addSubject("testing");
			document.addAuthor("Retalemine");
			document.addKeywords("invoice");
			document.addProducer();
			document.addCreator("Retalemine");
			document.addCreationDate();
			document.addHeader("retakey", "retavalue");
			document.setHeader(new HeaderFooter(new Phrase("Page"), true));
			document.setFooter(new HeaderFooter(new Phrase("("),
					new Phrase(")")));
			document.open();
			Font fontCourier = new Font(Font.COURIER, 10f, Font.NORMAL);
			Font fontTimesRoman = new Font(Font.TIMES_ROMAN, 10f, Font.NORMAL);

			Paragraph title = new Paragraph("Retalemine Billing Solutions\n",
					fontTimesRoman);
			title.add(new Phrase("mail: mail@mail.com"));
			title.setAlignment(Element.ALIGN_CENTER);
			title.setSpacingBefore(0f);
			title.setSpacingAfter(5f);
			document.add(title);

			PdfPTable tableHeader = new PdfPTable(3);
			tableHeader.setWidthPercentage(100f);
			tableHeader.setWidths(new int[] { 1, 2, 1 });

			tableHeader.addCell(dottedDividedCell());
			tableHeader.addCell(columnValue("Bill No:"));
			tableHeader.addCell(columnValue("ABCDEF12345"));
			tableHeader.addCell(columnValue("Time:", Element.ALIGN_RIGHT));

			tableHeader.addCell(columnValue("Date:"));
			tableHeader.addCell(columnValue("25/12/14"));
			tableHeader.addCell(columnValue("01:15 PM", Element.ALIGN_RIGHT));

			document.add(tableHeader);

			PdfPTable table = new PdfPTable(3);
			table.setWidthPercentage(100f);
			table.setWidths(new float[] { 2.5f, 8.5f, 3 });

			table.addCell(dottedDividedCell());
			table.addCell(columnValue("Qty"));
			table.addCell(columnValue("Product Name"));
			table.addCell(columnValue("Amount", Element.ALIGN_RIGHT));
			table.addCell(dottedDividedCell());
			for (int i = 0; i < 5; i++) {
				table.addCell(columnValue((i + 1) + "kg"));
				table.addCell(columnValue("Sugar"));
				table.addCell(columnValue(((i + 1) * 45) + "",
						Element.ALIGN_RIGHT));
			}
			table.addCell(dottedDividedCell());

			document.add(table);

			PdfPTable tableFooter = new PdfPTable(2);
			tableFooter.setWidthPercentage(60f);
			tableFooter.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableFooter.setWidths(new float[] { 1.5f, 1 });

			tableFooter.addCell(columnValue("Sub Total:"));
			tableFooter.addCell(columnValue("1000.00", Element.ALIGN_RIGHT));

			for (int i = 0; i < 1; i++) {
				tableFooter.addCell(columnValue("VAT 2%:"));
				tableFooter.addCell(columnValue("20.00", Element.ALIGN_RIGHT));
			}

			tableFooter.addCell(dottedDividedCell(35f));
			tableFooter.addCell(columnValue("Grand Total:(rounded)"));
			tableFooter.addCell(columnValue("1020.00", Element.ALIGN_RIGHT));
			tableFooter.addCell(dottedDividedCell(35f));

			document.add(tableFooter);

			Paragraph thank = new Paragraph("Thank You, Visit Again!",
					fontTimesRoman);
			thank.setAlignment(Element.ALIGN_CENTER);
			document.add(thank);

			document.newPage();
			for (int i = 0; i < 10; i++) {
				if (i % 2 == 0) {
					document.add(new Paragraph("Sentence line " + (i + 1),
							fontTimesRoman));
					document.add(new DottedLineSeparator());
				} else {
					document.add(new Paragraph("Sentence line " + (i + 1),
							fontCourier));
					document.add(new LineSeparator(0.5f, 80f, null,
							LineSeparator.ALIGN_CENTER, -2f));
				}
				if (i == 4) {
					document.setPageSize(new Rectangle(300f, 500f));
					document.newPage();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (document != null) {
				document.close();
			}
		}
	}

	private PdfPCell columnValue(String value) {
		PdfPCell cell = new PdfPCell();
		cell.setBorder(Rectangle.NO_BORDER);
		cell.addElement(new Phrase(value, fontTimesRoman));
		cell.setPaddingTop(0f);
		cell.setPaddingBottom(0f);
		return cell;
	}

	private PdfPCell columnValue(String value, int alignRight) {
		PdfPCell cell = new PdfPCell();
		cell.setBorder(Rectangle.NO_BORDER);
		Paragraph content = new Paragraph(value, fontTimesRoman);
		content.setAlignment(alignRight);
		cell.addElement(content);
		return cell;
	}

	private PdfPCell dottedDividedCell() {
		PdfPCell dottedDivider = new PdfPCell();
		dottedDivider.setBorder(Rectangle.NO_BORDER);
		dottedDivider.addElement(new DottedLineSeparator());
		dottedDivider.setColspan(3);
		dottedDivider.setPaddingBottom(0f);
		dottedDivider.setPaddingLeft(0f);
		dottedDivider.setPaddingRight(0f);
		return dottedDivider;
	}

	private PdfPCell dottedDividedCell(float width) {
		PdfPCell dottedDivider = new PdfPCell();
		dottedDivider.setBorder(Rectangle.NO_BORDER);
		DottedLineSeparator dot = new DottedLineSeparator();
		dot.setPercentage(width);
		dot.setAlignment(Element.ALIGN_RIGHT);
		dottedDivider.addElement(dot);
		dottedDivider.setColspan(3);
		dottedDivider.setPaddingBottom(0f);
		dottedDivider.setPaddingLeft(0f);
		dottedDivider.setPaddingRight(0f);
		return dottedDivider;
	}
}
