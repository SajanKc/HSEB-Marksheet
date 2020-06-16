package com.sajan;

/**
 * Sajan Kc
 */

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfDocumentInfo;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.TabStop;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TabAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

public class HSEB_PDF {

	public static void main(String[] args) throws Exception {
		PdfFont fontFamilyMain = PdfFontFactory.createFont(FontConstants.HELVETICA);
		PdfFont fontFamily = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);

		PdfWriter pdfWriter = new PdfWriter("E:/IText/PDFDocuments/hseb_pdf.pdf");
		PdfDocument pdfDocument = new PdfDocument(pdfWriter);

		pdfDocument.addNewPage();
		Document document = new Document(pdfDocument);
		document.setFont(fontFamilyMain);

		// properties of PDF
		PdfDocumentInfo pdfDocInfo = pdfDocument.getDocumentInfo();
		pdfDocInfo.setTitle("HSEB_PDF");
		pdfDocInfo.setAuthor("Sajan Kc");
		pdfDocInfo.setCreator("Sajan Kc");
		pdfDocInfo.setKeywords("hseb , marksheet");
		pdfDocInfo.setSubject("MarkSheet");

		Paragraph top = new Paragraph("Issue No.");
		top.add(new Tab()).setFontSize(10);

		top.addTabStops(new TabStop(450, TabAlignment.RIGHT));
		top.add("HSEB Registration No. ");

		top.add(new Tab()).setFontSize(8);
		top.addTabStops(new TabStop(500, TabAlignment.RIGHT));
		top.add("702736330");

		document.add(top);

		String header = "HIGHER SECONDAY EDUCATION BOARD \n NEPAL";
		Paragraph preface = new Paragraph(header);
		preface.setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(20).setFixedLeading(20)
				.setFont(fontFamily);
		document.add(preface);

		String subHeading = "(Estd. Under the Higher Secondary Education Act, 1989) \n Academic Transcript";
		Paragraph subHead = new Paragraph(subHeading);
		subHead.setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(12).setFixedLeading(20).setMarginTop(-7)
				.setFont(fontFamily);
		document.add(subHead);

		// Student Info

		Paragraph studentInfo = new Paragraph("Name of the Student: SAJAN KC");
		studentInfo.setFontSize(10).add(new Tab()).setMarginTop(10).setMarginBottom(-5);
		studentInfo.addTabStops(new TabStop(350, TabAlignment.RIGHT));
		studentInfo.add("School:");

		document.add(studentInfo);

		Paragraph dob = new Paragraph("Date of Birth: 2053/03/17");
		dob.add(new Tab()).setFontSize(10);
		dob.addTabStops(new TabStop(100, TabAlignment.RIGHT));
		dob.add("ST. LAWRENCE H S SCHOOL,CHABAHIL, KATHMANDU");
		document.add(dob);

		// Adding table grade 11
		float[] pointColumnWidths = { 200F, 40F, 40F, 40F, 40F };
		Table table = new Table(pointColumnWidths);

		table.setFontSize(10);

		// Table Heading
		table.addCell(new Cell().add("Subjects").setBold().setVerticalAlignment(VerticalAlignment.MIDDLE)
				.setTextAlignment(TextAlignment.CENTER));
		table.addCell(new Cell().add("Full \n Marks").setVerticalAlignment(VerticalAlignment.MIDDLE)
				.setTextAlignment(TextAlignment.CENTER));
		table.addCell(new Cell().add("Pass \n Marks").setVerticalAlignment(VerticalAlignment.MIDDLE)
				.setTextAlignment(TextAlignment.CENTER));
		table.addCell(new Cell().add("Marks \n Secured").setVerticalAlignment(VerticalAlignment.MIDDLE)
				.setTextAlignment(TextAlignment.CENTER));
		table.addCell(new Cell().add("Remarks").setVerticalAlignment(VerticalAlignment.MIDDLE)
				.setTextAlignment(TextAlignment.CENTER));

		// Table CORE subject part
		table.addCell(new Cell().setHeight(60f).setBold().setFontSize(8).add("Grade XI\n\nEnglish\n\nNepali")
				.setPaddingLeft(5));
		table.addCell(new Cell().setHeight(60f).setBold().setFontSize(8).add("\n 100 \n\n 100")
				.setVerticalAlignment(VerticalAlignment.MIDDLE).setTextAlignment(TextAlignment.CENTER));
		table.addCell(new Cell().setHeight(60f).setBold().setFontSize(8).add("\n 35 \n\n 35")
				.setVerticalAlignment(VerticalAlignment.MIDDLE).setTextAlignment(TextAlignment.CENTER));
		table.addCell(new Cell().setHeight(60f).setFontSize(8).add("\n65 \n\n 70")
				.setVerticalAlignment(VerticalAlignment.MIDDLE).setTextAlignment(TextAlignment.CENTER));
		table.addCell(new Cell().setHeight(60f).setFontSize(8).add(" ").setVerticalAlignment(VerticalAlignment.MIDDLE)
				.setTextAlignment(TextAlignment.CENTER));

		// Table ELECTIVES subjects part

		table.addCell(new Cell().setHeight(120f).setFontSize(8)
				.add("\nACCOUNTANCY \n ECONOMICS \n COMPUTER SCIENCE  (TH) \n COMPUTER SCIENCE  (PR)")
				.setPaddingLeft(5));
		table.addCell(new Cell().setHeight(120f).setFontSize(8).add("\n 100 \n 100 \n 075 \n 025")
				.setTextAlignment(TextAlignment.CENTER));
		table.addCell(new Cell().setHeight(120f).setFontSize(8).add("\n35 \n 35 \n 27 \n 10")
				.setTextAlignment(TextAlignment.CENTER));
		table.addCell(new Cell().setHeight(120f).setFontSize(8).add("\n 75 \n 72 \n 57 \n 25")
				.setTextAlignment(TextAlignment.CENTER));
		table.addCell(new Cell().setHeight(120f).setFontSize(8).add(" "));

		// Grade XI total part
		table.addCell(new Cell().add("Total").setTextAlignment(TextAlignment.CENTER)
				.setVerticalAlignment(VerticalAlignment.MIDDLE));
		table.addCell(new Cell().add("500").setTextAlignment(TextAlignment.CENTER)
				.setVerticalAlignment(VerticalAlignment.MIDDLE));
		table.addCell(new Cell().add(" "));
		table.addCell(new Cell().add("364").setTextAlignment(TextAlignment.CENTER)
				.setVerticalAlignment(VerticalAlignment.MIDDLE));
		table.addCell(new Cell().add(" "));

		// Grade XII started
		// Table CORE subject part

		table.addCell(new Cell().setHeight(60f).setBold().setFontSize(8).add("Grade XII \n\n English \n\n Nepali")
				.setPaddingLeft(5));
		table.addCell(new Cell().setHeight(60f).setBold().setFontSize(8).add("\n 100 \n\n 100")
				.setVerticalAlignment(VerticalAlignment.MIDDLE).setTextAlignment(TextAlignment.CENTER));
		table.addCell(new Cell().setHeight(60f).setBold().setFontSize(8).add("\n 35 \n\n 35")
				.setVerticalAlignment(VerticalAlignment.MIDDLE).setTextAlignment(TextAlignment.CENTER));
		table.addCell(new Cell().setHeight(60f).setFontSize(8).add("\n\n 70").setTextAlignment(TextAlignment.CENTER));
		table.addCell(new Cell().setHeight(60f).setFontSize(8).add(" ").setVerticalAlignment(VerticalAlignment.MIDDLE)
				.setTextAlignment(TextAlignment.CENTER));

		// Table ELECTIVES subjects part

		table.addCell(new Cell().setHeight(120f).setFontSize(8).add(
				"\nACCOUNTANCY \n ECONOMICS \n COMPUTER SCIENCE  (TH) \n COMPUTER SCIENCE  (PR) \n BUSINESS MATHEMATICS")
				.setPaddingLeft(5));
		table.addCell(new Cell().setHeight(120f).setFontSize(8).add("\n 100 \n 100 \n 075 \n 025 \n 100")
				.setTextAlignment(TextAlignment.CENTER));
		table.addCell(new Cell().setHeight(120f).setFontSize(8).add("\n35 \n 35 \n 27 \n 10 \n 35")
				.setTextAlignment(TextAlignment.CENTER));
		table.addCell(new Cell().setHeight(120f).setFontSize(8).add("\n 74 \n 78 \n 69 \n 25 \n 94")
				.setTextAlignment(TextAlignment.CENTER));
		table.addCell(new Cell().setHeight(120f).setFontSize(8).add(" "));

		// Grade XII total part
		table.addCell(new Cell().add("Total").setTextAlignment(TextAlignment.CENTER)
				.setVerticalAlignment(VerticalAlignment.MIDDLE));
		table.addCell(new Cell().add("500").setTextAlignment(TextAlignment.CENTER)
				.setVerticalAlignment(VerticalAlignment.MIDDLE));
		table.addCell(new Cell().add(" "));
		table.addCell(new Cell().add("410").setTextAlignment(TextAlignment.CENTER)
				.setVerticalAlignment(VerticalAlignment.MIDDLE));
		table.addCell(new Cell().add(" "));

		// Grand Total
		table.addCell(new Cell().add("Grand Total").setBold().setVerticalAlignment(VerticalAlignment.MIDDLE)
				.setTextAlignment(TextAlignment.CENTER));
		table.addCell(new Cell().add("1000").setTextAlignment(TextAlignment.CENTER)
				.setVerticalAlignment(VerticalAlignment.MIDDLE));
		table.addCell(new Cell().add(" "));
		table.addCell(new Cell().add("774").setTextAlignment(TextAlignment.CENTER)
				.setVerticalAlignment(VerticalAlignment.MIDDLE));
		table.addCell(new Cell().add(" "));

		Paragraph p1 = new Paragraph();
		p1.add(new Text("\n\n\n Year of Completion: 2071 ( 2014 )"));

		p1.add(new Tab());
		p1.add(new Tab());
		p1.add(new Text("Checked by"));

		p1.add(new Tab());
		p1.add(new Tab());
		p1.add(new Text("Verified by"));

		Paragraph p2 = new Paragraph();
		p2.setMarginRight(10f);
		p2.setTextAlignment(TextAlignment.RIGHT);
		p2.add(new Text("(Deputy Controller)"));

		Paragraph p3 = new Paragraph();
		p3.add("Date of Issue: 2071/08/01");

		table.addCell(new Cell(1, 5).add(p1).add(p2).add(p3).setHeight(80f).setFontSize(8));

		document.add(table);

		Paragraph footer = new Paragraph();
		footer.add("Grading System").setUnderline().setFontSize(8).setMarginBottom(0);

		float[] invisibleTable = { 330f, 270f };
		Table footerTable = new Table(invisibleTable);
		footerTable.addCell(new Cell().add(footer)
				.add("75% and above - Distinction \n " + "60% and above - First division \n "
						+ "45% and above - Second division \n" + "35% and above - Pass division")
				.setBorder(Border.NO_BORDER).setFontSize(8));
		Paragraph f1 = new Paragraph();
		f1.add("Note: * means a student has passed in the second attempt.").setFontSize(8);

		Paragraph f2 = new Paragraph();
		f2.add("** means a student has passed in more than two attempts.").setMarginLeft(22f);

		footerTable.addCell(new Cell()
				.add("To pass the examination candicates must secure \n "
						+ "35% marks in theory and 40% marks in practical \n" + "papers, separately.")
				.add(f1).add(f2).setBorder(Border.NO_BORDER).setFontSize(8));

		document.add(footerTable);

		// Right Side Tables Grade XI
		float[] widths = { 60f, 100f };
		Table rightTableXI = new Table(widths);
		rightTableXI.setFontSize(10);

		rightTableXI.addCell(new Cell(1, 2).add("Grade XI").setBold());

		rightTableXI.addCell(new Cell().add("Year"));
		rightTableXI.addCell(new Cell().add("Symbol Number"));

		rightTableXI.addCell(new Cell().add("2070"));
		rightTableXI.addCell(new Cell().add("12709039"));

		for (int i = 0; i < 6; i++) {
			rightTableXI.addCell(new Cell().add(" ").setHeight(18f));
			rightTableXI.addCell(new Cell().add(" "));
		}

		rightTableXI.setFixedPosition(410f, 440f, 150f).setTextAlignment(TextAlignment.CENTER);

		document.add(rightTableXI);

		// Right Side Tables Grade XII

		float[] widthsXII = { 60f, 100f };
		Table rightTableXII = new Table(widthsXII);
		rightTableXII.setFontSize(10);
		rightTableXII.addCell(new Cell(1, 2).add("Grade XII").setBold());

		rightTableXII.addCell(new Cell().add("Year"));
		rightTableXII.addCell(new Cell().add("Symbol Number"));

		rightTableXII.addCell(new Cell().add("2071"));
		rightTableXII.addCell(new Cell().add("22708378"));

		for (int i = 0; i < 6; i++) {
			rightTableXII.addCell(new Cell().add(" ").setHeight(18f));
			rightTableXII.addCell(new Cell().add(" "));
		}

		rightTableXII.setFixedPosition(410f, 230f, 150f).setTextAlignment(TextAlignment.CENTER);

		document.add(rightTableXII);

		Paragraph rightText = new Paragraph();
		rightText.setFixedPosition(410f, 180f, 155f).add(
				"Percentage of aggregate marks secured in \n" + " Grade XI and XII : 77.40 \nDivision : Distinction")
				.setFontSize(8);
		document.add(rightText);

		Paragraph examinationController = new Paragraph();
		examinationController.setFixedPosition(450f, 115f, 155f).add("Controller of Examinations").setFontSize(8);
		document.add(examinationController);

		document.close();
		System.out.println("PDF created");
	}

}
