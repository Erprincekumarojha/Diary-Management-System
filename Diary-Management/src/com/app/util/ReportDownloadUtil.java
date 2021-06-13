package com.app.util;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3CharProc;
import org.apache.pdfbox.pdmodel.font.PDType3Font;

import com.app.model.DiaryEvent;

//*********PDFBox Adding Multiple Lines*********
public class ReportDownloadUtil {

	public static void downloadReport(List<DiaryEvent> diaryEvent, String date, int idCount) throws IOException  {
		//Creating PDF document object   
		PDDocument doc = new PDDocument();   

		//Adding a blank page to the Document
		doc.addPage(new PDPage());

		//Retrieving the pages of the document
		PDPage page = doc.getPage(0);

		
		//*****************************
		PDPageContentStream contentStream = new PDPageContentStream(doc, page);

		//Begin the Content stream
		contentStream.beginText();

		//Setting the font to the Content Stream
		contentStream.setFont(PDType1Font.TIMES_BOLD_ITALIC, 14);

		//Setting the leading  
		contentStream.setLeading(10);

		//Setting the position for the line
		contentStream.newLineAtOffset(30, 750);

		contentStream.showText("================================================================");
		contentStream.newLine();
		contentStream.showText("        ********************Diary Management Application********************");
		contentStream.newLine();
		contentStream.showText("================================================================");

		contentStream.newLine();
		contentStream.newLine();
		contentStream.newLine();

		//Setting the font to the Content Stream
		contentStream.setFont(PDType1Font.COURIER, 12);
		contentStream.showText("----------------------------------------------------------------------------");
		contentStream.newLine();
		contentStream.showText("Event ID  |  Title   |  Date  |  Address 1   |  Contact Number(Mobile)");
		contentStream.newLine();
		contentStream.showText("----------------------------------------------------------------------------");

		ListIterator<DiaryEvent> itr=diaryEvent.listIterator();
		while(itr.hasNext()) {

			DiaryEvent event=itr.next();
			contentStream.newLine();
			contentStream.showText(event.getId()+"      | "+event.getTitle()+"    | "+event.getDate()+"  | "+event.getAddress().getAddressline1()+"         | "+event.getContactInfo().getMobile());
			contentStream.newLine();
			contentStream.showText("----------------------------------------------------------------------------");

		}

		//Ending the Content Stream
		contentStream.endText();

		contentStream.close();

		//Saving the document
		String fileName=null;
		try {
			if(date!=null) {
				fileName = "Event"+date+".pdf";
				doc.save("P:/Project/Spring Boot Microservice/"+fileName);
				System.out.println("File "+fileName+" created with "+idCount+" records");
			}
			else {
				fileName = "allEvents.pdf";
				doc.save("P:/Project/Spring Boot Microservice/"+fileName);
				
			}
		}
		catch (Exception e) {
			System.out.println("Please close File "+fileName);
		}

		//Closing the document
		doc.close();
	}
}
