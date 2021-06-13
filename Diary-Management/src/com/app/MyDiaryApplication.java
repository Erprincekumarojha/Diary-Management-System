package com.app;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.app.model.DiaryEvent;
import com.app.service.AddEventService;
import com.app.service.DownloadService;
import com.app.service.EmailService;
import com.app.service.ListOfEventService;
import com.app.service.RemoveService;
import com.app.service.SearchEventService;
import com.app.util.ReportDownloadUtil;

public class MyDiaryApplication {

	static List<DiaryEvent> diaryEvent=new ArrayList<DiaryEvent>();
	static int idCount=0;
	

	public static void main(String[] args) throws IOException {
		while(true) {
			System.out.println("\n\n==========MAIN MENU==========");
			System.out.println("[1] Add events to diary");
			System.out.println("[2] List all events");
			System.out.println("[3] Search event by title, email, date");
			System.out.println("[4] Remove element by Id");
			System.out.println("[5] Download report as pdf by date (print in table using pdfbox)");
			System.out.println("[6] Send all event report as attachment to specified email");
			System.out.println("[0] Exit");

			Scanner sc = new Scanner(System.in);
			System.out.println("----------------------------------------------------------------------------");
			System.out.print("Enter Your Option : ");
			int i = sc.nextInt();

			switch(i){
			case 1 :
				System.out.print("Enter no of events: ");
				int n=sc.nextInt();

				for(int count=1;count<=n;count++) {
					System.out.println("----------------\nEnter  event : "+count+"\n----------------");
					diaryEvent.add(AddEventService.AddEvent(++idCount));

				}				
				break;
				
			case 2 :
				ListOfEventService.displayListOfEvents(diaryEvent);
				break;
				
			case 3 :
				SearchEventService.find(diaryEvent);
				break;
				
			case 4 :
				RemoveService.remove(diaryEvent);
				break;
				
			case 5 :
				if(idCount == 0) {
					try {
						throw new Exception();
					}
					catch (Exception e) {
						System.out.println("Please Add At least One Event...");
					}
				}
				else {
					DownloadService.download(diaryEvent,idCount);
				}
				break;
				
			case 6 :
				ReportDownloadUtil.downloadReport(diaryEvent, null, idCount);
				EmailService.sendEmailWithAttachment();
				break;
			case 0 :
				System.out.println("Exit");
				System.exit(0);
				break;
			default:
				System.out.println("Please Enter option 1 to 6 and 0 for Exit");
			}
		}
	}
}
