package com.app.service;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.app.model.DiaryEvent;
import com.app.util.ReportDownloadUtil;

public class DownloadService {

	public static Scanner sc = new Scanner(System.in);

	public static void download(List<DiaryEvent> diaryEvent, int idCount) throws IOException {

		System.out.println("Event Date: ");
		String inut = sc.nextLine();
		String date = inut.replace("/", "");

		ReportDownloadUtil.downloadReport(diaryEvent, date, idCount);

	}

}
